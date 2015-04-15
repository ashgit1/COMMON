/**
 * 
 */

package com.compmon.model;

/**
 * @author agupt40
 *
 */

public class Component {

	private String Tenant;
	private String Environment;
	private String Application;
	private String Box;
	private String Instance;
	private String ComponentName;
	private String ComponentVersion;
	private String ComponentUrl;
	
	public String getComponentUrl() {
		return ComponentUrl;
	}
	public void setComponentUrl(String componentUrl) {
		ComponentUrl = componentUrl;
	}
	public String getTenant() {
		return Tenant;
	}
	public void setTenant(String tenant) {
		Tenant = tenant;
	}
	public String getEnvironment() {
		return Environment;
	}
	public void setEnvironment(String environment) {
		Environment = environment;
	}
	public String getApplication() {
		return Application;
	}
	public void setApplication(String application) {
		Application = application;
	}
	public String getBox() {
		return Box;
	}
	public void setBox(String box) {
		Box = box;
	}
	public String getInstance() {
		return Instance;
	}
	public void setInstance(String instance) {
		Instance = instance;
	}
	public String getComponentName() {
		return ComponentName;
	}
	public void setComponentName(String componentName) {
		ComponentName = componentName;
	}
	public String getComponentVersion() {
		return ComponentVersion;
	}
	public void setComponentVersion(String componentVersion) {
		ComponentVersion = componentVersion;
	}
	
}
