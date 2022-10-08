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
@WebServlet(urlPatterns = {"/category"})
public class categoryController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid = req.getParameter("cid");
		if (cid == null) {
			cid = "";
		}
		
		ArrayList <category> listC = Service.getAllCategories();
		int cnt = Service.getAllProductByCid(cid);
		int limit = 3;
		int page = cnt / limit;
		if(cnt % limit != 0)
			page ++;
		String index = req.getParameter("index");
		int in;
		if(index == null) {
			in = 1;
		}
		else in = Integer.parseInt(index);
		ArrayList<product> list = Service.getPageProductByCid(cid, in);
		product last = Service.getLastProduct();
		req.setAttribute("page", page);
		req.setAttribute("cid", cid);
		req.setAttribute("last" , last);
		req.setAttribute("listC", listC);
		req.setAttribute("list", list);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/Home.jsp");
		requestDispatcher.forward(req, resp);
	}
}
