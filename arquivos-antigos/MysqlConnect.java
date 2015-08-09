import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class MysqlConnect{
	public Connection conn;	
	
	public MysqlConnect(){
		conn = null;
		//String  url = "jdbc:mysql://projetointegrado.ddns.net:3306/";
      String  url = "jdbc:mysql://localhost/";
		String  db = "projeto-integrado";
		String  driver = "com.mysql.jdbc.Driver";
		String  user = "root";
		String  pass = "";
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url+db,user,pass);
		}catch(Exception e){
         e.printStackTrace();
         System.exit(1);
		}
	}
	
	
	
	public void closeConnection(){
		try{
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}