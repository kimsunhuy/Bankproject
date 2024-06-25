package kr.co.sun.vo;

import java.util.Date;

public class DepositVO {
    private int dsType;
    private String dsName;
    private String dsDetail;
    private double dsInterest;
    private Date dsRegdate;
    private String dsDuration;
	public int getDsType() {
		return dsType;
	}
	public void setDsType(int dsType) {
		this.dsType = dsType;
	}
	public String getDsName() {
		return dsName;
	}
	public void setDsName(String dsName) {
		this.dsName = dsName;
	}
	public String getDsDetail() {
		return dsDetail;
	}
	public void setDsDetail(String dsDetail) {
		this.dsDetail = dsDetail;
	}
	public double getDsInterest() {
		return dsInterest;
	}
	public void setDsInterest(double dsInterest) {
		this.dsInterest = dsInterest;
	}
	public Date getDsRegdate() {
		return dsRegdate;
	}
	public void setDsRegdate(Date dsRegdate) {
		this.dsRegdate = dsRegdate;
	}
	public String getDsDuration() {
		return dsDuration;
	}
	public void setDsDuration(String dsDuration) {
		this.dsDuration = dsDuration;
	}
	@Override
	public String toString() {
		return "DepositVO [dsType=" + dsType + ", dsName=" + dsName + ", dsDetail=" + dsDetail + ", dsInterest="
				+ dsInterest + ", dsRegdate=" + dsRegdate + ", dsDuration=" + dsDuration + "]";
	}
	public DepositVO(int dsType, String dsName, String dsDetail, double dsInterest, Date dsRegdate, String dsDuration) {
		super();
		this.dsType = dsType;
		this.dsName = dsName;
		this.dsDetail = dsDetail;
		this.dsInterest = dsInterest;
		this.dsRegdate = dsRegdate;
		this.dsDuration = dsDuration;
	}
	public DepositVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
   
}
