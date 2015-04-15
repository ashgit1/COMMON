package com.compmon.daoimpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.compmon.dao.ComponentDao;
import com.compmon.model.Component;
import com.compmon.util.DBUtil;

public class ComponentDaoImpl implements ComponentDao{

	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	boolean insertResult;
	boolean checkFailureStatus;
	
	@Override
	public boolean insertComponent(Component component) {
		
		try{
		    con=DBUtil.getCon();
			ps=con.prepareStatement("insert into COMPONENTS(Tenant, Environment, Application, Box, Instance, ComponentName, ComponentVersion, ComponentUrl) " +
						"values(?,?,?,?,?,?,?,?)");
			
			ps.setString(1, component.getTenant());
			ps.setString(2, component.getEnvironment());
			ps.setString(3, component.getApplication());
			ps.setString(4, component.getBox());
			ps.setString(5, component.getInstance());
			ps.setString(6, component.getComponentName());
			ps.setString(7, component.getComponentVersion());
			ps.setString(8, component.getComponentUrl());
			
			if(ps.executeUpdate()==1){
				insertResult=true;
			}
	  
	  }
	  catch(SQLException se){
		  se.printStackTrace();
	  }
	  finally
		{
		DBUtil.close(con);
		}
		
		return insertResult;
	}

	@Override
	public ArrayList<Component> getAllComponents() {
		
		Component component;
		ArrayList<Component> allComponents = new ArrayList<Component>();
		try{
			con=DBUtil.getCon();
			ps=con.prepareStatement("select * from components");
			rs=ps.executeQuery();
			while(rs.next()){
				component = new Component();
				component.setTenant(rs.getString(1));
				component.setEnvironment(rs.getString(2));
				component.setApplication(rs.getString(3));
				component.setBox(rs.getString(4));
				component.setInstance(rs.getString(5));
				component.setComponentName(rs.getString(6));
				component.setComponentVersion(rs.getString(7));
				component.setComponentUrl(rs.getString(8));
				allComponents.add(component);
			}
			
			
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			DBUtil.close(con);
		}

		return allComponents;
	}

	@Override
	public HashMap<String, String> getComponentsByFilter(String tenant,
			String env, String app, String box, String instance) {
		
		HashMap<String, String> componentDetails = new HashMap<String, String>();
		
		try{
			con=DBUtil.getCon();
			ps=con.prepareStatement("select ComponentName, ComponentVersion from COMPONENT_INFO where Tenant=? and Environment=? and Application=? and Box=? and Instance=?");
			ps.setString(1, tenant);
			ps.setString(2, env);
			ps.setString(3, app);
			ps.setString(4, box);
			ps.setString(5, instance);
			rs=ps.executeQuery();
			while(rs.next()){
				componentDetails.put(rs.getString(1), rs.getString(2));
			}
			
			
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			DBUtil.close(con);
		}
		return componentDetails;
	}

	@Override
	public ArrayList<Component> getAllComponentsByFilter(String tenant,
			String env, String app) {
		
		Component component;
		ArrayList<Component> allComponents = new ArrayList<Component>();
		
		try{
			con=DBUtil.getCon();
			ps=con.prepareStatement("select * from COMPONENTS where Tenant=? and Environment=? and Application=?");
			ps.setString(1, tenant);
			ps.setString(2, env);
			ps.setString(3, app);
			/*ps.setString(4, box);
			ps.setString(5, instance);*/
			rs=ps.executeQuery();
			while(rs.next()){
				component = new Component();
				component.setTenant(rs.getString(1));
				component.setEnvironment(rs.getString(2));
				component.setApplication(rs.getString(3));
				component.setBox(rs.getString(4));
				component.setInstance(rs.getString(5));
				component.setComponentName(rs.getString(6));
				component.setComponentVersion(rs.getString(7));
				component.setComponentUrl(rs.getString(8));
				allComponents.add(component);
			}
			
			
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			DBUtil.close(con);
		}
		return allComponents;
	}

	@Override
	public boolean checkFailure(String url) throws Exception {
		
		String inputLine;
        
		URL reader = new URL(url);
		
        BufferedReader in = new BufferedReader(
        new InputStreamReader(reader.openStream()));

        while ((inputLine = in.readLine()) != null){  // System.out.println(inputLine);
        	if(inputLine.matches(".*\\bFailure\\b.*")){
        		System.out.println("Failure Found for : " + url);
        		checkFailureStatus = true;
        		break;
        	}
        }
        
        in.close();
        
		return checkFailureStatus;
	}

}