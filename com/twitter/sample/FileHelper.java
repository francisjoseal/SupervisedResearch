package com.twitter.sample;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Properties;
import java.net.URLEncoder;

public class FileHelper {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Properties prop= new Properties();
		//OutputStream output = null;
		File f =null;
		//String filename=null;
		try{
			//output = new FileOutputStream("config.properties");
			//filename=prop.getProperty("fn");
			//String fpath="C:\\Users\\Francis Alappat\\Desktop\\domain_feb_URLS.txt";
			//FileHelper.FileURLEncode(fpath);
			BufferedReader br= new BufferedReader(new FileReader("C:\\Users\\Francis Alappat\\Desktop\\domain_feb_URLS.txt"));
			String line;
			int count=0;
			while((line=br.readLine())!=null){
				//ShortnerTest.urlshortner(line);
				ShortnerTest.urlShortReq(line);
				count++;
				if(count==99){ 
					System.out.println(count);
					System.out.println(line);
					count=0;
					System.out.println("Sleeping for 15 seconds before reconnect...");
					try{
					Thread.sleep(15000);
					}
					catch(InterruptedException ex){
					System.out.println("Thread Interrupted!");	
					}
				}
					}
			
			br.close();
		}
		catch(Exception ex){
			
		}
		
		
	}
	//trim extra spaces and URL encode the input file
	public static void FileURLEncode(String spath){
		String var[]= spath.split("\\.");
		var[0]=var[0].concat("_Encoded.txt");
		File p = new File(spath);
		try{
		if(p.exists() && p.canRead() && p.isFile()) {
			File d = new File(var[0]);
			if(!d.exists()){
				d.createNewFile();
				if(d.canWrite()){
					BufferedReader br = new BufferedReader(new FileReader(p));
					BufferedWriter bw = new BufferedWriter(new FileWriter(d));
					String line=null;
					while((line=br.readLine())!=null){
						bw.write(URLEncoder.encode(line.trim(), "US-ASCII")+"\n");
					}
					br.close();
					bw.close();
				}
				else
					abort("destination file is unwriteable: " + spath);
			}
				else abort("Destination file already exists!"+var[0].toString());	        
								
			}else abort("File Error! Please check!");
			
		}catch(Exception ex){
			System.out.println(ex);
		}
		
		
	}
	  private static void abort(String msg) throws IOException { 
	        throw new IOException("FileCopy: " + msg); 
	    }
	}
