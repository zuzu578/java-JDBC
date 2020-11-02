import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Menu  {
	public ArrayList<String> alName;
	public ArrayList<Integer> alPrice;
	String sql;
	Scanner sName = new Scanner(System.in);
    Scanner sPrice = new Scanner(System.in);//Scanner에 String과 int 둘 다 사용시 new Scanner 만들어서 구분 
	
	Menu(){
		alName = new ArrayList<String>();
		alPrice = new ArrayList<Integer>();
		
	}
	public ArrayList<String> getMenu() {
		return this.alName;
	}
	public ArrayList<Integer> getPrice() {
		return this.alPrice;
	}
	
	void buildMenu(Connection conn) throws ClassNotFoundException, SQLException{
		
		DB.dbConn();
        System.out.println("----------------");
        System.out.println("<1.메뉴추가>");
   
        
        //메뉴추가 1, 삭제 2, 수정 3, 조회 4, 종료 0 
       Menu menu = new Menu();
       Order order = new Order();
       
       this.sql = "insert into menu values(?,?)";
       PreparedStatement ps=conn.prepareStatement(sql); //앞 Prepare'd' 뒤 prepare 구분 
       
       System.out.println("음료입력");
       String name = sName.nextLine();
       alName.add(name);
       
      while(!name.equals("")) {
              System.out.println("가격입력");
              int price = sPrice.nextInt();
              this.alPrice.add(price);
              ps.setString(1,name);
              ps.setInt(2,price);
              ps.executeUpdate();
              System.out.println("음료입력");
              name = sName.nextLine();
              alName.add(name);
           }
      System.out.println("----------------------");
      System.out.println("입력완료");
      ps.close();

	}
	
	void menuRemove(Connection conn) throws ClassNotFoundException, SQLException {
		DB.dbConn();
        sql = "delete from menu where name=?";
        PreparedStatement ps1=conn.prepareStatement(sql);
        
        System.out.println("지울 메뉴 이름");

       String name1 = sName.nextLine();
      while(!name1.equals("")) {
         
              ps1.setString(1,name1);
              ps1.executeUpdate();
              System.out.println("지울 메뉴 이름");
              name1 = sName.nextLine();
              
      }
      System.out.println("입력완료");
      ps1.close();
	}
	
	void menuUpdate(Connection conn) throws ClassNotFoundException, SQLException {
		sql = "update menu set name=?,price=? where name=?";
        PreparedStatement ps2=conn.prepareStatement(sql);
        
       System.out.println("수정할 메뉴 이름");
       String name2 = sName.nextLine();
      while(!name2.equals("")) {
         System.out.println("새 메뉴 이름");
         String Nname = sName.nextLine();
         System.out.println("새 가격");
          int Nprice = sPrice.nextInt();
          ps2.setString(1,Nname);
          ps2.setInt(2,Nprice);
          ps2.setString(3,name2);
          ps2.executeUpdate();
          System.out.println("수정할 메뉴 이름");
           name2 = sName.nextLine();
         
      }
      System.out.println("입력완료");
      ps2.close();
	}
	
	void menuList(Connection conn) throws ClassNotFoundException, SQLException {
//		DB.dbConn();
		sql = "select name,price "+"from menu";
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
      while(rs.next()) {
           String m_name = rs.getString("name");
           int m_price = rs.getInt("price");
           System.out.println(m_name+","+m_price);
         
      }
      rs.close();
      stmt.close();
	}
	
	void price(Connection conn) throws ClassNotFoundException, SQLException {
//		DB.dbConn();
		sql = "select name,price "+"from menu";
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
      while(rs.next()) {
           String m_name = rs.getString("name");
           int m_price = rs.getInt("price");
           System.out.println(m_price);
         
      }
      rs.close();
      stmt.close();
	}
	
	
	
	void subMenu() {
		System.out.println("--------------------");
		System.out.println("<오늘의"
				+ " 메뉴>");
		for(int i=0; i<this.alName.size();i++) {
			System.out.print((i+1)+"."+this.alName.get(i));
			System.out.print("\t"+this.alPrice.get(i)+"원\n");
		}
	}
}