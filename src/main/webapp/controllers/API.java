/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 *
 * @author DMHT
 */
public class API {

    private static HttpURLConnection con;

    
    public void sendGet() throws Exception {
    //String url = "http://localhost:9090/users";
       try {

		URL url = new URL("http://localhost:9090/visiotime/users");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }

	}
    
    public boolean login(String email, String password) throws Exception {
    //String url = "http://localhost:9090/users";
    String output = null;
       try {

		URL url = new URL("http://192.168.1.100:9090/visiotime/getuser?email=" + email + "&password=" + password);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		output = br.readLine();
                
		System.out.println("Output from Server .... \n");
                System.out.println(output);
		
		conn.disconnect();
                
	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
       if(output.equals("true")){
       return true;
       }else{
       return false;
       }

	}
    
    public String LoadUsers() throws Exception {
    //String url = "http://localhost:9090/users";
    String output = null;
       try {

		URL url = new URL("http://localhost:9090/visiotime/users");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

                while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		//output = br.read();
                
		System.out.println("Output from Server .... \n");
                System.out.println(output);
		
		conn.disconnect();
                
	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
       System.out.println(output);
       return output;

	}
}
