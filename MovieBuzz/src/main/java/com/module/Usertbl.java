package com.module;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity(name = "Usertbl")
public class Usertbl {

	@Id
	private int Userid;
	private String Usernm;
	private String UsrPwd;
	
	private String Email;
	private int type;
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	public String getUsrPwd() {
		return UsrPwd;
	}
	public void setUsrPwd(String usrPwd) {
		UsrPwd = usrPwd;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public Usertbl() {
		super();
	}
	public String getUsernm() {
		return Usernm;
	}
	public void setUsernm(String usernm) {
		Usernm = usernm;
	}
	public Usertbl(int userid, String usernm, String usrPwd, String email, int type) {
		super();
		Userid = userid;
		Usernm = usernm;
		UsrPwd = usrPwd;
		Email = email;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Usertbl [Userid=" + Userid + ", Usernm=" + Usernm + ", UsrPwd=" + UsrPwd + ", Email=" + Email
				+ ", type=" + type + "]";
	}
	
	
	
	
	
	
	
}
