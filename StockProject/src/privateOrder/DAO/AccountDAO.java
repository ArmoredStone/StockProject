package privateOrder.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import privateOrder.domain.Account;

public class AccountDAO {

	static Logger logger = Logger.getLogger(AccountDAO.class.getName());

	public static Account getAccount(String email, String pass) throws SQLException {

		Account account = new Account();
		account.email = "";
		Connection con = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;

		try {
			con = ConnectionToDB.getConnectionToDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sql = "SELECT * FROM accounts WHERE email='" + email + "' AND pass='" + pass + "'";
		try {
			pStatement = con.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			while (rSet.next()) {
				account.login = rSet.getString("login");
				account.pass = rSet.getString("pass");
				account.phone = rSet.getString("phone");
				account.email = rSet.getString("email");
				account.address = rSet.getString("address");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rSet != null) {
				rSet.close();
			}
			if (pStatement != null) {
				pStatement.close();
			}
			if (con != null) {
				con.close();
			}

		}

		return account;
	}

	public static Account getAccountByEmail(String email) throws SQLException {

		Account account = new Account();
		account.email = "";
		Connection con = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;

		try {
			con = ConnectionToDB.getConnectionToDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sql = "SELECT * FROM accounts WHERE email='" + email + "'";
		try {
			pStatement = con.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			while (rSet.next()) {
				account.login = rSet.getString("login");
				account.pass = rSet.getString("pass");
				account.phone = rSet.getString("phone");
				account.email = rSet.getString("email");
				account.address = rSet.getString("address");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rSet != null) {
				rSet.close();
			}
			if (pStatement != null) {
				pStatement.close();
			}
			if (con != null) {
				con.close();
			}

		}

		return account;
	}

	public static void createAccount(String login, String pass, String phone, String address, String email)
			throws SQLException {
		Connection con = null;
		PreparedStatement pStatement = null;
		Account accountInDB = null;
		accountInDB = getAccount(email, pass);

		if (!accountInDB.email.isEmpty()) {
			logger.log(Level.INFO, "Account is already exist");
			return;
		}
		try {
			con = ConnectionToDB.getConnectionToDB();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Connection isn't established.");
			e.printStackTrace();
		}

		String sql = "INSERT INTO accounts (login, pass,phone,email,address) VALUES (?,?,?,?,?)";
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, login);
			pStatement.setString(2, pass);
			pStatement.setString(3, phone);
			pStatement.setString(4, email);
			pStatement.setString(5, address);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement != null)
					pStatement.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void editAccount(String login, String password, String newLogin, String newPassword, String newPhone,
			String newEmail, String newAddress) throws SQLException {
		Account account = getAccount(login, password);
		if (account.email.isEmpty()) {
			logger.log(Level.INFO, "Customer " + login + " doesn't exist in DB to edit it!");
			return;
		}
		Connection con = null;
		PreparedStatement statement = null;

		try {
			con = ConnectionToDB.getConnectionToDB();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "UPDATE accounts SET(login,pass,phone,email,address) VALUES(?,?,?,?,?) WHERE email='"
				+ account.email + "'";

		// String sql = "UPDATE accounts SET login='" + newLogin + "', pass='" +
		// newPassword + "', phone='"
		// + newPhone+ "',email='" + newEmail+ "',address='" + newAddress + "'
		// WHERE login='"
		// + account.getLogin() + "'";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, newLogin);
			statement.setString(2, newPassword);
			statement.setString(3, newPhone);
			statement.setString(4, newEmail);
			statement.setString(5, newAddress);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	public static void deleteAccount(String email, String password) throws SQLException {
		Account account = getAccount(email, password);
		if (account.email.isEmpty()) {
			logger.log(Level.INFO, "Customer " + email + " doesn't exist in DB to delete it!");
			return;
		}
		Connection con = null;
		PreparedStatement statement = null;

		try {
			con = ConnectionToDB.getConnectionToDB();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "DELETE FROM accounts WHERE email='" + account.email + "'";

		try {
			statement = con.prepareStatement(sql);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (con != null) {
				con.close();
			}
		}
	}

}
