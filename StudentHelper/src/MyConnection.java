import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpSession;

public class MyConnection {
	
	public MyConnection() {	}
	
	public static Connection connect() {
	    Connection con = null;
	    String url = "jdbc:mysql://localhost:3306/MySql";
	    String driver = "com.mysql.jdbc.Driver";
	    String user = "root";
	    String pass = "wjj163401";
	    try {
	    	Class.forName(driver);
	        con = DriverManager.getConnection(url, user, pass);
	        if (con == null) {
	            System.out.println("Connection cannot be established");
	            return null;
	        }
	        else {System.out.println("Connection has established");return con;}
	        
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	
//	public static void main(String args[]) throws IOException
//	{
//	    Connection con = MyConnection.connect();
//		Statement stmt = null;
//	    try {
//			stmt = con.createStatement();
//			String query = "select * from team19.user ";
//			ResultSet rs = stmt.executeQuery(query);
//			if (rs.next()) {
//
//				System.out.println("success");
//
//			}
//			else {
//				System.out.println("not succes");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				if (stmt != null) { stmt.close();}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//		}
//	}
}
