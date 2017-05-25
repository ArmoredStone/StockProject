package privateOrder.domain;

import java.sql.SQLException;

import privateOrder.DAO.AccountDAO;
import privateOrder.DAO.GoodDAO;

public class Main {

	public static void main(String[] args) {
		try {
			AccountDAO.createAccount("owner", "owner", "owner", "owner", "owner");
			for(int i = 0; i < 6; i++){
				GoodDAO.createGood("name", "maker", "groupe", "code", "description", "owner", 4, 3, 2, 22);
			}
			System.out.println("owner".equals("owner"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
