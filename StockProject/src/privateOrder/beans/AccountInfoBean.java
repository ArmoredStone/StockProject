package privateOrder.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import privateOrder.DAO.AccountDAO;
import privateOrder.DAO.GoodDAO;
import privateOrder.domain.Account;
import privateOrder.domain.Good;

public class AccountInfoBean {
	public Account getAccountInfo(String email) {
		Account acc = new Account();
		try {
			acc = AccountDAO.getAccountByEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}

	public ArrayList<Good> getGoodsByAcc(String email) {
		ArrayList<Good> accGoods = new ArrayList<>();
		try {
			accGoods = GoodDAO.getGoodsByAccount(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accGoods;
	}

}
