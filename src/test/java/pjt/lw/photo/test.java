package pjt.lw.photo;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

class test {

	
	
		private static String driver = "com.mysql.cj.jdbc.Driver";
		private static String url = "jdbc:mysql://localhost:3306/photo?useSSL=false&serverTimezone=UTC";
		private static String userid = "root";
		private static String userpw = "1111";
		 
			@Test
			public void testConnection() throws Exception{
				
				ComboPooledDataSource dataSource = new ComboPooledDataSource();
				
				dataSource.setDriverClass(driver);
				dataSource.setJdbcUrl(url);
				dataSource.setUser(userid);
				dataSource.setPassword(userpw);//try_
				JdbcTemplate template;
				
				template = new JdbcTemplate();
				template.setDataSource(dataSource);
			}//testConnection_
		}//MySQLConnectionTest_
	


