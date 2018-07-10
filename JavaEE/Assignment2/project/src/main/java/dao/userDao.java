package dao;

import model.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class userDao {
	
	public user getUser(String username) {
		
		user u = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://den1.mysql5.gear.host:3306/javaeemysqldb"
					, "javaeemysqldb",
					"Vz3ETX-6sR2?"
					);
			
			String query = "select * from user where username=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				u = new user();
				String nameFromDB = rs.getString("username");
				String passwordFromDB = rs.getString("password");
				
				u.setUsername(nameFromDB);
				u.setPassword(passwordFromDB);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}


}
