/**
 * Bean to serialize glue.yml file
 * @author antani
 */
package com.netapp.glue.conf;

public class ServerConf {
	
	private Boolean useglue;
	private String wfaserver;
	private String wfausername;
	private String wfapassword;
	
	public Boolean getUseglue() {
		return useglue;
	}
	public String getWfaserver() {
		return wfaserver;
	}
	public String getWfausername() {
		return wfausername;
	}
	public String getWfapassword() {
		return wfapassword;
	}
	public void setUseglue(Boolean useglue) {
		this.useglue = useglue;
	}
	public void setWfaserver(String wfaserver) {
		this.wfaserver = wfaserver;
	}
	public void setWfausername(String wfausername) {
		this.wfausername = wfausername;
	}
	public void setWfapassword(String wfapassword) {
		this.wfapassword = wfapassword;
	}
	
	

}
