package com.example.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptTests {
	
	@Autowired
	DataSource datasource;	// application.properties에 설정된 spring.datasource4가지 정보 담고있음
	
	DataSource datasource1;
	
	@Test
	public void test01_select() throws SQLException{
		System.out.println("##########");
		System.out.println("select");
		System.out.println("##########");
		
		System.out.println("datasource = " + datasource);
		System.out.println("datasource1 = " + datasource1);
		
		/*
		 * 1. Connection
		 */
		Connection con = datasource.getConnection();
		/*
		 * 2. executeQuery
		 */
		PreparedStatement pstmt = con.prepareStatement("select * from dept");	//쿼리문 준비
		ResultSet rs = pstmt.executeQuery();	//rs에 dept테이블 결과를 넣는다.
		/*
		 * 3. ResultSet print
		 */
		while(rs.next()){
			int deptno = rs.getInt("deptno");
			String dname = rs.getString("dname");
			String loc = rs.getString("loc");
			System.out.println(deptno + "," + dname + "," + loc);
		}
		
	}
	@Test
	public void test02_insert() throws SQLException{
		System.out.println("##########");
		System.out.println("insert");
		System.out.println("##########");
		
		 Connection con = datasource.getConnection();
		 
		 PreparedStatement pstmt = con.prepareStatement("insert into dept values (?,?,?)");	//placehold
		 pstmt.setInt(1, 50);
		 pstmt.setString(2, "총무부");
		 pstmt.setString(3, "서울");
		 int rtn = pstmt.executeUpdate();
		 System.out.println("rtn = " + rtn);
		 
		 con.commit();		
	}
	@Test
	public void test03_update(){
		System.out.println("##########");
		System.out.println("update");
		System.out.println("##########");
	}
	@Test
	public void test04_delete(){
		System.out.println("##########");
		System.out.println("delete");
		System.out.println("##########");
	}
}

