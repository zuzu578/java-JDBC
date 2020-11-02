	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class DB {
		public static String driver="oracle.jdbc.driver.OracleDriver";
		public static String url="jdbc:oracle:thin:@localhost:1521:orcl";
		public static String user="system"; 
		public static String password="human123";

		static Connection dbConn() throws ClassNotFoundException, SQLException{
			Class.forName(DB.driver);
	        Connection conn=DriverManager.getConnection(DB.url,DB.user,DB.password);
	        System.out.println("Oracle connection has succeeded");	
	        return conn;
		}
	} 

