package pjt.lw.Member;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private String memId;
	private String memPw;
	private String imgUrl;
	
	public void setMemId(String memId) {
		this.memId=memId;
	}
	public String getMemId() {
		return this.memId;  
	}
	public void setMemPw(String memPw) {
		this.memPw=memPw;
	}
	public String getMemPw() {
		return this.memPw;
	}
	public void setImgUrl(String imgUrl) {
		if(this.imgUrl!=null)
			this.imgUrl+=","+imgUrl;
		else
			this.imgUrl=imgUrl;
	}
	public String getImgUrl() {
		return this.imgUrl;
	}
//	public int imgLength() {
//		
//		
////		return imgUrl.length()
//	}
	public String toString() {
		return this.memId+this.memPw+this.imgUrl;
		
	}
	
}
