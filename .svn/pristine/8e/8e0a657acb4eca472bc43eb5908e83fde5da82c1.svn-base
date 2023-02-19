package com.care.KorTravel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.HashMap;

import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.care.KorTravel.dto.MemberDTO;
import com.care.KorTravel.service.KakaoService;
import com.care.KorTravel.service.MemberServiceImpl;
import com.care.KorTravel.service.NaverLoginService;
import com.github.scribejava.core.model.OAuth2AccessToken;


import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;


@Controller
public class MemberController {
	
	@Autowired MemberServiceImpl memberservice;
	@Autowired HttpSession session;
	
	
	@ResponseBody
	@PostMapping(value="isExistId", produces="text/html; charset=UTF-8")
	public String isExistId(@RequestBody(required = false) String id) {
		
		if(id==null) {
			return "아이디를 입력하세요";
		}
		MemberDTO memberDto = new MemberDTO();
		memberDto.setId(id);
		int result = memberservice.login(memberDto);
		if(result==0) {
			return "사용가능한 아이디입니다";
		}
		else {
			return "이미 등록되어 있는 아이디입니다";
		}
	}
	@ResponseBody
	@PostMapping(value="loginCheck", produces="application/json; charset=UTF-8")
	public String loginCheck(@RequestBody(required = false) Map<String,String> map, HttpServletRequest req) throws IOException {
		System.out.println(map.get("id"));
		System.out.println("비밀번호 : " + map.get("pw"));
		if(map.get("id")=="" || map.get("pw")=="") {
			return "아이디 또는 비밀번호를 입력하세요";
		}
		MemberDTO memberDto = new MemberDTO();
		memberDto.setId(map.get("id"));
		memberDto.setPw(map.get("pw"));
		String result = memberservice.loginCheck(memberDto);
		if(result.equals("아이디 또는 비밀번호가 맞지 않습니다.")) {
			return result;
		}
		else if(result.equals("아이디 또는 비밀번호가 맞지 않습니다.")) {
			return result;			
		}
		else if(result.equals("탈퇴한 회원의 아이디입니다")) {
			return result;
		}
		else {
			
			 String ipAddress=req.getRemoteAddr();
			 if(ipAddress.equalsIgnoreCase("0:0:0:0:0:0:0:1")){
			     InetAddress inetAddress=InetAddress.getLocalHost();
			     ipAddress=inetAddress.getHostAddress();
			 }

			 
			 System.out.println("클라이언트IP 주소: "+ipAddress);
			 System.out.println("접속국가 : "+Locale.getDefault().getCountry());
			 

			 session.setAttribute("id", map.get("id"));
			
			memberservice.lastAccess(ipAddress,Locale.getDefault().getCountry(),Locale.getDefault().getDisplayCountry(Locale.KOREA));
			
			return "로그인 성공";
		}
	}
	
	@RequestMapping(value = "member_register", produces = "text/html; charset=UTF-8")
	public String member_register(MemberDTO member, RedirectAttributes ra) {
		String msg=null;
		
		if(member==null) {
			msg="오류가 발생하여 등록에 실패하였습니다";
			ra.addFlashAttribute("msg",msg);
			return "redirect:register";
		}
		else if(session.getAttribute("authNumber")==null||session.getAttribute("authStatus").equals(false)) {
			msg ="이메일 인증을 해주시기 바랍니다";
			ra.addFlashAttribute("msg",msg);
			return "redirect:register";
		}
		if(session.getAttribute("APIprofile_image")!=null) {
		member.setProfilePhoto((String)session.getAttribute("APIprofile_image"));}
		String result = memberservice.member_register(member);
		session.invalidate();
		ra.addFlashAttribute("msg",result);
		return "redirect:main";
	}
		
	@RequestMapping(value="logout")
	public String logout(RedirectAttributes ra,@RequestParam(value="out", required=false, defaultValue="y")String out) {
		String accessToken = (String)session.getAttribute("accessToken");
		session.invalidate();
		
		if(accessToken!=null) {
			kakaoService.unlink(accessToken);
		}
		if(out.equals("no")) {
			ra.addFlashAttribute("msg", "회원정보가 수정되었습니다. 다시 로그인해주세요.");
		}
		return "redirect:main";
	}
	
	@Autowired KakaoService kakaoService;
	@GetMapping("kakaoLogin")
	public String kakaoLogin(String code, HttpServletRequest req) throws UnknownHostException {
		
		System.out.println("인가코드 :"+ code);
		
		String accessToken = kakaoService.getAccessToken(code);
		HashMap<String, String> userInfo = kakaoService.getUserInfo(accessToken);
		System.out.println("이메일 : " + userInfo.get("email"));
		System.out.println("성별 : " + userInfo.get("gender"));
		System.out.println("아이디 : " + userInfo.get("id"));
		System.out.println("사진 : " + userInfo.get("image"));
		
		session.setAttribute("accessToken", accessToken);
		if(userInfo.isEmpty()) {
			return "main.user";
		}
		MemberDTO memberDto = new MemberDTO();
		String a = userInfo.get("email");
		String[] email = a.split("@");
		memberDto.setId(a);
		int result = memberservice.login(memberDto);
		 if(result==0) {
			
			 session.setAttribute("APIId", a);
			 session.setAttribute("APIEmail", userInfo.get("email"));
			 session.setAttribute("APIGender", userInfo.get("gender"));
			 session.setAttribute("APIprofile_image", userInfo.get("image"));
	
			return "redirect:register";
		}
		 String ipAddress=req.getRemoteAddr();
		 if(ipAddress.equalsIgnoreCase("0:0:0:0:0:0:0:1")){
		     InetAddress inetAddress=InetAddress.getLocalHost();
		     ipAddress=inetAddress.getHostAddress();
		 }
		 System.out.println("클라이언트IP 주소: "+ipAddress);
		 System.out.println("접속국가 : "+Locale.getDefault().getCountry());
		 
		 session.setAttribute("id", email[0]);

		memberservice.lastAccess(ipAddress,Locale.getDefault().getCountry(),Locale.getDefault().getDisplayCountry(Locale.KOREA));
		return "redirect:main";
	}
	
	
	//네이버 로그인 성공시 callback호출 메소드
	@Autowired NaverLoginService naverLoginService;
	@RequestMapping(value = "callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, HttpServletRequest req,@RequestParam String code, @RequestParam String state, HttpSession session) throws IOException, ParseException {
		String apiResult = null;
		
		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
        oauthToken = naverLoginService.getAccessToken(session, code, state);
 
        //1. 로그인 사용자 정보
		apiResult = naverLoginService.getUserProfile(oauthToken);  //String형식의 json데이터
		System.out.println(apiResult);
		if(apiResult==null||apiResult=="") {
			return "main.user";
		}
		
		//2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(apiResult);
		
		JSONObject jsonObj = (JSONObject) obj;
		
		//3. 데이터 파싱 
		//Top레벨 단계 _response 파싱
		JSONObject response_obj = (JSONObject)jsonObj.get("response");
		
		String fullEmail = (String)response_obj.get("email");
		
		
		//4.카카오와 동일하게 이메일의 @앞에만 사용할 것이기 때문에 split.
		String[] email = fullEmail.split("@");
		
		//5.db check
		MemberDTO memberDto = new MemberDTO();
		
		memberDto.setId(fullEmail);
		
		//결과값 0 또는 1 반환 (0==없음, 1==이미 가입되어 있음)
		int result = memberservice.login(memberDto);
		String profile_image = (String)response_obj.get("profile_image");
		String gender = (String)response_obj.get("gender");
		String mobile = (String)response_obj.get("mobile");
		try {
			session.setAttribute("APIGender", gender);
			session.setAttribute("APImobile", mobile);
			session.setAttribute("APIprofile_image", profile_image);
			
		} catch (Exception e) {
			System.out.println("뭔가 문제가 있음");
			
		}
		
		//존재하지 않으면 사용가능한 정보들을 가지고 회원가입창으로 이동
		if(result==0) { 
		session.setAttribute("APIId", fullEmail);
		 session.setAttribute("APIEmail", fullEmail);
		 
		 return "redirect:register";
		}
		//파싱 email[0] 세션으로 저장 후 메인페이지
		
		session.setAttribute("id", email[0]);
		 String ipAddress=req.getRemoteAddr();
		 if(ipAddress.equalsIgnoreCase("0:0:0:0:0:0:0:1")){
		     InetAddress inetAddress=InetAddress.getLocalHost();
		     ipAddress=inetAddress.getHostAddress();
		 }
		 session.setAttribute("id", email[0]);
		 System.out.println("클라이언트IP 주소: "+ipAddress);
		 System.out.println("접속국가 : "+Locale.getDefault().getCountry());
		 

		memberservice.lastAccess(ipAddress,Locale.getDefault().getCountry(),Locale.getDefault().getDisplayCountry(Locale.KOREA));
	     
		return "redirect:main";
	}


	@RequestMapping(value="setting_Pw")
	public String setting_Pw() {
		return "member/setting_Pw.user";
	}
	@PostMapping(value="edit_Pw")
	public String edit_Pw(String new_Pw, RedirectAttributes ra) {
		MemberDTO member = new MemberDTO();
		member.setEmail((String)session.getAttribute("email"));
		member.setPw(new_Pw);
		int result = memberservice.edit_Pw(member);
		if(result==0) {
			ra.addFlashAttribute("msg", "비밀번호 변경에 실패하였습니다. 다시 시도해주세요");
			return "redirect:setting_Pw";
		}
		else {
			
			return "redirect:settingPw";
		}
	}
	@RequestMapping(value="settingPw")
	public String settingPw(RedirectAttributes ra) {
		String accessToken = (String)session.getAttribute("accessToken");
		session.invalidate();
		ra.addFlashAttribute("msg", "비밀번호가 변경되었습니다. 다시 로그인해주세요");
		if(accessToken!=null) {
			kakaoService.unlink(accessToken);
		}
		return "redirect:main";
	}
}	