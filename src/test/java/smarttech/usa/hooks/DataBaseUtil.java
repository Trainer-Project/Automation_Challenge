package smarttech.usa.hooks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import smarttech.usa.basepage.BasePage;

public class DataBaseUtil extends BasePage{

	
	public static void main(String[] args) throws Throwable {
		Class.forName("oracle.jdbc.driver.OracleDriver");   
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "hr", "hr");		                                                                            // JDBC URL, Host Number, Database Name, UserName & Password		
			// Statement is an interface 
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(prop.getProperty(prop.getProperty("innerJoin")));
		    List<String> columnValue = new ArrayList<String>(); 
			while (rs.next()) {
				columnValue.add(rs.getString("First_name"));
			}
		    System.out.println(columnValue); }
	
}
	
