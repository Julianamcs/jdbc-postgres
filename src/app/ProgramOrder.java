/**
 * 
 */
package app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import entities.Order;
import entities.OrderStatus;
import entities.Product;

/**
 * @author julya
 *
 */
public class ProgramOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException {
			// TODO Auto-generated method stub
			
			Connection conn = DB.getConnection();
		
			Statement st = conn.createStatement();
				
			ResultSet rs = st.executeQuery("select * from tb_order");
				
			while (rs.next()) {
				
				Order o = instantiateOrder(rs);
				
				System.out.println(o + "\r\n");
		
			}
		}
		
		private static Order instantiateOrder(ResultSet rs)  throws SQLException{
			
			Order order = new Order();
			order.setId(rs.getLong("id"));
			order.setLatitude(rs.getDouble("latitude"));
			order.setLongitude(rs.getDouble("longitude"));
			order.setMoment(rs.getTimestamp("moment").toInstant()); 
			order.setStatus(OrderStatus.values()[rs.getInt("status")]); 
			
			return order;
		}
		
		private static Product instantiateProduct(ResultSet rs)  throws SQLException{
			
			Product product = new Product();
			product.setId(rs.getLong("id"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getDouble("price")); 
			product.setDescription(rs.getString("description")); 
			product.setImageUri(rs.getString("image_uri"));
			
			return product;
		}
}