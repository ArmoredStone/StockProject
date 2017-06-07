package privateOrder.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import privateOrder.DAO.AccountDAO;
import privateOrder.DAO.GoodDAO;
import privateOrder.domain.Account;
import privateOrder.domain.Good;

@WebServlet("/accounts")
public class AccountsServlet extends HttpServlet {
	Logger log = Logger.getLogger(AccountsServlet.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = (String) request.getParameter("action");
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		if (action.equals("create")) {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			try {
				if (!AccountDAO.getAccount(email, null).email.equals("")) {
					response.sendRedirect("jsp/goawayreg.jsp");
				}
				AccountDAO.createAccount(login, password, phone, address, email);
				log.info("| Login - " + login + " | Email - " + email + " | Password - " + password + " | Phone - "
						+ phone + " | Address - " + address);
				response.sendRedirect("jsp/usercabinet.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
