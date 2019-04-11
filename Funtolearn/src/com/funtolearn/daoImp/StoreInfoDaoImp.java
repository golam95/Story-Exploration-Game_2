package com.funtolearn.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.funtolearn.dao.StoreInfoDao;
import com.funtolearn.main.DBConnection;
import com.funtolearn.model.Strore_userInfo;

public class StoreInfoDaoImp implements StoreInfoDao {

	@Override
	public void add_playerInfo(Strore_userInfo add_calorie) throws SQLException {
		Connection con = DBConnection.getConnecttion();
		String sql = "Insert into progress value(?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, add_calorie.getUser_id());
			ps.setString(2, add_calorie.getUser_name());
			ps.setString(3, add_calorie.getUser_completemodule());
			ps.setString(4, add_calorie.getSelecttype());
			ps.executeUpdate();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	@Override
	public void delete_playerInfo() throws SQLException {
		Connection con = DBConnection.getConnecttion();
		String user_delete = "Delete from progress";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(user_delete);
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean check_playerName(String name) throws SQLException {
		Connection con = DBConnection.getConnecttion();
		String check_user = "select * from progress where name='" + name + "'";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(check_user);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				con.close();
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();

		}

		return false;
	}

}
