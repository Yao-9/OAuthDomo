package main;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GoogleAPI {
	private static final String clientID = "979484502896-a7pjq3r1ksmprminduh5b31t445l6n86.apps.googleusercontent.com";
	private static final String clientSecret = "bT9Xb0cPRIFQcbLpZiRy5k2w";

	public static String exchangeTokenByCode(String accessCode) {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(
				"https://accounts.google.com/o/oauth2/token");
		List<NameValuePair> pairs = new ArrayList<>();
		pairs.add(new BasicNameValuePair("code", accessCode));
		pairs.add(new BasicNameValuePair("client_id", clientID));
		pairs.add(new BasicNameValuePair("client_secret", clientSecret));
		pairs.add(new BasicNameValuePair("redirect_uri",
				"http://www.google.com"));
		pairs.add(new BasicNameValuePair("grant_type", "authorization_code"));
		String responseString = "";
		try {
			post.setEntity(new UrlEncodedFormEntity(pairs));
			HttpResponse response = client.execute(post);
			responseString = EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(responseString);
		return getValueByKeyAndStringJSON(responseString, "refresh_token");
	}
	
//	public static String getNewAccessTokenByRefreshToken(String refreshToken) {
//		HttpsURLConnection client = new HttpsURLConnection();
//		HttpPost post = new HttpPost(
//				"https://www.googleapis.com/oauth2/v3/token");
//		List<NameValuePair> pairs = new ArrayList<>();
//		pairs.add(new BasicNameValuePair("refresh_token", refreshToken));
//		pairs.add(new BasicNameValuePair("client_id", clientID));
//		pairs.add(new BasicNameValuePair("client_secret", clientSecret));
//		pairs.add(new BasicNameValuePair("grant_type", "refresh_token"));
//		String responseString = "";
//		try {
//			post.setEntity(new UrlEncodedFormEntity(pairs));
//			HttpResponse response = client.execute(post);
//			responseString = EntityUtils.toString(response.getEntity());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println(responseString);
//		return getValueByKeyAndStringJSON(responseString, "access_token");
//	}
	
	private static String getValueByKeyAndStringJSON(String jsonStr, String key) {
		JSONObject jsono = new JSONObject(new JSONTokener(jsonStr));
		return jsono.getString(key);
		
	}
}
