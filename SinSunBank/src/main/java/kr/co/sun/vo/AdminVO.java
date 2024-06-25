package kr.co.sun.vo;

import java.util.Date;

public class AdminVO {

	private String baName;
	private String baPassword;
	private Date baRegdate;
	
	
	public String getBaName() {
		return baName;
	}
	public void setBaName(String baName) {
		this.baName = baName;
	}
	public String getBaPassword() {
		return baPassword;
	}
	public void setBaPassword(String baPassword) {
		this.baPassword = baPassword;
	}
	public Date getBaRegdate() {
		return baRegdate;
	}
	public void setBaRegdate(Date baRegdate) {
		this.baRegdate = baRegdate;
	}
	@Override
	public String toString() {
		return "AdminVO [baName=" + baName + ", baPassword=" + baPassword + ", baRegdate=" + baRegdate + "]";
	}
	public AdminVO(String baName, String baPassword, Date baRegdate) {
		super();
		this.baName = baName;
		this.baPassword = baPassword;
		this.baRegdate = baRegdate;
	}
	public AdminVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
