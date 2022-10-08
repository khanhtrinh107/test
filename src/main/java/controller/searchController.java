package controller;

import java.io.IOException;
import java.util.ArrayList;

import entity.category;
import entity.product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mainService.Service;
@WebServlet(urlPatterns = {"/search"})
public class searchController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String txt = req.getParameter("txt");
		ArrayList <product> list = Service.getProductByTxt(txt);
		ArrayList <category> listC = Service.getAllCategories();
		product last = Service.getLastProduct();
		req.setAttribute("last" , last);
		req.setAttribute("listC", listC);
		req.setAttribute("list", list);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/Home.jsp");
		requestDispatcher.forward(req, resp);
	}
}
