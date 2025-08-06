 package com.example.demo.loginCredentials;

public class UserLogin 
{
	private String uemail;
	private String upassword;
	public String getUemail() {
		return this.uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpassword() {
		return this.upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
@Override
public String toString() {
		return "UserLogin [uemail=" + uemail + ", upassword=" + upassword + "]";
}



}