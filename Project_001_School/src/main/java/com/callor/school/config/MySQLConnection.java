package com.callor.school.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

	private static Connection dbConn;
	
	static {
		
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/schooldata";
		String username = "scUser";
		String password = "12345";
		
		try {
			Class.forName(jdbcDriver);
			if(dbConn == null) {
				dbConn = DriverManager.getConnection(url, username, password);
			}
			System.out.println("MySQL 접속 성공!!!");
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL Driver 를 찾을 수 없음");
			System.out.println("MySQL Ojdbc6.jar 를 확인하세요");
		} catch (SQLException e) {
			System.out.println("=".repeat(30));
			System.out.println("MySQL DBMS 연결 실패!!");
			System.out.println("접속 정보를 확인하세요!!");
			System.out.println("URL : " + url);
			System.out.println("User : " + username);
			System.out.println("PW : " + password);
			System.out.println("=".repeat(30));
		}
	}
	public static Connection getDBConnection() {
		return dbConn;
	}
	
}
