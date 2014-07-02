package daolayers;

import java.sql.Connection;
import java.sql.DriverManager;
public class databaseconnection{
public static Connection con=null;
public static String uname="root";
public static String pass="";
public static String url="jdbc:mysql://localhost:3306/gharbazar";
public static String driver="com.mysql.jdbc.Driver";
public static Connection getConnection() throws NullPointerException{
	
	try{
	
		Class.forName(driver);
		con=DriverManager.getConnection(url,uname,pass);
			
		}
	catch(Exception e){
		
		System.out.println("Connection fail"+e);
	}
	
	return con;
	
}

}
