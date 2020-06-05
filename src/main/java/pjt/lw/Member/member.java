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
		this.imgUrl=imgUrl;
	}
	public String[] getImgUrl() {
		String[] imgArr=imgUrl.split(","); // ,를 기준으로 나누기
		
		
		return imgArr;
	}

	public String toString() {
		return this.memId+this.memPw+this.imgUrl;
		
	}
	
}
