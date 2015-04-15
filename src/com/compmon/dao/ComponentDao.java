package com.compmon.dao;

import java.util.*;

import com.compmon.model.Component;

public interface ComponentDao {
	
	boolean insertComponent(Component compoennt);
	ArrayList<Component> getAllComponents();
	HashMap<String, String> getComponentsByFilter(String tenant, String env, String app, String box, String instance);
	/*ArrayList<Component> getAllComponentsByFilter(String tenant, String env, String app, String box, String instance);*/
	ArrayList<Component> getAllComponentsByFilter(String tenant, String env, String app);
	boolean checkFailure(String url) throws Exception;
}
