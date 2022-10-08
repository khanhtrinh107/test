package controller;

import java.io.IOException;
import java.util.ArrayList;

import entity.Item;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/process"})
public class processController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		HttpSession session = req.getSession();
		ArrayList<Item> items = (ArrayList<Item>)session.getAttribute("list");
		Item tmp = new Item();
		for(Item o : items) {
			if(o.getProduct().getId() == Integer.parseInt(id)) {
				tmp = o;
			}
		}
		if(cnt == 0) items.remove(tmp);
		else {
			for(Item o : items) {
				if(o.getProduct().getId() == Integer.parseInt(id)) {
					o.setQuantity(cnt);
				}
			}
		}
		double sum = 0;
		for(Item o : items) {
			sum += o.getPrice()*o.getQuantity();
		}
		req.setAttribute("total", sum);
		session.setAttribute("list", items);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/cart.jsp");
		requestDispatcher.forward(req, resp);
	}
}
