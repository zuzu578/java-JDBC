import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class Order extends Menu {
	//--->제품입력 scanner<---//
	Scanner sc1= new Scanner(System.in);
	//--->수량입력 scanner<---//
	Scanner sc2 = new Scanner(System.in);
	//--->모바일번호 입력 scanner<---//
	Scanner sc3 = new Scanner(System.in);
	//--->모바일번호 ArrayList<---//
	Scanner sc4 = new Scanner(System.in);
	ArrayList<String> mobile1 = new ArrayList<String>();
	//--->메뉴ArrayList<---//
	ArrayList<String> menu1 = new ArrayList<String>();
	//--->수량ArrayList<---//
	ArrayList<Integer> count1 = new ArrayList<Integer>();
	Order(){
		mobile1 = new ArrayList<String>();
		menu1 = new ArrayList<String>();
		count1= new ArrayList<Integer>();
	}
	//-->addOrder = 제품,가격,수량을 입력받아야함<--//
		void addOrder(Connection conn) throws SQLException, ClassNotFoundException {
		
		
		System.out.println("원하시는 제품을 입력해주세요.취소는 공백");
        String menu2 = sc1.nextLine();
        //제품 ArrayList저장//
        menu1.add(menu2);
        while(!menu2.equals("")) {
        	System.out.println("수량을 입력해주세요.");
        	int count2 = sc2.nextInt();
        	//수량 ArrayList저장//
        	count1.add(count2);
        	System.out.println("");
        	System.out.println("모바일번호를 입력해주세요.");
            String mobile = sc3.nextLine();
          //모바일번호 ArrayList저장//
            mobile1.add(mobile);
//            System.out.println("1");
//            String sql = "select price from menu";
//            System.out.println("2");
//            Statement stmt=conn.createStatement();
//            System.out.println("3");
//            ResultSet rs=stmt.executeQuery(sql);
//            System.out.println("4");
//            int price2 = rs.getInt("price");         
//            System.out.println("5");
    		sql = "select price from menu where name ='"+menu2+"'";
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            rs.next();
            int price2 = rs.getInt("price");
            rs.close();
            stmt.close();
               

//            
            String sql1="insert into custom values(?,?,?,?,to_char(sysdate,'yyyymmdd'))";
   		 	PreparedStatement ps1 = conn.prepareStatement(sql1);
            //제품DB//
			ps1.setString(1,menu2 );
            //수량DB//
            ps1.setInt(2,count2);
            //모바일번호DB//
            ps1.setInt(3, price2);
            ps1.setString(4, mobile);
            ps1.executeUpdate();
            System.out.println("원하시는 제품을 입력해주세요.취소는 공백");
            menu2 = sc1.nextLine();
            menu1.add(menu2);
            
//            Menu menu = new Menu();
//            menu.price(conn);
             
//            rs.close();
//            stmt.close();
        }
        conn.close();
        
	}

    void getMethod() {
    	for(int i = 0 ; i<=mobile1.size();i++) {
    	  System.out.println(mobile1.get(i));
    	}
    	for(int j = 0 ; j<=menu1.size();j++) {
    		System.out.println(menu1.get(j));
    	}
    	for(int k = 0 ; k<=count1.size();k++) {
    		System.out.println(count1.get(k));
    	}
    	
    }
    void total(Connection conn) throws SQLException, ClassNotFoundException{
    	String sql7 = "select order_number, order_cnt, price, mobile, order_date from custom";
        Statement stmt7=conn.createStatement();
        ResultSet rs=stmt7.executeQuery(sql7);
        int sum =0;
        while(rs.next()) {
        	int order_number = rs.getInt("order_number");
        	int order_cnt = rs.getInt("order_cnt");
        	int price = rs.getInt("price");
        	int mobile = rs.getInt("mobile");        	
        	int order_date = rs.getInt("order_date");
        	
        	while(rs.next()) {
        		System.out.println(order_cnt*price+"원, 번호: " + mobile+", 주문날짜:" + order_date);
        		sum += order_cnt*price;
        	}System.out.println(sum);
      
        };System.out.println("2");
        
        rs.close();
        stmt7.close();
    	
    	
    	
    }
    

}