package pjt.lw.Member;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private String memId;
	private String memPw;
	private List<String> imgUrl=new ArrayList<String>();
	
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
		this.imgUrl.add(imgUrl);
	}
	public String getImgUrl() {
		String str=null;
		for(int i=0; i<=imgUrl.size();i++) {
			 str = this.imgUrl.get(i)+",";
		}
		return str;
	}
	public int imgLength() {
		
		
		return imgUrl.size();
	}
	public String toString() {
		return this.memId+this.memPw+this.imgUrl;
		
	}
	
}
