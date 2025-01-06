package com.ai.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestDao {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	public ArrayList DBConnection() {
		ArrayList ar = new ArrayList();
		try {
			String url = "jdbc:mariadb://localhost:3307/kit";
			String user = "root";
			String passwd = "1234";
			con = DriverManager.getConnection(url, user, passwd);
			System.out.println("DB연결 성공");
			pstmt = con.prepareStatement("select * from db_test");
			rs = pstmt.executeQuery();
			
			int i=0;
			while (rs.next()) {
				Map map = new HashMap();
				map.put("name", rs.getString(1));
				map.put("address", rs.getString(2));
				System.out.println(rs.getString(1) + "\t" + rs.getString(2));
				ar.add(i,map);
				i++;
			}
			
			rs.close();
			pstmt.close();
			con.close();
		
		} catch (SQLException e) {
			System.out.println("DB연결 실패하거나, SQL문이 틀렸습니다.");
			System.out.print("사유 : " + e.getMessage());
		}
		
		return ar;
	}
}


