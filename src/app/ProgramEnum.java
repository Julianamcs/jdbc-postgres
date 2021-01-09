/**
 * 
 */
package app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import db.DB;
import entities.Order;
import entities.OrderStatus;
import entities.Product;

/**
 * @author julya
 *
 */
public class ProgramEnum {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Connection conn = DB.getConnection();
		
		Statement st = conn.createStatement();
			
		ResultSet rs = st.executeQuery("SELECT * FROM tb_order "
				+ "INNER JOIN tb_order_product ON tb_order.id = tb_order_product.order_id "
				+ "INNER JOIN tb_product ON tb_product.id = tb_order_product.product_id");
			
		/*Coleção de pares valores para não se reperir os valores */
		Map<Long, Order> mapOrd = new HashMap<>();
		Map<Long, Product> mapProd = new HashMap<>();
		
		
		while (rs.next()) {
			
			/**Order**/
			
			/*sempre que passar dentro do while vamos testar se o esse order já existe dentro do Map**/
			Long orderId = rs.getLong("order_id");
			
			/*criar o if para testar a condição se a existe ou ssão iguais*/
			if(mapOrd.get(orderId) == null) {
				
				/*o id não existe então instacia */
				Order o = instantiateOrder(rs);
				
				/*salava sentro do map*/
				mapOrd.put(orderId, o);
			}
			
			/**Product**/
			
			/*sempre que passar dentro do while vamos testar se o esse order já existe dentro do Map**/
			Long productId = rs.getLong("product_id");
			
			/*criar o if para testar a condição se a existe ou ssão iguais*/
			if(mapProd.get(productId) == null) {
				
				/*passando os dados do produto também*/
				Product p = instantiateProduct(rs);
				
				/*salava sentro do map*/
				mapProd.put(productId, p);
			}
			
			
			/*associação do pedido com os produtos*/
			mapOrd.get(orderId).getProducts().add(mapProd.get(productId));
	
		}
		
		for (Long orderId : mapOrd.keySet()) {
			System.out.println(mapOrd.get(orderId));
			for (Product p : mapOrd.get(orderId).getProducts()) {
				System.out.println(p);
			}
			System.out.println();
		}
	}
	
	private static Order instantiateOrder(ResultSet rs)  throws SQLException{
		
		Order order = new Order();
		order.setId(rs.getLong("order_id"));
		order.setLatitude(rs.getDouble("latitude"));
		order.setLongitude(rs.getDouble("longitude"));
		order.setMoment(rs.getTimestamp("moment").toInstant()); 
		order.setStatus(OrderStatus.values()[rs.getInt("status")]); 
		
		return order;
	}
	
	private static Product instantiateProduct(ResultSet rs)  throws SQLException{
		
		Product product = new Product();
		product.setId(rs.getLong("product_id"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getDouble("price")); 
		product.setDescription(rs.getString("description")); 
		product.setImageUri(rs.getString("image_uri"));
		
		return product;
	}
}