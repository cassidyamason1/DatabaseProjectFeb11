package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateExample {

public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
		
		Statement stm = con.createStatement(); //cannot execute query w/o statement object
		
		//return number of rows that are impacted
		stm.executeUpdate("update eproduct set price=2000 where name= 'Tablet'"); 
		
		
		ResultSet result = stm.executeQuery("select * from eproduct");
		
		while(result.next()) {
			System.out.println(result.getInt("ID"));
			System.out.println(result.getString("name"));
			System.out.println(result.getInt("price"));
		}
		
		con.close();

	
}
}
