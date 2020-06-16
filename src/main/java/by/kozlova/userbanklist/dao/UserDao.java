package by.kozlova.userbanklist.dao;

import by.kozlova.userbanklist.bean.User;

import java.sql.*;

public class UserDao {
	public final static String GET_BY_ID = "SELECT name, surname FROM user WHERE id=?";

	public User getById(int id) throws DaoException {
		User userBean = new User();

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		ResultSet rs = null;
		try (Connection con = DriverManager.getConnection(DaoConstans.DB_URL, DaoConstans.DB_USERNAME,
				DaoConstans.DB_PASSWORD); PreparedStatement ps = con.prepareStatement(GET_BY_ID)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				userBean.setName(rs.getString(1));
				userBean.setSurname(rs.getString(2));
			}

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DaoException(e);
			}
		}
		return userBean;
	}
}