package com.callor.html.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcontract {

	private static Connection dbConn;
	
	static {
		
		String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "myfood";
		String password = "myfood";
		
		if(dbConn == null) {
			try {
				Class.forName(jdbcDriver);
				dbConn = DriverManager.getConnection(url, username, password);
				System.out.println("오라클 접속 OK!!!");
			} catch (ClassNotFoundException e) {
				System.out.println("ojdbc6.jar 를 확인하세요.");
			} catch (SQLException e) {
				System.out.println("=".repeat(30));
				System.out.println("Driver : " + jdbcDriver);
				System.out.println("URL : " + url);
				System.out.println("UserName : " + username);
				System.out.println("Password : " + password);
				System.out.println("-".repeat(30));
				System.out.println("오라클 DBMS 접속 오류");
				System.out.println("접속 정보를 확인하세요");
				System.out.println("=".repeat(30));
			}
		}
	}
	public static Connection getDBConnection() {
		return dbConn;
	}
}
