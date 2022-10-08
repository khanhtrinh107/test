package controller;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.catalina.ant.SessionsTask;

import entity.account;
import entity.category;
import entity.product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mainService.Service;
@WebServlet(urlPatterns = {"/managerProduct"})
public class managerProduct extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		account a = (account)session.getAttribute("acc");
		int id = a.getId();
		ArrayList<product> list = (ArrayList<product>)Service.getProductBySellId(id);
		ArrayList <category> listC = Service.getAllCategories();
		req.setAttribute("listC", listC);
		req.setAttribute("listP", list);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/managerProduct.jsp");
		requestDispatcher.forward(req, resp);
	}
}
