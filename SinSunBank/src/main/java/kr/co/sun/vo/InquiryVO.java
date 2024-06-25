package kr.co.sun.vo;

import java.util.Date;

public class InquiryVO {
    private int iqId;
    private String iqTitle;
    private String iqContent;
    private String iqWriter;
    private int iqViewcnt;
    private Date idRegdate;
	public int getIqId() {
		return iqId;
	}
	public void setIqId(int iqId) {
		this.iqId = iqId;
	}
	public String getIqTitle() {
		return iqTitle;
	}
	public void setIqTitle(String iqTitle) {
		this.iqTitle = iqTitle;
	}
	public String getIqContent() {
		return iqContent;
	}
	public void setIqContent(String iqContent) {
		this.iqContent = iqContent;
	}
	public String getIqWriter() {
		return iqWriter;
	}
	public void setIqWriter(String iqWriter) {
		this.iqWriter = iqWriter;
	}
	public int getIqViewcnt() {
		return iqViewcnt;
	}
	public void setIqViewcnt(int iqViewcnt) {
		this.iqViewcnt = iqViewcnt;
	}
	public Date getIdRegdate() {
		return idRegdate;
	}
	public void setIdRegdate(Date idRegdate) {
		this.idRegdate = idRegdate;
	}
	@Override
	public String toString() {
		return "InquiryVO [iqId=" + iqId + ", iqTitle=" + iqTitle + ", iqContent=" + iqContent + ", iqWriter="
				+ iqWriter + ", iqViewcnt=" + iqViewcnt + ", idRegdate=" + idRegdate + "]";
	}
	public InquiryVO(int iqId, String iqTitle, String iqContent, String iqWriter, int iqViewcnt, Date idRegdate) {
		super();
		this.iqId = iqId;
		this.iqTitle = iqTitle;
		this.iqContent = iqContent;
		this.iqWriter = iqWriter;
		this.iqViewcnt = iqViewcnt;
		this.idRegdate = idRegdate;
	}
	public InquiryVO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
}
