package pjt.lw.photo.dao;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import pjt.lw.Member.Member;

@Repository
public class Dao {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/photo?useSSL=false&serverTimezone=UTC";
	private String userid = "root";
	private String userpw = "1111";
	private ComboPooledDataSource dataSource;
	
	private JdbcTemplate template;
	public Dao() {  // jdbc 연결
		dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(driver);
			dataSource.setJdbcUrl(url);
			dataSource.setUser(userid);
			dataSource.setPassword(userpw);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		template = new JdbcTemplate();
		template.setDataSource(dataSource);
	}
	
	public int memberInsert(final Member member) {
		int result = 0;
		
		final String sql = "INSERT INTO mem (memId, memPw) values (?,?)";
		
//		result = template.update(sql,member.getMemId(),member.getMemPw());
//		
//		
		result = template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, member.getMemId());
				pstmt.setString(2, member.getMemPw());
				
				
			}
		});
		
		
		
		return result;
		
	}


	public static HttpServletRequest getCurrentRequest() {
 
       ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
               .currentRequestAttributes();
 
       HttpServletRequest hsr = sra.getRequest();
     
       return hsr;
   }
	public Member memberUpdate(String keyword,String str) {
		int result = 0;
		HttpServletRequest request = getCurrentRequest();
		HttpSession session = request.getSession();
		
		Member member = (Member) session.getAttribute("member");
		System.out.println(member.getMemId());
		if(str.equals("ID")) {
			final String sql = "UPDATE mem SET memId = ? WHERE memId = ?";
			result = template.update(sql,keyword,member.getMemId());
			member.setMemId(keyword);
		}
		
		else if(str.equals("PW")) {
			final String sql = "UPDATE mem SET memPw = ? WHERE memId = ?";
			result = template.update(sql,keyword,member.getMemId());
			member.setMemPw(keyword);
		}
		
		return member;
		
		
		
		
		
	}

	public int memberRemove(Member member) {
		int result = 0;
		
		final String sql = "DELETE from mem WHERE memId = ? AND memPw=?";
		result = template.update(sql,member.getMemId(),member.getMemPw());
		
		
		return result;
		
	}
	public Member memberSelect(Member member) {
		List<Member> members = null;
		
		final String sql = "SELECT * FROM mem WHERE memId = ? AND memPw = ?";
		
		members = template.query(sql, new Object[]{member.getMemId(), member.getMemPw()}, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member mem = new Member();
				mem.setMemId(rs.getString("memId"));
				mem.setMemPw(rs.getString("memPw"));
				
				
				return mem;
			}
			
		});
		
		if(members.isEmpty()) 
			return null;
		
		return members.get(0);
		
	}
	public boolean saveFile(MultipartFile file,String saveName) {
		HttpServletRequest request = getCurrentRequest();
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
	    // 저장할 File 객체를 생성(껍데기 파일)ㄴ
	    String UPLOAD_PATH = "C:\\Users\\LeeSeokwoon\\Desktop\\Album\\repo\\"+member.getMemId();
	    File Folder = new File(UPLOAD_PATH);
	    if (!Folder.exists()) {
			try{
			    Folder.mkdir(); //폴더 생성합니다.
			    System.out.println("폴더가 생성되었습니다.");
		        } 
		        catch(Exception e){
			    e.getStackTrace();
		        }   
	    }
	    
	    File saveFile = new File(UPLOAD_PATH,saveName); // 저장할 폴더 이름, 저장할 파일 이름
	    System.out.println("UPLOAD_PATH : "+UPLOAD_PATH);
	    		
	    try {
	        file.transferTo(saveFile); // 업로드 파일에 saveFile이라는 껍데기 입힘
	        member.setImgUrl(UPLOAD_PATH+saveName);
	        System.out.println(member.getImgUrl());
	    } catch (IOException e) {
	        e.printStackTrace();
	        System.out.println("Error");
	        return false;
	    }
	    return true;
	}
}
