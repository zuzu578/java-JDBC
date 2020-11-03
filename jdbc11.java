
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu2 {
   //CRUD 구현//
   //CRUD 에 맞는 메소드를 생성하고 그 메소드에서 각자의 역할을 분담하면된다//
	 Menu2(){
		 
	 }
	void buildMenu()throws SQLException, ClassNotFoundException {
		//DB를 열어주기//
		Connection conn=DB.dbConn();
		//SQL 문을 대기시킨다(준비시킨다)//
		String sql1 = "insert into menu values(?,?)";
		//연결을 준비함//
		PreparedStatement ps1 = conn.prepareStatement(sql1);
		System.out.println("메뉴를 입력해주세요");
		Scanner sc1= new Scanner(System.in);
		String addMenu = sc1.nextLine();
		while(!addMenu.equals("")) {
			System.out.println("가격을 입력해주세요.");
			Scanner sc2= new Scanner(System.in);
			int addPrice = sc2.nextInt();
			ps1.setString(1,addMenu);
			ps1.setInt(2, addPrice );
			ps1.executeUpdate();
			System.out.println("메뉴를 입력해주세요");
			sc1= new Scanner(System.in);
			addMenu = sc1.nextLine();
		}
		ps1.close();
		//DB를 마지막에 닫는다//
		conn.close();
		
		
	}
	void removeMenu()throws SQLException, ClassNotFoundException {
		//DB를 열어주기//
		Connection conn=DB.dbConn();
		String sql2 = "delete from menu where name=?";
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		System.out.println("삭제하실 메뉴를 입력해주세요.");
		Scanner sc3 = new Scanner(System.in);
		String deleteMenu = sc3.nextLine();
		while(!deleteMenu.equals("")) {
			ps2.setString(1, deleteMenu);
			ps2.executeUpdate();
			System.out.println("삭제하실 메뉴를 입력해주세요.");
			sc3 = new Scanner(System.in);
			deleteMenu = sc3.nextLine();
		}
		ps2.close();
		//DB연결끊기//
		conn.close();
	}
	void updateMenu()throws SQLException, ClassNotFoundException {
		//DB를 열어주기//
		Connection conn=DB.dbConn();
		 String sql3 = "update menu set name=?,price=? where name=?";
         PreparedStatement ps3=conn.prepareStatement(sql3);
        System.out.println("수정할 메뉴 이름을입력해주세요");
        Scanner n = new Scanner(System.in);
        String oldName = n.nextLine();
       while(!oldName.equals("")) {
          System.out.println("새 메뉴 이름을 입력해주세요");
          Scanner s = new Scanner(System.in);
          String newMenuName = s.nextLine();
          System.out.println("새 가격을 입력해주세요.");
          Scanner k = new Scanner(System.in);
           int newPrice = k.nextInt();
           ps3.setString(1,newMenuName);
           ps3.setInt(2,newPrice);
           ps3.setString(3,oldName);
           ps3.executeUpdate();
           System.out.println("수정할 메뉴 이름");
           oldName =  n.nextLine();
          
       }
       System.out.println("입력완료");
       ps3.close();
       conn.close();
		
	}
	void selectMenu()throws SQLException, ClassNotFoundException {
		//DB를 열어주기//
		Connection conn=DB.dbConn();
		String sql4 = "select name,price "+"from menu";
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql4);
      while(rs.next()) {
           String m_name = rs.getString("name");
           int m_price = rs.getInt("price");
           System.out.println(m_name+","+m_price);
      }
      rs.close();
      stmt.close();
	System.out.println("End");
	conn.close();
	}
	 
}
