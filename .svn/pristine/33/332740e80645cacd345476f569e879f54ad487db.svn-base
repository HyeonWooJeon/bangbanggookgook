package com.care.KorTravel.adminController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.json.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.KorTravel.adminDAO.DataManageDAO;
import com.care.KorTravel.adminDAO.DataRenewalDAO;
import com.care.KorTravel.adminDAO.NoticeManageDAO;
import com.care.KorTravel.adminService.LoginServiceImpl;
import com.care.KorTravel.dto.FacilityDTO;
import com.care.KorTravel.dto.MemberDTO;


@Controller
public class Admin_MainController {

	@Autowired private HttpServletRequest req;
	@Autowired private HttpSession session;
	@Autowired private DataRenewalDAO dao;
	@Autowired private LoginServiceImpl svc;
	
	@GetMapping("admin/main")
	public String adminMain(RedirectAttributes ra) { return "admin/login"; }
	
	@RequestMapping("admin")
	public String admin() {
		session.removeAttribute("verifyAdmin");
		return "admin/login"; 
	}
	
	@GetMapping("admin/login")
	public void adminLogin() {}
	
	@RequestMapping("admin/logoClick")
	public String logoClick() {
		session.removeAttribute("verifyAdmin");
		return "redirect:/main"; 
	}
	
	@ResponseBody
	@PostMapping(value = "verify", produces = "text/html; charset = UTF-8")
	public String verify(@RequestBody(required = false)String data) {
		String[] datas = data.split(",");
		MemberDTO member = new MemberDTO();
		member.setId(datas[0]);
		member.setPw(datas[1]);
		
		String loginVerify = svc.login(member);
		if (loginVerify.equals("허용")) {
			if (datas[0].equals("admin") && datas[1].equals("rhksflwk123"))
			return "허용";
		}
		
		return "거부";
	}
	
	@RequestMapping("admin/logout")
	public String logout() {
		session.removeAttribute("verifyAdmin");
		return "redirect:/admin/login";
	}
	
	
	@ResponseBody
	@PostMapping(value = "getData", produces = "text/html; charset=UTF-8")
	public String getAPIData(@RequestBody String cat1) throws IOException {
		System.out.println("cat1 : " + cat1);
		BufferedReader br = null;
		String result, viewContentId, viewTitle, viewCnt;
		
		JSONParser jp = new JSONParser();
		JSONObject jo, response, body, items;
		JSONArray itemArray;
		
		ArrayList<String> SIGUNGU = new ArrayList<>();
		ArrayList<String> areaCodeList = new ArrayList<>();

		try {
			int i = 1;
			while(true) {
				if (i == 5) break;
				URL url = new URL
				(
					"http://apis.data.go.kr/B551011/KorService/areaBasedList" +
					"?serviceKey=mB8%2FzNLEcyXpSHUWsmLqIrogM7pysp4EyaOOO73BR1LKqudGET%2BOz99V8f0kPTLDYl9Wikee5CgBfgG%2BPwQq5g%3D%3D" + 
					"&cat1=A05" + 
					"&numOfRows=1000" + 
					"&pageNo=" + i +
					"&MobileOS=ETC" + 
					"&MobileApp=AppTest" +
					"&_type=json"
				);
				
				br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
				result = br.readLine();
				
				jo = (JSONObject)jp.parse(result);
				response = (JSONObject)jo.get("response");
				body = (JSONObject)response.get("body");
				
//				 데이터 조회 종료시 while문 break;
				try {
					items = (JSONObject)body.get("items");
				} catch (Exception e) {
					break;
				}
				
				itemArray = (JSONArray)items.get("item");
				ArrayList<FacilityDTO> datas = new ArrayList<>();
				
				for (int cnt = 0; cnt < itemArray.size(); cnt++) {
					FacilityDTO fd = new FacilityDTO();
					HashMap<String, String> tmp = (HashMap<String, String>)itemArray.get(cnt);
					fd.setAddr1(tmp.get("addr1"));
					fd.setAddr2(tmp.get("addr2"));
					fd.setAreaCode(tmp.get("areacode"));
					fd.setCat1(tmp.get("cat1"));
					fd.setCat2(tmp.get("cat2"));
					fd.setCat3(tmp.get("cat3"));
					System.out.println("contentId : " + tmp.get("contentid"));
					fd.setContentId(tmp.get("contentid"));
					fd.setFirstImage(tmp.get("firstimage"));
					fd.setFirstImage2(tmp.get("firstimage2"));
					fd.setMapX(tmp.get("mapx"));
					fd.setMapY(tmp.get("mapy"));
					fd.setmLevel(tmp.get("mlevel"));
					fd.setSigunguCode(tmp.get("sigungucode"));
					fd.setTel(tmp.get("tel"));
					fd.setTitle(tmp.get("title"));
					fd.setZipcode(tmp.get("zipcode"));
					datas.add(fd);
				}
				dao.data(datas);
				System.out.println("i : " + i);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
//		try {
//				ArrayList<Integer> contentIdList = dao.getContentId();
//				
//				// 양희수 : serviceKey=mB8%2FzNLEcyXpSHUWsmLqIrogM7pysp4EyaOOO73BR1LKqudGET%2BOz99V8f0kPTLDYl9Wikee5CgBfgG%2BPwQq5g%3D%3D
//				// 박문송 : serviceKey=sjZvXvdQDKdHPWHE4Dvpln53BiU6rRHxTl3iFuP9t5L5qrWYFtbK65ogD5iUEjhBMNQa5ueqcaqyw9eNI%2B8mwg%3D%3D
//				// 김정하 : serviceKey=hnm%2FOWUpuMvIRaxfHM%2FxUF2%2BOVxGvqO9MMVWNuyigK56Ffqpq8YC%2FK9m9KxaiHlEf2bx1QbVzeqea2Utc8CZ8A%3D%3D
//				// 이수안 : serviceKey=b8np9Fr3I7aWEksOBz40ydK14jg3RavzSuRQ%2FP8xFMbfDxrE6KSevyE0Fz3IZbtE0kdKj30wGcpb7fssyu0dzw%3D%3D
//				// 전현우 : serviceKey=iQijjshYFBswHbll4%2BJuEzBBD6PL9LIvo8e2CuYlLOk032NTygCnUoZe0WGp2FzUroM6JeXW4vs5ZRQWz%2BqA9Q%3D%3D
//				// 29843번
//				for (int cnt = 29843; cnt < contentIdList.size(); cnt++) {
//					System.out.println("contentId : " + contentIdList.get(cnt));
//					URL url = new URL
//					(
//						"http://apis.data.go.kr/B551011/KorService/detailCommon?" + 
//						"serviceKey=iQijjshYFBswHbll4%2BJuEzBBD6PL9LIvo8e2CuYlLOk032NTygCnUoZe0WGp2FzUroM6JeXW4vs5ZRQWz%2BqA9Q%3D%3D" + 
//						"&numOfRows=1" + 
//						"&pageNo=1" + 
//						"&MobileOS=ETC" + 
//						"&MobileApp=AppTest" + 
//						"&contentId=" + contentIdList.get(cnt) +  
//						"&overviewYN=Y" + 
//						"&_type=json"
//					);
//					
//					br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
//					result = br.readLine();
//					
//					jo = (JSONObject)jp.parse(result);
//					response = (JSONObject)jo.get("response");
//					body = (JSONObject)response.get("body");
//					
//					try {
//						items = (JSONObject)body.get("items");
//					} catch (Exception e) {
//						continue;
//					}
//					
//					itemArray = (JSONArray)items.get("item");
//					HashMap<String, String> tmp = (HashMap<String, String>)itemArray.get(0);
//					
//					dao.insertOverview(tmp.get("overview"), contentIdList.get(cnt));
//					System.out.println("cnt : " + cnt);
//				}
//				
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "admin/data";
	}
	@RequestMapping("layout2")
	public String layout2() {
		return "layout/adminLayout/layout.admin";
	}
}
