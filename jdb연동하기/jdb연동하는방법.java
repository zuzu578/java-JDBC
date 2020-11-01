import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbapp {

	public static void main(String[] args) {
		//정해져있음//
		String driver = "oracle.jdbc.driver.OracleDriver";
		//localhost 부터 공통이 아님 포트번호 , 주소가 필요//
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		//user id //
		String user = "system";
		//password//
		String password = "human123";
		try {
			
			Class.forName(driver);
			//Connection conn 에서 java.sql.Connection 을 import//
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("오라클 연결 성공");
			System.out.println("jdbc driver 로딩 성공");
			//sql 문//
			String sql = "select channel_id,channel_desc "+" from channels";
		
			//java.sql.Statement import//
			Statement stmt = null;
			//executeQuery = 쿼리문을 실행//
			//import Resultset 해준다//
			//ResultSet은 결과가 2차원 배열처럼 담겨져서 나오게된다 //
			stmt=conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {			
            	int e_id = rs.getInt("channel_id");
            	String e_name = rs.getString("channel_desc");
            	//int m_id = rs.getInt("manager_id");//
            	System.out.println(e_id+","+e_name+",");
            }
            //연 순서의 역순으로 닫는다//
            conn.close();
            stmt.close();
            rs.close();
			
					
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
		}

	}

}