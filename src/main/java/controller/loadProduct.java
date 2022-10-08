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
@WebServlet(urlPatterns = {"/loadProduct"})
public class loadProduct extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pid = req.getParameter("pid");
		product a = Service.getProductById(pid);
		ArrayList <category> listC = Service.getAllCategories();
		
		req.setAttribute("listC", listC);
		req.setAttribute("detail", a);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/edit.jsp");
		requestDispatcher.forward(req, resp);
	}
}
