package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mainService.Service;
@WebServlet(urlPatterns = {"/edit"})
public class edit extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String image = req.getParameter("image");
		String price = req.getParameter("price");
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String category = req.getParameter("category");
		String id = req.getParameter("id");
		Service.update(name, image, price, title, description, id, id);
		resp.sendRedirect("managerProduct");
	}
}
