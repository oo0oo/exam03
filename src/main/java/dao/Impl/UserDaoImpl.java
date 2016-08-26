package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UserDao;
import entity.User;

public class UserDaoImpl implements UserDao {

	public boolean add(Connection con, User user) throws SQLException {
		PreparedStatement ps = con.prepareCall
				("insert into film (title,description,language_id) values (?,?,?)");
		ps.setString(1, user.getTitle());
		ps.setString(2, user.getDescription());
		ps.setString(3, "1");
		return ps.execute();
		
	}

	public ResultSet display(Connection con) throws SQLException {
		PreparedStatement ps = con.prepareCall
				("select film.title ,film.description,language.name from film , language where film.language_id = language.language_id");
	
		return ps.executeQuery();
		
	}

	public void delete(Connection con, User user) throws SQLException {
		
	}

	public ResultSet get(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer WHERE first_name=?");
		ps.setString(1, user.getName());
		
		return ps.executeQuery();
	}

}
