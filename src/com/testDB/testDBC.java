package com.testDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testDBC {
	
	 public static void main(String[] args) {

	        Connection conn = null;
	        String dbName = "Employee_Database";
	        String serverip="IN2162918W1";
	        String serverport="1433";
	        String url = "jdbc:sqlserver://"+serverip+"\\SQLEXPRESS:"+serverport+";databaseName="+dbName+"";
	        Statement stmt = null;
	        ResultSet result = null;
	        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	        String databaseUserName = "sa";
	        String databasePassword = "Qwert12345%test";
	        try {
	            Class.forName(driver).newInstance();
	            conn = DriverManager.getConnection(url, databaseUserName, databasePassword);
	            stmt = conn.createStatement();
	            result = null;
	            String pa,us;
	            result = stmt.executeQuery("select * from employees ");
System.out.println("result : "+result);
	            while (result.next()) {
	                us=result.getString("uname");
	                pa = result.getString("pass");              
	                System.out.println(us+"  "+pa);
	            }

	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
