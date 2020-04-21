package pjt.lw.Member;

public class member {
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
	public String getImgUrl() {
		return this.imgUrl;
	}s
	public String toString() {
		return this.memId+this.memPw+this.imgUrl;
		
	}
	
}
