package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import entity.Cart;
import entity.Item;
import entity.product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mainService.Service;
@WebServlet(urlPatterns = {"/addToCart"})
public class addToCart extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("cartid");
		product pr = Service.getProductById(id);
		HttpSession session = req.getSession();
		Cart cart = null;
		if(session.getAttribute("cart") == null)
			cart = new Cart();
		else
			cart = (Cart)session.getAttribute("cart");
		double price = pr.getPrice();
		Item t = new Item(pr, price, 1);
		ArrayList<Item> items = cart.getItems();
		boolean check = false;
		for(Item o : items) {
			if(o.getProduct().getId() == pr.getId()) {
				check = true;
				o.setQuantity(o.getQuantity() + 1);;
			}
		}
		if(check == false) {
			items.add(t);
		}
		double sum = 0;
		for(Item o : items) {
			sum += o.getPrice()*o.getQuantity();
		}
		session.setAttribute("cart", cart);
		session.setAttribute("list", items);
		session.setAttribute("total", sum);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/cart.jsp");
		requestDispatcher.forward(req, resp);
	}
}
