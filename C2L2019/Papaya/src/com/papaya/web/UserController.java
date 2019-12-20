package com.papaya.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.papaya.bean.LoginBean;
import com.papaya.bean.UserBean;
import com.papaya.service.ShoppingService;
import com.papaya.service.ShoppingServiceImpl;


/**
 * Servlet implementation class UserController
 */
@WebServlet(name = "User", urlPatterns = { "/User.do" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoppingService service; 

	@Override
	public void init() throws ServletException {
		service = new ShoppingServiceImpl();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String referer = request.getHeader("referer");
		// 
		if(referer.contains("home")) {
			// Request coming from homepage for login authentication
			LoginBean login = new LoginBean();
			login.setUserid(request.getParameter("email"));
			login.setPassword(request.getParameter("password"));
			
			UserBean user = service.authenticate(login);
			if(user != null) {
				// Login successful - Storing user id in session scope
				HttpSession session = request.getSession();
				session.setAttribute("USER", user);
				
				response.sendRedirect("Shopping.do");
			} else {
				// Login failed
				response.sendRedirect("home.jsp?invalid=yes");
			}
		} else if(referer.contains("register")){
			// Request coming from register page for user registration
			UserBean user = new UserBean();
			
			user.setName(request.getParameter("name"));
			user.setUserid(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			user.setAge(Integer.parseInt(request.getParameter("age")));
			user.setCity(request.getParameter("city"));
			user.setEmail(request.getParameter("email"));
			user.setPhone(request.getParameter("phone"));
			
			if(service.persist(user)) {
				// User registration succeeded - goto home page for login
				response.sendRedirect("home.jsp");
			} else {
				// User registration failed - go back to register back
				response.sendRedirect("register.jsp");
			}
		} else {
			HttpSession session = request.getSession();
			session.invalidate();	// destroy session
			response.sendRedirect("home.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
