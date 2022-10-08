package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import entity.account;

import entity.product;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mainService.Service;
@WebServlet(urlPatterns = {"/login"})
public class loginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		account a = Service.login(user, pass);
		
		if(a == null) {
			req.setAttribute("mess", "Wrong username or password!");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(req, resp);
		}
		else {
			HttpSession session = req.getSession();
			session.setMaxInactiveInterval(1000);
			session.setAttribute("acc", a);
			Cookie u = new Cookie("userC", user);
			Cookie p = new Cookie("passC", pass);
			u.setMaxAge(60);
			p.setMaxAge(60);
			resp.addCookie(u);
			resp.addCookie(p);
			resp.sendRedirect("home");
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie arr[] = req.getCookies();
		for(Cookie o : arr) {
			System.out.println(o);
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(req, resp);
	}
	
}
