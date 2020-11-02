
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class DBapp {

   public static void main(String[] args) {
      try {
           
    	  Menu1 menu = new Menu1();
    	  Order order = new Order();


         System.out.println("작업을 선택하세요");
         System.out.println("1.메뉴추가, 2.삭제, 3.수정, 4.조회, 5.주문, 6.매출조회, 0.종료 ");
         Scanner s = new Scanner(System.in);
         int i = s.nextInt();
         while(i!=0) {
            switch(i) {
            case 1:

            	menu.buildMenu();
            	System.out.println("----------------------");
            
            	break;

            case 2:

            	menu.deleteMenu();
            	System.out.println("----------------------");
            	break;

            case 3:

            	menu.updateMenu();
            	System.out.println("----------------------");
            	break;

            case 4:

            	menu.selectMenu();
            	System.out.println("----------------------");
            	break;

            case 5:
            	
            	
            	
            	order.addOrder();
            	break;

            case 6:
            	order. total();
            }
            System.out.println("1.메뉴추가, 2.삭제, 3.수정, 4.조회, 5.주문, 6.매출조회, 0.종료");
               i = s.nextInt();
         }
         System.out.println("End");







      }catch(ClassNotFoundException e) {
            System.out.println("JDBC Driver loading has failed");
         } catch(SQLException e) {
            System.out.println("Oracle connection has failed");
         }


      }
   } 