package kr.co.sun.vo;

import java.util.Date;

public class AccountVO {
	private String acMember_id;	//로그인한 유저아이디
    private String acNumber;	//계좌번호
    private String acName;		//계좌별명
    private int acPassword;		//계좌비밀번호
    private Date acRegdate;		//계좌생성일
    private int acType;			//계좌타입 
    private double acBalance;	//잔액
    
	public String getAcMember_id() {
		return acMember_id;
	}
	public void setAcMember_id(String acMember_id) {
		this.acMember_id = acMember_id;
	}
	public String getAcNumber() {
		return acNumber;
	}
	public void setAcNumber(String acNumber) {
		this.acNumber = acNumber;
	}
	public String getAcName() {
		return acName;
	}
	public void setAcName(String acName) {
		this.acName = acName;
	}
	public int getAcPassword() {
		return acPassword;
	}
	public void setAcPassword(int acPassword) {
		this.acPassword = acPassword;
	}
	public Date getAcRegdate() {
		return acRegdate;
	}
	public void setAcRegdate(Date acRegdate) {
		this.acRegdate = acRegdate;
	}
	public int getAcType() {
		return acType;
	}
	public void setAcType(int acType) {
		this.acType = acType;
	}
	public double getAcBalance() {
		return acBalance;
	}
	public void setAcBalance(double acBalance) {
		this.acBalance = acBalance;
	}
	@Override
	public String toString() {
		return "AccountVO [acMember_id=" + acMember_id + ", acNumber=" + acNumber + ", acName=" + acName
				+ ", acPassword=" + acPassword + ", acRegdate=" + acRegdate + ", acType=" + acType + ", acBalance="
				+ acBalance + "]";
	}
	public AccountVO(String acMember_id, String acNumber, String acName, int acPassword, Date acRegdate, int acType,
			double acBalance) {
		super();
		this.acMember_id = acMember_id;
		this.acNumber = acNumber;
		this.acName = acName;
		this.acPassword = acPassword;
		this.acRegdate = acRegdate;
		this.acType = acType;
		this.acBalance = acBalance;
	}
	public AccountVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
