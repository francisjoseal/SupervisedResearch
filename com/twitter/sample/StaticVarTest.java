package com.twitter.sample;

public class StaticVarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		StaticVarTest.loop();

	}
	public static void loop(){
		int s=5;
		int k=10;
		for(int i=0;i<=5;i++){
			s++;k++;
			System.out.println("s="+s+" "+"k="+k);
		}
	}

}
