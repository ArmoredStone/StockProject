package privateOrder.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionToDB {
	private static final String URL = "jdbc:postgresql://localhost:5432/StockDB";
	private static final String USER = "postgres";
	private static final String PASSWORD = "12345";

	static Logger log = Logger.getLogger(ConnectionToDB.class.getName());

	public static Connection getConnectionToDB() throws Exception {
		Class.forName("org.postgresql.Driver");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			if (connection != null) {
				return connection;
			} else {
				throw new Exception("Connection is not established!");
			}
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new Exception("Connection is not established!");
		}
	}
}
