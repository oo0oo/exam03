package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public interface UserDao {
	public boolean add(Connection con,User user) throws SQLException;
	public ResultSet display(Connection con) throws SQLException;
	public void delete(Connection con,User user) throws SQLException;
	public ResultSet get(Connection conn,User user) throws SQLException;
}	
