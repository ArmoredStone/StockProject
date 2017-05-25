package privateOrder.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import privateOrder.DAO.AccountDAO;
import privateOrder.domain.Account;

@WebServlet("/authorisation")
public class AuthorisationServlet extends HttpServlet {

	Logger log = Logger.getLogger(AuthorisationServlet.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Account account = new Account();
		try {
			Class.forName("org.postgresql.Driver");
			account = AccountDAO.getAccount(email, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!account.email.isEmpty()) {
			HttpSession session = request.getSession();
			session.setAttribute("email", account.email);
			session.setAttribute("login", account.login);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/usercabinet.jsp");
			dispatcher.forward(request, response);
			log.info("msg");
		} else {
			log.info("go away");
			response.sendRedirect("jsp/goawayauth.jsp");
		}

	}

}
