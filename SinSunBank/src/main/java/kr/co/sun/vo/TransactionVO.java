package kr.co.sun.vo;

import java.sql.Timestamp;
import java.util.Date;

public class TransactionVO {
    private int tId;
    private String tAccount_number;
    private String tName;
    private double tAmount;
    private Timestamp tDate;
    private int tType;
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String gettAccount_number() {
		return tAccount_number;
	}
	public void settAccount_number(String tAccount_number) {
		this.tAccount_number = tAccount_number;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public double gettAmount() {
		return tAmount;
	}
	public void settAmount(double tAmount) {
		this.tAmount = tAmount;
	}
	public Date gettDate() {
		return tDate;
	}
	public void settDate(Timestamp tDate) {
		this.tDate = tDate;
	}
	public int gettType() {
		return tType;
	}
	public void settType(int tType) {
		this.tType = tType;
	}
	@Override
	public String toString() {
		return "TransactionVO [tId=" + tId + ", tAccount_number=" + tAccount_number + ", tName=" + tName + ", tAmount="
				+ tAmount + ", tDate=" + tDate + ", tType=" + tType + "]";
	}
	public TransactionVO(int tId, String tAccount_number, String tName, double tAmount, Timestamp tDate, int tType) {
		super();
		this.tId = tId;
		this.tAccount_number = tAccount_number;
		this.tName = tName;
		this.tAmount = tAmount;
		this.tDate = tDate;
		this.tType = tType;
	}
	public TransactionVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
   
}
