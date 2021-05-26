package com.callor.school.service.impl;

import java.sql.Connection;

import com.callor.school.config.MySQLConnection;

public class SchoolServiceImplV1 {

	protected Connection dbConn;
	
	public SchoolServiceImplV1() {
		dbConn = MySQLConnection.getDBConnection();
	}
	
}