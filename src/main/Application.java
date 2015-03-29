package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;

public class Application {

	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		String accessCode = "4/uOVwYe3yuoit0aEPPfnDw1WHmxV5iGoQAty7caGp4OE.oml0GUv4-IIXXmXvfARQvtgwtOLNmAI&gws_rd";
		String refreshToken = GoogleAPI.exchangeTokenByCode(accessCode);
//		String refreshToken = "1/dloFEpIDYwhCJHOfPXKaqq_oSJvBmkjb8f3Jpdy_LCUMEudVrK5jSpoR30zcRFq6";
//		String accessToken = GoogleAPI.getNewAccessTokenByRefreshToken(refreshToken);
//		System.out.println(accessToken);
	}
}