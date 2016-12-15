package ftn.uns.ac.rs.tim6.service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.dto.PaymentUrlIdDto;

@Service
@Transactional
public class BankService {

	public PaymentUrlIdDto getPaymentUrlAndId(Double suma) {
		
		System.out.println("usao u bankService ");
		PaymentUrlIdDto puid = new PaymentUrlIdDto();
		
		try {
			
			String urlString = "http://localhost:7070/api/urlid";
			URL url = new URL(urlString);
			
			System.out.println("usao u bankService odradio url");

			String urlParameters = "suma=" + suma;
			
			System.out.println("usao u bankService parametri " + urlParameters);
			
			byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
			int postDataLength = postData.length;

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("charset", "utf-8");
			conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			conn.setUseCaches(false);
			
			try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
				System.out.println("usao u bankService wr: " + wr);
				wr.write(postData);
			}
			
			
			System.out.println("usao u bankService postData: " + postData);
			System.out.println("usao u bankService ");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		puid.setPaymentId(BigInteger.valueOf(5));
		puid.setUrl("http://localhost:7070/api");

		return puid;

	}

}
