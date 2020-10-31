JDBC 


String sql="insert into menu values (?,?)";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			Scanner s = new Scanner(System.in);
//			Scanner t = new Scanner(System.in);
//			System.out.println("등록하실 메뉴 이름을 입력하세요 (공백 입력시 종료)");
//			String menu = s.nextLine();
//			while(!menu.equals("")) {
//				System.out.println("등록하신 메뉴의 가격을 입력하세요");
//				int price = t.nextInt();
//				ps.setString(1, menu);
//				ps.setInt(2, price);
//				ps.executeUpdate();
//				System.out.println("계속 등록하시려면 메뉴 이름을 입력하시고 종료하시려면 공백을 입력하세요.");
//				menu=s.nextLine();
//			}
//			System.out.println("종료합니다");
			

















case 2:   
					String sql2="delete from menu where name=?";
					PreparedStatement ps2 = conn.prepareStatement(sql2);
					System.out.println("삭제하실 메뉴 이름을 입력하세요(공백 입력시 종료)");
					String m4 = t.nextLine();
					while(!m4.equals("")) {
						ps2.setString(1, m4);
						ps2.executeUpdate();
						System.out.println("삭제하실 메뉴 이름을 입력하세요(공백 입력시 종료)");
						m4 = t.nextLine();
					}
					ps2.close();
					break;
				case 3:
					String sql3="update menu set name=?, price=? where name=?";
					PreparedStatement ps3 = conn.prepareStatement(sql3);
					System.out.println("바꾸실 기존메뉴 이름을 입력하세요(공백 입력시 종료)");
					String m5 = t.nextLine();
					while(!m5.equals("")) {
						String oldmenu =m5;
						System.out.println("바꾸실 새로운 메뉴 이름을 입력하세요(취소시 기존메뉴이름 입력)");
						String m6 = w.nextLine();
						String newmenu =m6;
						System.out.println("바꾸실 새로운 메뉴의 가격을 입력하세요(취소시 기존메뉴가격 입력)");
						int m7 = u.nextInt();
						int newprice = m7;
						ps3.setString(1, newmenu);
						ps3.setInt(2, newprice);
						ps3.setString(3, oldmenu);
						ps3.executeUpdate();
						System.out.println("바꾸실 기존메뉴 이름을 입력하세요(공백 입력시 종료)");
						m5 = t.nextLine();
					}
					ps3.close();
					break;
				case 4:
					String sql = "select name,price from menu";
					Statement stmt=null;
					stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					System.out.println("메뉴 | 가격");
					while(rs.next()) {
						String me_name=rs.getString("name");
						int me_price=rs.getInt("price");
						System.out.println(me_name +" | "+me_price);
					}
					stmt.close();
					break;
				default:
					System.out.println("잘못입력하였습니다.");
					break;
				}
				System.out.println("작업선택 1.메뉴추가 2.메뉴제거 3.메뉴수정 4.메뉴조회 0.종료");
				m1=s.nextInt();
			}
			System.out.println("종료합니다.");
			conn.close();
