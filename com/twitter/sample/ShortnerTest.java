package com.twitter.sample;
import static com.rosaloves.bitlyj.Bitly.as;
import static com.rosaloves.bitlyj.Bitly.shorten;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.rosaloves.bitlyj.Url;


public class ShortnerTest {
	
	public static final String BITLY="https://api-ssl.bitly.com/v3/shorten?access_token=afb3d22e503a98787167dd81ed78d618c75e464c&longUrl=";
	
	public static void main(String args[]){
		String Longurl = "https://dev.twitter.com/docs/rate-limiting/1#search";
		urlshortner(Longurl);
	}
	public static void urlshortner(String url){
		//BufferedWriter bw= new BufferedWriter(new FileWriter("C:\\Users\\Francis Alappat\\Documents\\MIS_Buffalo\\Class Docs\\Spring 2014\\Supervised Research\\Files\\Milestone 2\\Francis\\run1.text"));
		//String shurl=null;
		//HttpResponse res = new H
		Url surl = as("francisjoseal", "R_b1f20638c9ba4315b8c982387085967b").call(shorten(url.trim()));
		//shurl=surl.getShortUrl();
		//FileWriter fw = new FileWriter(new FileOutputStream(surl.getShortUrl()));
		System.out.println(surl.getShortUrl());
		
		
	}
	public static void urlShortReq(String url){
		String aurl = url.trim().concat("&format=json");
		url = BITLY.concat(aurl);
		int rateLimit=0;
		HttpGet gReq = new HttpGet(url);
		HttpClient client = HttpClientBuilder.create().build();
		try {
			HttpResponse response = client.execute(gReq);
			BufferedReader reader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Francis Alappat\\Desktop\\domain_feb_URLS_short.txt",true));
            while (true) {
            	if(rateLimit>=5)
					try {
						Thread.sleep(120000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                String line = reader.readLine();
                if (line == null)
                    break;
                if (line.length() > 0) {
                    bw.write(line+"\n"); 
                    if(line.contains("RATE_LIMIT_EXCEEDED"))
                    	rateLimit++;
                }
            }
            bw.close();
            reader.close();
             
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
