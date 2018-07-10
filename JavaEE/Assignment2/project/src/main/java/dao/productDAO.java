package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import com.google.protobuf.TextFormat.ParseException;

import model.product;

public class productDAO {

	public ArrayList<product> getAllProducts() {

		ArrayList<product> list = new ArrayList<product>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql5.gear.host:3306/javaeemysqldb",
					"javaeemysqldb", "Vz3ETX-6sR2?");

			String query = "select * from product";

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				product p = new product();
				p.setId(rs.getInt(1));
				p.setProductName(rs.getString(2));
				p.setProductPrice(rs.getDouble(3));

				list.add(p);

			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return list;
	}
	
	public void DeleteProductById(int id) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql5.gear.host:3306/javaeemysqldb",
					"javaeemysqldb", "Vz3ETX-6sR2?");

			String query = "delete from product where id =(?)";

			PreparedStatement st = con.prepareStatement(query);
			
			st.setInt(1, id); 
		
			st.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
public void addNewProduct(String productName, BigDecimal productPrice) {
		
				
		try {
						
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql5.gear.host:3306/javaeemysqldb",
					"javaeemysqldb", "Vz3ETX-6sR2?");

			PreparedStatement stmt= con.prepareStatement("INSERT INTO product (product_name, product_price) values (?, ?);");

			stmt.setString(1, productName);
			stmt.setBigDecimal(2, productPrice);

			stmt.executeUpdate();
			con.close();


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
