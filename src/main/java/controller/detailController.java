package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.oracle.wls.shaded.org.apache.xpath.operations.String;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mainService.Service;
@WebServlet(urlPatterns = {"/detail"})
public class detailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		product detail = Service.getProductById(id);
		ArrayList <category> listC = Service.getAllCategories();
		product last = Service.getLastProduct();
		req.setAttribute("last" , last);
		req.setAttribute("listC", listC);
		req.setAttribute("detail", detail);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/Detail.jsp");
		requestDispatcher.forward(req, resp);
	}
}
