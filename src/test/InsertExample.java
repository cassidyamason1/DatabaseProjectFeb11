package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class InsertExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
		
		Statement stm = con.createStatement(); //cannot execute query w/o statement object
		
		//return number of rows that are impacted
		stm.executeUpdate("insert into eproduct (name, price, date_added) values ('Tablet', 1500.00, now())"); 
		
		ResultSet result = stm.executeQuery("select * from eproduct");
		
		while(result.next()) {
			System.out.println(result.getInt("ID"));
			System.out.println(result.getString("name"));
			System.out.println(result.getInt("price"));
		}
		
		con.close();

	}

}
