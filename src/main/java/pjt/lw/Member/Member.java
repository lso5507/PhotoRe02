package pjt.lw.Member;

import java.util.ArrayList;


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
	public ArrayList<String> getImgList() {
		String [] imgArr =this.imgUrl.split(",");
		ArrayList<String>imgList=new ArrayList<String>();
		for(String i:imgArr) {
			if(i.contains(memId)) {
				System.out.println(i);
				imgList.add(i);
			}
		}
		
		return imgList;
	}
	public String getImgUrl() {
		return this.imgUrl;
		
	}
	public String toString() {
		return this.memId+this.memPw+this.imgUrl;
		
	}
	
}
