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
@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList <category> listC = Service.getAllCategories();
		product last = Service.getLastProduct();
		int total = Service.getAll();
		int limit = 6;
		int page = total / limit;
		if(total % limit != 0)
			page++;
		String index = req.getParameter("index");
		int in;
		if(index != null) {
			in = Integer.parseInt(index);
		}
		else {
			in = 1;
		}
		ArrayList<product> list = Service.getPageProduct(in);
		req.setAttribute("ind", in);
		req.setAttribute("page", page);
		req.setAttribute("last" , last);
		req.setAttribute("listC", listC);
		req.setAttribute("list", list);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/Home.jsp");
		requestDispatcher.forward(req, resp);
	}
}
