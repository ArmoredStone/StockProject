package privateOrder.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import privateOrder.domain.Good;

public class GoodDAO {
	static Logger logger = Logger.getLogger(GoodDAO.class.getName());

	public static Good getGood(String name, String maker, String code, int price, String accowner) throws SQLException {
		Connection con = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		Good good = new Good();
		try {
			con = ConnectionToDB.getConnectionToDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sql = "SELECT * FROM goods WHERE name='" + name + "' AND maker='" + maker + "'  AND code='" + code
				+ "' AND price='" + price + "' AND accowner='" + accowner + "'";
		try {
			pStatement = con.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			while (rSet.next()) {
				good.setId(rSet.getInt("id"));
				good.setName(rSet.getString("name"));
				good.setMaker(rSet.getString("maker"));
				good.setGroupe(rSet.getString("groupe"));
				good.setCode(rSet.getString("code"));
				good.setDescription(rSet.getString("description"));
				good.setAccOwner(rSet.getString("accowner"));
				good.setSizeL(rSet.getInt("sizel"));
				good.setSizeH(rSet.getInt("sizeh"));
				good.setSizeW(rSet.getInt("sizew"));
				good.setPrice(rSet.getInt("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				con.close();
			}
			if (pStatement != null) {
				pStatement.close();
			}
			if (rSet != null) {
				rSet.close();
			}
		}

		return good;
	}

	public static void createGood(String name, String maker, String groupe, String code, String description,
			String accOwner, int sizeL, int sizeH, int sizeW, int price) throws SQLException {
		Connection con = null;
		PreparedStatement pStatement = null;
		// Statement pStatement = null;
		// Good goodInDB = null;
		// goodInDB = getGood(id);
		//
		// if (goodInDB.getId() != null) {
		// logger.log(Level.INFO, "Account is already exist");
		// return;
		// }
		try {
			con = ConnectionToDB.getConnectionToDB();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Connection isn't established.");
			e.printStackTrace();
		}

		// String sql = "INSERT INTO goods
		// (name,maker,groupe,code,description,owner,sizel,sizeh,sizew,price)
		// VALUES ('"
		// + name + "','" + maker + "','" + groupe + "','" + code + "','" +
		// description + "','" + owner + "','"
		// + sizeL + "','" + sizeH + "','" + sizeW + "','" + price + "')";
		String sql = "INSERT INTO goods (name,maker,groupe,code,description,accowner,sizel,sizeh,sizew,price) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, name);
			pStatement.setString(2, maker);
			pStatement.setString(3, groupe);
			pStatement.setString(4, code);
			pStatement.setString(5, description);
			pStatement.setString(6, accOwner);
			pStatement.setInt(7, sizeL);
			pStatement.setInt(8, sizeH);
			pStatement.setInt(9, sizeW);
			pStatement.setInt(10, price);
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

	public static void editCustomer(String name, String maker, String code, int price, String accowner, String newName,
			String newMaker, String newGroupe, String newCode, String newDescription, String newAccOwner, int newSizeL,
			int newSizeH, int newSizeW, int newPrice) throws SQLException {
		Good good = getGood(name, maker, code, price, accowner);
		if (good.getName() == null || good.getName().isEmpty()) {
			logger.log(Level.INFO, "Good " + name + " doesn't exist in DB to edit it!");
			return;
		}
		Connection con = null;
		PreparedStatement statement = null;

		try {
			con = ConnectionToDB.getConnectionToDB();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "UPDATE goods SET name='" + newName + "', maker='" + newMaker + "', groupe='" + newGroupe
				+ "',code='" + newCode + "',description='" + newDescription + "',accowner='" + newAccOwner + "',sizel='"
				+ newSizeL + "',sizeh='" + newSizeH + "',sizew='" + newSizeW + "',price='" + newPrice + "' WHERE name='"
				+ name + "' AND maker='" + maker + "' AND code='" + code + "' AND price ='" + price + "'AND accowner='"
				+ accowner + "'";
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
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void deleteGood(String name, String maker, String code, int price, String accowner)
			throws SQLException {
		Good good = getGood(name, maker, code, price, accowner);
		if (good.getId() == null || good.getId() == -1) {
			logger.log(Level.INFO, "Good " + name + " doesn't exist in DB to edit it!");
			return;
		}
		Connection con = null;
		PreparedStatement statement = null;

		try {
			con = ConnectionToDB.getConnectionToDB();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "DELETE FROM goods WHERE name='" + good.getName() + "' AND maker='" + good.getMaker()
				+ "' AND code='" + good.getCode() + "' AND price ='" + good.getPrice() + "'AND accowner='"
				+ good.getAccOwner() + "'";

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
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static ArrayList<Good> getGoodsByAccount(String accOwner) throws SQLException {
		ArrayList<Good> goods = new ArrayList<>();
		Connection con = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		try {
			con = ConnectionToDB.getConnectionToDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sql = "SELECT * FROM goods WHERE accowner='" + accOwner + "'";

		try {
			pStatement = con.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			while (rSet.next()) {
				Good good = new Good();
				good.setId(rSet.getInt("id"));
				good.setName(rSet.getString("name"));
				good.setMaker(rSet.getString("maker"));
				good.setGroupe(rSet.getString("groupe"));
				good.setCode(rSet.getString("code"));
				good.setDescription(rSet.getString("description"));
				good.setAccOwner(rSet.getString("accowner"));
				good.setSizeL(rSet.getInt("sizel"));
				good.setSizeH(rSet.getInt("sizeh"));
				good.setSizeW(rSet.getInt("sizew"));
				good.setPrice(rSet.getInt("price"));
				goods.add(good);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				con.close();
			}
			if (pStatement != null) {
				pStatement.close();
			}
			if (rSet != null) {
				rSet.close();
			}
		}
		return goods;

	}

//	public static ArrayList<Good> getGoodsByFiltre(String filtre) throws SQLException {
//		ArrayList<Good> goods = new ArrayList<>();
//		Connection con = null;
//		PreparedStatement pStatement = null;
//		ResultSet rSet = null;
//		try {
//			con = ConnectionToDB.getConnectionToDB();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		String sql = "SELECT * FROM goods" + filtre;
//
//		try {
//			pStatement = con.prepareStatement(sql);
//			rSet = pStatement.executeQuery();
//			while (rSet.next()) {
//				Good good = new Good();
//				good.setId(rSet.getInt("id"));
//				good.setName(rSet.getString("name"));
//				good.setMaker(rSet.getString("maker"));
//				good.setGroupe(rSet.getString("groupe"));
//				good.setCode(rSet.getString("code"));
//				good.setDescription(rSet.getString("description"));
//				good.setAccOwner(rSet.getString("accowner"));
//				good.setSizeL(rSet.getInt("sizel"));
//				good.setSizeH(rSet.getInt("sizeh"));
//				good.setSizeW(rSet.getInt("sizew"));
//				good.setPrice(rSet.getInt("price"));
//				goods.add(good);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (con != null) {
//				con.close();
//			}
//			if (pStatement != null) {
//				pStatement.close();
//			}
//			if (rSet != null) {
//				rSet.close();
//			}
//		}
//		return goods;
//
//	}

}
