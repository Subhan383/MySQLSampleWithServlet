package com.org.mysqlservlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	

	public void addUser(DataSource dataSource,User newUser) {
		Connection connection=null;
		PreparedStatement stmt=null;
		
		try {
			connection = dataSource.getConnection();
			String username=newUser.getUsername();
			String user_password=newUser.getUser_password();
			
			String query="insert into user (username,user_password) values (?,?)";
			stmt=connection.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, user_password);
		    stmt.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}



	public void updateUser(DataSource dataSource, User updatedUser) {
	    Connection connection=null;
	    PreparedStatement stmt=null;
	    
	    try {
	    	connection=dataSource.getConnection();
	    	int User_id= updatedUser.getUser_id();
	    	String username= updatedUser.getUsername();
	    	String user_password= updatedUser.getUser_password();
	    	String query="update user set username=?,user_password=? where User_id=?";
	    	stmt=connection.prepareStatement(query);
	    	stmt.setString(1, username);
	    	stmt.setString(2, user_password);
	    	stmt.setInt(3, User_id);
	    	 stmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



	public void deleteUser(DataSource dataSource,int user_id) {
		 Connection connection=null;
		    PreparedStatement stmt=null;
		    
		    try {
		    	connection=dataSource.getConnection();
		    	
		    	String query="delete from user where User_id=?";
		    	stmt=connection.prepareStatement(query);
		    	stmt.setInt(1, user_id);
		    	 stmt.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	
	
}
