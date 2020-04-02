package com.org.mysqlservlet.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.org.mysqlservlet.entity.User;

public class UserModel {
	
	public List<User> listUsers(DataSource dataSource){
		
		List<User> listUsers=new ArrayList<>();
		Connection connection=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		
		try {
			connection=dataSource.getConnection();
			String query="Select * from user";
			stmt=connection.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()) {
				listUsers.add(new User(rs.getInt("User_id"),rs.getString("username"),rs.getString("user_password")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listUsers;
		
	}
	
	
	
}
