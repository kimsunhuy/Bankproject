package kr.co.sun.vo;

import java.util.Date;

public class MemberVO {
	private String mName;
    private String mId;
    private String mPassword;
    private String mPhone_Num;
    private Date mBirth;
    private String mAdress;
    private String mEmail;
    private Date mRegdate;
    private int mNumber;
    private int mLoginAttempts;
    private String mLocked;
    private String mSignout;
    private String verification_Code;
    
	public MemberVO(String verification_Code) {
		super();
		this.verification_Code = verification_Code;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPassword() {
		return mPassword;
	}
	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}
	public String getmPhone_Num() {
		return mPhone_Num;
	}
	public void setmPhone_Num(String mPhone_Num) {
		this.mPhone_Num = mPhone_Num;
	}
	public Date getmBirth() {
		return mBirth;
	}
	public void setmBirth(Date mBirth) {
		this.mBirth = mBirth;
	}
	public String getmAdress() {
		return mAdress;
	}
	public void setmAdress(String mAdress) {
		this.mAdress = mAdress;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public Date getmRegdate() {
		return mRegdate;
	}
	public void setmRegdate(Date mRegdate) {
		this.mRegdate = mRegdate;
	}
	public int getmNumber() {
		return mNumber;
	}
	public void setmNumber(int mNumber) {
		this.mNumber = mNumber;
	}
	public int getmLoginAttempts() {
		return mLoginAttempts;
	}
	public void setmLoginAttempts(int mLoginAttempts) {
		this.mLoginAttempts = mLoginAttempts;
	}
	public String getmLocked() {
		return mLocked;
	}
	public void setmLocked(String mLocked) {
		this.mLocked = mLocked;
	}
	public String getmSignout() {
		return mSignout;
	}
	public void setmSignout(String mSignout) {
		this.mSignout = mSignout;
	}
	@Override
	public String toString() {
		return "MemberVO [verification_Code=" + verification_Code + "]";
	}
	public MemberVO(String mName, String mId, String mPassword, String mPhone_Num, Date mBirth, String mAdress,
			String mEmail, Date mRegdate, int mNumber, int mLoginAttempts, String mLocked, String mSignout) {
		super();
		this.mName = mName;
		this.mId = mId;
		this.mPassword = mPassword;
		this.mPhone_Num = mPhone_Num;
		this.mBirth = mBirth;
		this.mAdress = mAdress;
		this.mEmail = mEmail;
		this.mRegdate = mRegdate;
		this.mNumber = mNumber;
		this.mLoginAttempts = mLoginAttempts;
		this.mLocked = mLocked;
		this.mSignout = mSignout;
	}
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getVerification_Code() {
		return verification_Code;
	}
	public void setVerification_Code(String verification_Code) {
		this.verification_Code = verification_Code;
	}
	
    
}
