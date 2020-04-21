package pjt.lw.photo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pjt.lw.Member.Member;
import pjt.lw.photo.dao.Dao;



@Service
public class MemberService {
	@Autowired
	Dao dao;
	
	public Member search(Member member) {
		
		Member mem=dao.memberSelect(member);
		if(mem==null) {
			System.out.println("Not Found account info");
			return null;
		}
		
		return member;
		
	}
	public Member insert(Member member) {
		
		int result = dao.memberInsert(member);
		if(result==0) {
			System.out.println("Insert Error");
			return null;
		}
		System.out.println("Insert Success");
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
		System.out.println("imgUrl:"+member.getImgUrl().size()+"°³");
		
	}

}
