package app;

import java.sql.SQLException;
import entities.Product;

public class Program {

	public static void main(String[] args) throws SQLException {
		
		Product product = new Product();
		
		product.setId(1L);
		
		product.setName("Pizza");
		
		product.setPrice(35.60); 
		
		product.setDescription("pIZZA COM  MUITO QUEIJO E MASSA CROCANTE"); 
		
		product.setImageUri("https://github.com/devsuperior/1.png");
		
		System.out.println("Id: " + product.getId()  + "\r\n" + "Nome do produto: " + product.getName() + "\r\n" +
				"Price: " + product.getPrice() + "\r\n" + "Description: " + product.getDescription() + "\r\n" +
				"Image: " + product.getImageUri());
		
		
		/**
		Connection conn = DB.getConnection();
	
		Statement st = conn.createStatement();
			
		ResultSet rs = st.executeQuery("select * from tb_product");
			
		while (rs.next()) {
			System.out.println(rs.getLong("Id") + ", " + rs.getString("Name"));
		}*/
	}
}
