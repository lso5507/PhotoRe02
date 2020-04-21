package pjt.lw.Member;

import java.util.List;

public class Member {
	private String memId;
	private String memPw;
	private List<String> imgUrl;
	
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
	public List<String> getImgUrl() {
		return this.imgUrl;
	}
	public String toString() {
		return this.memId+this.memPw+this.imgUrl;
		
	}
	
}
