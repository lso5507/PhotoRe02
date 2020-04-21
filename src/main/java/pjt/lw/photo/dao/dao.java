package pjt.lw.photo.dao;

import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
	public Dao() {  // jdbc ¿¬°á
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
	
	public int memberInsert(Member member) {
		int result = 0;
		
		final String sql = "INSERT INTO member_ (memId, memPw, imgUrl) values (?,?,?)";
		result = template.update(sql,member.getMemId(),member.getMemPw(),member.getImgUrl());
		
		
		return result;
		
	}
	public int memberPwUpdate(Member member) {
		int result = 0;
		
		final String sql = "UPDATE member_ SET memPw = ?, imgUrl = ? WHERE memId = ?";
		result = template.update(sql,member.getMemPw(),member.getImgUrl(),member.getImgUrl());
		
		
		return result;
		
	}
	public int memberIdUpdate(Member member) {
		int result = 0;
		
		final String sql = "UPDATE member_ SET memPw = ?, imgUrl = ? WHERE memPw = ?";
		result = template.update(sql,member.getMemPw(),member.getImgUrl(),member.getImgUrl());
		
		
		return result;
		
	}
	public int memberRemove(Member member) {
		int result = 0;
		
		final String sql = "INSERT INTO member_ (memId, memPw, imgUrl) values (?,?,?)";
		result = template.update(sql,member.getMemId(),member.getMemPw(),member.getImgUrl());
		
		
		return result;
		
	}
	public Member memberSelect(Member member) {
		List<Member> members = null;
		
		final String sql = "SELECT * FROM member_ WHERE memId = ? AND memPw = ?";
		members = template.query(sql, new Object[]{member.getMemId(), member.getMemPw()}, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member mem = new Member();
				mem.setMemId(rs.getString("memId"));
				mem.setMemPw(rs.getString("memPw"));
				mem.setImgUrl(rs.getString("imgUrl"));
				
				return mem;
			}
			
		});
		
		if(members.isEmpty()) 
			return null;
		
		return members.get(0);
	}
}
