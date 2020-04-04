package com.org.mysqlservlet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.org.mysqlservlet.entity.User;
import com.org.mysqlservlet.model.UserModel;

@WebServlet("/operation")
public class OprationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/project")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		page = page.toLowerCase();

		switch (page) {
		
		case "listusers":
			listUsers(request, response);
			break;
		case "addusers":
			addUserFormLoader(request, response);
			break;
		case "updateuser":
			updateUserFormLoader(request, response);
			break;
		default:
			errorPage(request, response);

		}

	}
	
	public void updateUserFormLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("title", "Update user");
		request.getRequestDispatcher("updateUser.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("form");
		operation = operation.toLowerCase();
		
		switch(operation) {
		case "adduseroperation":
		   User newUser=	new User(request.getParameter("username"), request.getParameter("password"));
		   addUserOperation(newUser);
		   listUsers(request, response);
		 break;
		case "updateuseroperation":
			User updatedUser = new User(Integer.parseInt(request.getParameter("User_id")), request.getParameter("username"), request.getParameter("password"));
	        updateUserOperation(dataSource,updatedUser);	
	        listUsers(request, response);
		 break;
		default:
			errorPage(request, response);

		}

	}

	private void updateUserOperation(DataSource dataSource, User updatedUser) {
		new UserModel().updateUser(dataSource,updatedUser);
		return;
	}

	public void addUserOperation(User newUser) {
		
		new UserModel().addUser(dataSource, newUser);
		return;
	}

	public void addUserFormLoader(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "Add User");
		request.getRequestDispatcher("adduser.jsp").forward(request, response);

	}

	public void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<User> listUsers = new ArrayList<>();
		listUsers = new UserModel().listUsers(dataSource);
		request.setAttribute("listUsers", listUsers);
		request.setAttribute("title", "List of users");
		request.getRequestDispatcher("listUser.jsp").forward(request, response);
	}

	public void errorPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "Errorpage");
		request.getRequestDispatcher("error.jsp").forward(request, response);

	}

}
