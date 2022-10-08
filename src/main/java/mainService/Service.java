package mainService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.startup.RealmRuleSet;
import org.apache.naming.java.javaURLContextFactory;
import org.apache.tomcat.jni.OS;

import com.oracle.wls.shaded.org.apache.bcel.generic.TargetLostException;

import entity.Cart;
import entity.account;
import entity.category;
import entity.item;
import entity.product;

public class Service {
	public static ArrayList<product> getAllProducts(){
		try {
			ArrayList <product> list = new ArrayList<>();
			String query = "select * from product";
			Connection conn = BaseService.getConnection();
			PreparedStatement pr = conn.prepareStatement(query);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				list.add(new product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static ArrayList<category> getAllCategories(){
		try {
			ArrayList<category> list = new ArrayList<>();
			String query = "select * from Category";
			Connection conn = BaseService.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new category(rs.getInt(1),rs.getString(2)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static product getLastProduct() {
		try {
			String query = "select top 1 * from product order by id desc";
			Connection conn = BaseService.getConnection();
			PreparedStatement pr = conn.prepareStatement(query);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				return new product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public static ArrayList<product> getProductByCid(String cid){
		
		try {
			ArrayList<product> list = new ArrayList<>();
			String query = "select * from product where cateID = " + cid;
			Connection conn = BaseService.getConnection();
			PreparedStatement pr = conn.prepareStatement(query);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				list.add(new product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static ArrayList<product> getProductByTxt(String txt){
		try {
			ArrayList<product> list = new ArrayList<>();
			String query = "select * from product where name like '%" + txt+  "%'";
			Connection conn = BaseService.getConnection();
			PreparedStatement pr = conn.prepareStatement(query);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				list.add(new product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static product getProductById(String id) {
		try {
			
			String query = "select * from product where id = " + id;
			Connection conn = BaseService.getConnection();
			PreparedStatement pr = conn.prepareStatement(query);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				return new product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static account login(String user, String pass) {
		
		try {
			String query = "select * from Account where [user] = '" + user + "' and pass = '" +pass +"'";
			Connection conn = BaseService.getConnection();
			PreparedStatement pr = conn.prepareStatement(query);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				return new account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public static account checkAccount(String user , String pass) {
		try {
			String query = "select * from Account where [user] = '" + user + "' and pass = '" + pass + "'";
			Connection conn = BaseService.getConnection();
			PreparedStatement pr = conn.prepareStatement(query);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				return new account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static int getLastAccount() {
		try {
			String query = "select top 1 * from Account order by uID desc";
			Connection conn = BaseService.getConnection();
			PreparedStatement pr = conn.prepareStatement(query);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static void register(String user, String pass) {
		try {
			int id = getLastAccount() + 1;
			String query = "insert into Account values ('"+ user +"' "  + ",'" + pass +"',0,0)";
			System.out.println(query);
			Connection conn = BaseService.getConnection();
			PreparedStatement pr = conn.prepareStatement(query);
			pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static account checkExist(String user) {
		try {
			String query = "select * from Account where [user] = '" + user + "'";
			Connection conn = BaseService.getConnection();
			PreparedStatement pr = conn.prepareStatement(query);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				return new account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static List<product> getProductBySellId(int id) {
		try {
			ArrayList<product> list = new ArrayList<product>();
			String query = "select * from product where sell_ID = ?";
			Connection conn = BaseService.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void deleteByCid(String cid) {
		try {
			String query = "delete from product where id = ?";
			Connection conn = BaseService.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, cid);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void addProduct(String name , String image, String price , String title , String description , String cid , int id) {
		try {
			String query = "insert into product values (?,?,?,?,?,?,?)";
			
			Connection conn = BaseService.getConnection();
			PreparedStatement pr = conn.prepareStatement(query);
			pr.setString(1,name);
			pr.setString(2,image);
			pr.setString(3,price);
			pr.setString(4,title);
			pr.setString(5,description);
			pr.setString(6,cid);
			pr.setInt(7,id);
			pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void update(String name , String image , String price , String title , String description , String cid , String id) {
		try {
			String query = "update product\r\n"
					+ "set [name] = ? , [image] = ? , [price] = ? , [title] = ? , [description] = ? , [cateID] = ?\r\n"
					+ "where id = ?";
			Connection conn = BaseService.getConnection();
			PreparedStatement pr = conn.prepareStatement(query);
			pr.setString(1, name);
			pr.setString(2, image);
			pr.setString(3, price);
			pr.setString(4, title);
			pr.setString(5, description);
			pr.setString(6, cid);
			pr.setString(7, id);
			pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int getAll() {
		try {
			String query = "select count(*) from product";
			Connection conn = BaseService.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static ArrayList<product> getPageProduct(int page){
		ArrayList<product> list = new ArrayList<product>();
		try {
			String query = "select * from product order by id offset ? rows fetch next 6 rows only";
			Connection conn = BaseService.getConnection();
			PreparedStatement pr = conn.prepareStatement(query);
			pr.setInt(1, (page-1)*6);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				list.add(new product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static int getAllProductByCid(String cid) {
		try {
			String query = "select count(*) from product where cateID = ?"; 
			Connection conn = BaseService.getConnection();
			PreparedStatement pr = conn.prepareStatement(query);
			pr.setString(1, cid);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static ArrayList<product> getPageProductByCid(String cid , int index){
		ArrayList<product> list = new ArrayList<product>();
		try {
			String query = "select * from product where cateID = ? order by id offset ? rows fetch next 3 rows only";
			Connection conn = BaseService.getConnection();
			PreparedStatement pr = conn.prepareStatement(query);
			pr.setString(1,cid);
			pr.setInt(2,index);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				list.add(new product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static ArrayList<product> getProductInCart(String uID){
		ArrayList<product> list = new ArrayList<product>();
		try {
			String query = "select * from product where sell_ID = ?";
			Connection conn = BaseService.getConnection();
			PreparedStatement pr = conn.prepareStatement(query);
			pr.setString(1, uID);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				list.add(new product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
//	public static void addOrder(account acc , Cart cart) {
//		LocalDate curDate = java.time.LocalDate.now();
//		String date = curDate.toString();
//		try {
//			String query = "insert into [order] values (?,?,?)";
//			Connection conn = BaseService.getConnection();
//			PreparedStatement pr = conn.prepareStatement(query);
//			pr.setString(1,date);
//			pr.setInt(2, acc.getId());
//			pr.setDouble(3, cart.totalMoney());
//			pr.executeUpdate();
//			String query1 = "select top 1 id from [order] order by id desc";
//			PreparedStatement pr1 = conn.prepareStatement(query1);
//			ResultSet rs = pr1.executeQuery();
//			
//			if(rs.next()) {
//				int oid = rs.getInt(1);
//				for(item i : cart.getItems()) {
//					String query2 = "insert into orderline values (?,?,?,?)";
//					PreparedStatement pr2 = conn.prepareStatement(query2);
//					pr2.setInt(1, oid);
//					pr2.setInt(2, i.getPrduct().getId());
//					pr2.setInt(3, i.getQuantity());
//					pr2.setDouble(4, i.getPrice());
//					pr2.executeUpdate();
//				}
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public static void main(String[] args) {
		ArrayList<product> list =(ArrayList<product>) getProductBySellId(1);
		for(product x : list) {
			System.out.println(x);
		}
	}
}
