import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class MysqlConnect{

	public Connection conn;
	//String  url = "jdbc:mysql://projetointegrado.ddns.net:3306/";
	private static String  url = "jdbc:mysql://localhost/";
	private static String  db = "projeto-integrado";
	private static String  driver = "com.mysql.jdbc.Driver";
	private static String  user = "root";
	private static String  pass = "123mudar";
	
	public MysqlConnect(){
		conn = null;
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