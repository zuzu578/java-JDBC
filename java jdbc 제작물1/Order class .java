import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


	public class Order   {
    
	 Scanner sc1 = new Scanner(System.in);
	 Scanner sc2 = new Scanner(System.in);
	 Scanner sc3 = new Scanner(System.in);
	 Scanner sc4 = new Scanner(System.in);
    int howManyCount ;
    String mobileNumber;
    int getPrice ;
    int wantMenu;
	
	Order(){
		
	}
	
	    void addOrder(Connection conn) throws SQLException, ClassNotFoundException {
	    	
            String sql1="insert into  custom values(?,?,?,?,to_char(sysdate,'yyyymmdd'))";
   		 	PreparedStatement ps1 = conn.prepareStatement(sql1);
   		 	System.out.println("원하시는 제품번호를 입력해주세요.취소는 공백 ");
   		 	wantMenu = sc1.nextInt();
   		 	while(wantMenu!=0) {
   		 		System.out.println("수량을 입력해주세요.");
   		 		howManyCount = sc2.nextInt();
   		 		System.out.println("모바일 번호를 입력해주세요.");
   		 		mobileNumber = sc3.nextLine();
   		 		System.out.println("지불하실 금액을 입력해주세요..");
   		 		getPrice = sc4.nextInt();
   		 		
   		 	
            //제품DB//
			ps1.setInt(1,wantMenu);
            //수량DB//
            ps1.setInt(2,howManyCount);
            //가격DB//
            ps1.setInt(3, getPrice);
            //모바일번호 DB//
            ps1.setString(4,mobileNumber);
            ps1.executeUpdate();
            System.out.println("원하시는 제품번호를 입력해주세요.취소는 공백");
            wantMenu = sc1.nextInt();
   		 	}
   		    conn.close();
   		 	
	}
	    
    void total(Connection conn) throws SQLException, ClassNotFoundException{
    	
    	String sql = "select order_number, order_cnt, price, mobile, order_date from custom";
		Statement stmt=null;
		stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		System.out.println("메뉴 | 가격");
		while(rs.next()) {
			int order_number = rs.getInt("order_number");
        	int order_cnt = rs.getInt("order_cnt");
        	 int price = rs.getInt("price");
        	int mobile = rs.getInt("mobile");        	
        	int order_date = rs.getInt("order_date");
        	System.out.println(order_number + "번 음료, "+order_cnt+"잔, " + price+"원, 번호: " + mobile+", 주문날짜:" + order_date);
        	
		}
		stmt.close();
		
		
    }


    

} 