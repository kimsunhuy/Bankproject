package kr.co.sun.vo;

import java.util.Date;

public class NoticeVO {
    private int nType;
    private String nTitle;
    private String nWriter;
    private String nContent;
    private int nViewcnt;
    private Date nRegdate;
	public int getnType() {
		return nType;
	}
	public void setnType(int nType) {
		this.nType = nType;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public String getnWriter() {
		return nWriter;
	}
	public void setnWriter(String nWriter) {
		this.nWriter = nWriter;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public int getnViewcnt() {
		return nViewcnt;
	}
	public void setnViewcnt(int nViewcnt) {
		this.nViewcnt = nViewcnt;
	}
	public Date getnRegdate() {
		return nRegdate;
	}
	public void setnRegdate(Date nRegdate) {
		this.nRegdate = nRegdate;
	}
	@Override
	public String toString() {
		return "NoticeVO [nType=" + nType + ", nTitle=" + nTitle + ", nWriter=" + nWriter + ", nContent=" + nContent
				+ ", nViewcnt=" + nViewcnt + ", nRegdate=" + nRegdate + "]";
	}
	public NoticeVO(int nType, String nTitle, String nWriter, String nContent, int nViewcnt, Date nRegdate) {
		super();
		this.nType = nType;
		this.nTitle = nTitle;
		this.nWriter = nWriter;
		this.nContent = nContent;
		this.nViewcnt = nViewcnt;
		this.nRegdate = nRegdate;
	}
	public NoticeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
}
