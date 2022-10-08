package controller;

import java.io.IOException;
import java.util.ArrayList;

import entity.account;
import entity.product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mainService.Service;
@WebServlet(urlPatterns = {"/delete"})
public class deleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		account a = (account)session.getAttribute("acc");
		int id = a.getId();
		String cid = req.getParameter("pid");
		Service.deleteByCid(cid);
		resp.sendRedirect("managerProduct");
	}
}
