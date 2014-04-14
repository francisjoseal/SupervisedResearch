package com.twitter.sample;

//import the bit.ly API
import com.rosaloves.bitlyj.Url;
import static com.rosaloves.bitlyj.Bitly.*;

public class URLShortner {
	public String bitly_shorten(String lurl){
		Url url = as("francisjoseal", "R_b1f20638c9ba4315b8c982387085967b").call(shorten(lurl));
				return url.getShortUrl();
	}

}
