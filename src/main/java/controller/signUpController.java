package controller;

import java.io.IOException;

import entity.account;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mainService.Service;
@WebServlet(urlPatterns = {"/signup"})
public class signUpController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		String passwordRepeat = req.getParameter("passr");
		
		if(username.equals("") || password.equals("") || passwordRepeat.equals("")) {
			req.setAttribute("mess", "Don't empty!");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("signup.jsp");
			requestDispatcher.forward(req, resp);
		}
		else {
			account acc = Service.checkAccount(username, password);
			if(password.equals(passwordRepeat)) {
				if(acc == null) {
					account a = Service.checkExist(username);
					if(a == null) {
						Service.register(username, password);
						resp.sendRedirect("home");
					}
					else {
						req.setAttribute("mess", "Username has been existed!");
						RequestDispatcher requestDispatcher = req.getRequestDispatcher("signup.jsp");
						requestDispatcher.forward(req, resp);
					}
				}
				else {
					req.setAttribute("mess", "Account has been existed!");
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("signup.jsp");
					requestDispatcher.forward(req, resp);
				}
			}
			else {
				req.setAttribute("mess", "password and password repeat have to equal!");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("signup.jsp");
				requestDispatcher.forward(req, resp);
			}
		}
	}
}
