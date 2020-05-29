package pjt.lw.photo.service;



import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import pjt.lw.Member.Member;
import pjt.lw.photo.dao.Dao;



@Service
public class MemberService {
	@Autowired
	Dao dao;
	
	public Member search(Member member) {
		System.out.println("select");
		Member mem=dao.memberSelect(member);
		if(mem==null) {
			System.out.println("Not Found account info");
			return null;
		}
		
		return member;
		
	}
	public Member insert(Member member) {
		System.out.println("Insert()");
		int result = dao.memberInsert(member);
		if(result==0) {
			System.out.println("Insert Error");
			return null;
		}
		System.out.println("Insert Success");
		return member;
	}
	public Member modify(String key,String str) {
		System.out.println("modify");
		Member member = null;
		if(str.equals("ID")) {
			member=dao.memberUpdate(key,"ID");
		}
		else if(str.equals("PW")) {
			member=dao.memberUpdate(key,"PW");
		}

		
		
		return member;
	}

	public Member remove(Member member) {
		
		int result =  dao.memberRemove(member);
		
		if(result==0) {
			System.out.println("Remove error");
			return null;
		}
		System.out.println("Remove Success");
		return member;
	}
	public void print(Member member) {
		System.out.println("MemId:"+member.getMemId());
		System.out.println("MemPw:"+member.getMemPw());
//		System.out.println("imgUrl:"+member.getImgUrl().size()+"개");
		
	}
	
	public boolean imgInsert(MultipartFile file) {
		// 파일 이름 변경
		
		
		
		
	    String saveName = getCurrentDate("yyyyMMddHHmm") + "_" + file.getOriginalFilename();
	    System.out.println(saveName);
	    
	    if(dao.saveFile(file,saveName))
	    	return true;
	    else
	    	return false;


		  
		 
		
	}
	public static String getCurrentDate(String format) {
	       String dtStr = "";
	       SimpleDateFormat sdf = new SimpleDateFormat(format);
	       Date dt1 = new Date();

	       dtStr = sdf.format(dt1);

	       return dtStr;
	}


}
