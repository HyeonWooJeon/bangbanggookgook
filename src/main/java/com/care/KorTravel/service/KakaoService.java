package com.care.KorTravel.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class KakaoService {
	public String getAccessToken(String code) {
		String accessToken = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";
		try {
			String sendMessage = "grant_type=authorization_code" + 
						"&client_id=41af3522bd71f40b96c20b2376771225"
					+ "&redirect_uri=http://localhost/kakaoLogin" + "&code=" + code;

			URL url = new URL(reqURL); // POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST"); // POST 요청을 위해 기본값 false에서 setDoOutput을 true로 변경
			conn.setDoOutput(true); // POST 메소드를 이용해서 데이터를 전달하기 위한 설정

			// 기본 outputStream을 통해 문자열로 처리할 수 있는 OutPutStreamWriter 변환 후 처리속도를 빠르게 하기위한
			// BufferedWriter로 변환해서 사용한다.
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			bw.write(sendMessage);
			bw.flush();

			int responseCode = conn.getResponseCode(); // 결과 코드가 200이라면 성공
			System.out.println("responseCode : " + responseCode);

			// 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "", result = "";
			while ((line = br.readLine()) != null) {
				result += line;
			}

			System.out.println("response body : " + result);
//			System.out.println("result.split : " + result.split(","));

			// Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
			JsonElement element = JsonParser.parseString(result);
			accessToken = element.getAsJsonObject().get("access_token").getAsString();
			System.out.println("access_token : " + accessToken);

			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return accessToken;
	}

	public HashMap<String, String> getUserInfo(String accessToken) {
		HashMap<String, String> userInfo = new HashMap<String, String>();
		String reqURL = "https://kapi.kakao.com/v2/user/me";

		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");

			// 요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);

			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";
			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);
			/*
				{"id":2526896915,"connected_at":"2022-11-15T12:51:26Z",
				  "properties":{"profile_image":"http://k.kakaocdn.net/dn/zcXqU/btrj5c14A57/ctUf1uVwPU25elTuBHYI7K/img_640x640.jpg",
				  "thumbnail_image":"http://k.kakaocdn.net/dn/zcXqU/btrj5c14A57/ctUf1uVwPU25elTuBHYI7K/img_110x110.jpg"},
				  "kakao_account":{"profile_image_needs_agreement":false,
				  "profile":{"thumbnail_image_url":"http://k.kakaocdn.net/dn/zcXqU/btrj5c14A57/ctUf1uVwPU25elTuBHYI7K/img_110x110.jpg",
				  "profile_image_url":"http://k.kakaocdn.net/dn/zcXqU/btrj5c14A57/ctUf1uVwPU25elTuBHYI7K/img_640x640.jpg",
				  "is_default_image":false},"has_email":true,"email_needs_agreement":false,
				  "is_email_valid":true,"is_email_verified":true,
				  "email":"minamzzzzz@nate.com","has_gender":true,
				  "gender_needs_agreement":false,"gender":"male"}}
			 */
			JsonElement element = JsonParser.parseString(result);
//	        JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
//	        String nickname = properties.getAsJsonObject().get("nickname").getAsString();
			String id = element.getAsJsonObject().get("id").getAsString();
			JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
			JsonObject profile = kakao_account.getAsJsonObject().get("profile").getAsJsonObject();
			String image = profile.getAsJsonObject().get("thumbnail_image_url").getAsString();
			
			String email = kakao_account.getAsJsonObject().get("email").getAsString();
			
			String gender = kakao_account.getAsJsonObject().get("gender").getAsString();
			
			userInfo.put("gender", gender);
			userInfo.put("image", image);
			userInfo.put("id", id);
			userInfo.put("email", email);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInfo;
	}
	//카카오 로그아웃이긴한데 별 차이없음
	public void logout(String accessToken) {
		String reqURL = "https://kapi.kakao.com/v1/user/logout";

		URL url;
		try {
			url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			// 요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//회원연결 끊어버림
	public void unlink(String accessToken) {
		String reqURL = "https://kapi.kakao.com/v1/user/unlink";

		URL url;
		try {
			url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			// 요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
