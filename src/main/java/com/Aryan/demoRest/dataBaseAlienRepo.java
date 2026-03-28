package com.Aryan.demoRest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class dataBaseAlienRepo {
	Connection con = null;

	public dataBaseAlienRepo() { // FIXED: Constructor name must match class name
		String url = "jdbc:mysql://localhost:3306/restDB";
		String UserName = "root";
		String password = "Aryan2005@";
		try {
			// Modern MySQL Driver
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection(url, UserName, password);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<alien> getAliens() {
		List<alien> aliens = new ArrayList<>();
		String sql = "select * from alien";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				alien a = new alien();
				a.setMobile(rs.getInt(1));
				a.setName(rs.getString(2));
				
				aliens.add(a); // FIXED: Must add to list
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return aliens; // FIXED: Must return the list
	}

	public alien getAlien(int mobile) {
		String sql = "select * from alien where mobile=?"; // FIXED: Use placeholder to avoid SQL injection
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, mobile); // FIXED: correctly set parameter
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				alien a = new alien();
				a.setMobile(rs.getInt(1));
				a.setName(rs.getString(2));
				return a;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return new alien();
	}

	public void create(alien a1) {
		String sql ="insert into alien values(?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, a1.getMobile());
			st.setString(2, a1.getName());
			st.executeUpdate(); // FIXED: Added executeUpdate to actually save data
		} catch (SQLException e) {
			System.out.println(e);
		}
	} // FIXED: Added missing closing bracket

	public void update(alien a1) {
		String sql = "update alien set name=? where mobile=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, a1.getName());
			st.setInt(2, a1.getMobile());
			st.executeUpdate(); // FIXED: added executeUpdate
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
