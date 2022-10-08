package controller;

import java.io.IOException;

import entity.account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mainService.Service;
@WebServlet(urlPatterns = {"/add"})
public class addController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String image = req.getParameter("image");
		String price = req.getParameter("price");
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String cid = req.getParameter("category");
		HttpSession session = req.getSession();
		account a = (account)session.getAttribute("acc");
		int id = a.getId();
		Service.addProduct(name, image, price, title, description, cid, id);
		resp.sendRedirect("managerProduct");
	}
}
