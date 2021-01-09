/**
 * 
 */
package entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * @author julya
 *
 */
public class Order {
	
	private Long id; 
	private Double latitude;
	private Double longitude;
	private Instant moment;
	private OrderStatus status;
	
	private List<Product> products = new ArrayList<>();
	
	
	/**
	 * 
	 */
	public Order() {
		super();
	}

	/**
	 * @param id
	 * @param latitude
	 * @param longitude
	 * @param moment
	 * @param status
	 */
	public Order(Long id, Double latitude, Double longitude, Instant moment, OrderStatus status) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the moment
	 */
	public Instant getMoment() {
		return moment;
	}

	/**
	 * @param moment the moment to set
	 */
	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	/**
	 * @return the status
	 */
	public OrderStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(OrderStatus status) {
		this.status = status;
	} 
	
	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", moment=" + moment
				+ ", status=" + status + "]";
	}
	
	
	/**
	 * transformando em String para imprimir o main
	 */
	
	
}
