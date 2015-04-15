package com.compmon.component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.compmon.daoimpl.*;
import com.compmon.model.Component;

public class Test {

	@SuppressWarnings("null")
	public static void main(String[] args) throws Exception{
		
		HashMap<String, String> componentDetails = new HashMap<String, String>();
		ComponentDaoImpl obj = new ComponentDaoImpl();
		/*componentDetails = obj.getComponentsByFilter("ASDA", "PROD", "Estore", "oses4004", "atg01");
		System.out.println("Component Name | Component Verison ");
		System.out.println("-----------------------------------------------");
		
		for (Map.Entry<String, String> entry : componentDetails.entrySet()) {
		String compName = entry.getKey();
		String compVersion = entry.getValue();
		System.out.println(compName + " | " + compVersion);
		}*/
		/*ArrayList<Component> allComponents = new ArrayList<Component>();
		Component component;
		allComponents = obj.getAllComponentsByFilter("ASDA", "PROD", "Estore");
		for (int i=0; i < allComponents.size(); i++) {
			component= allComponents.get(i);
			System.out.println(component.getTenant() +", " + component.getEnvironment() + ", " + component.getApplication() + ", " + component.getBox() + ", " + component.getInstance()+
							", " + component.getComponentName() + ", " + component.getComponentVersion());
		}*/
		
		
		/*
		 * Read from a url and check for any desire word.
		 */
		
		/*//URL reader = new URL("http://oses4004.wal-mart.com:40181/asda-estore/healthcheck/testenv.jsp");
		URL reader = new URL("http://stgs4074.wal-mart.com:30181/asda-estore/healthcheck/testenv.jsp");
		
        BufferedReader in = new BufferedReader(
        new InputStreamReader(reader.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null){  // System.out.println(inputLine);
        	if(inputLine.matches(".*\\bFailure\\b.*")){
        		System.out.println("Failure Found...");
        		break;
        	}
        }
        
        in.close();
        */
		
        /*
		 * Read from a url and check for any desire word [over].
		 */
		boolean check = obj.checkFailure("http://oses4004.wal-mart.com:40181/asda-estore/healthcheck/testenv.jsp");
		System.out.println("status : " + check);
	
	}

}
