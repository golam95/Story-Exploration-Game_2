package com.funtolearn.dao;

import java.sql.SQLException;
import com.funtolearn.model.Strore_userInfo;

public interface StoreInfoDao {

	public void add_playerInfo(Strore_userInfo info) throws SQLException;

	public void delete_playerInfo() throws SQLException;

	public boolean check_playerName(String check_playername) throws SQLException;

}
