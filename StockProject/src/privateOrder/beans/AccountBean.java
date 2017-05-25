package privateOrder.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import privateOrder.DAO.GoodDAO;
import privateOrder.domain.Good;

public class AccountBean {
	public ArrayList<Good> getGoodsForAccount(String email){
		ArrayList <Good> goods = new ArrayList<>();
		try {
			goods = GoodDAO.getGoodsByAccount(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goods;
	}
}
