package privateOrder.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import privateOrder.DAO.GoodDAO;
import privateOrder.domain.Good;

public class GoodsListBean {
	public ArrayList<Good> getGoodsForIndex() {
		ArrayList<Good> goods = new ArrayList<>();
		ArrayList<Good> goodsFromDB = new ArrayList<>();
		try {
			goodsFromDB = GoodDAO.getGoodsByFiltre("");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(goodsFromDB.size()<=10){
			goods = goodsFromDB;
		}
		for(int i = (goodsFromDB.size()-1);i>=0;i--){
			goods.add(0, goodsFromDB.get(i));
			if(goods.size()==10){
				break;
			}
		}
		return goods;
	}	
}
