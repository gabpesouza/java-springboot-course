package com.udemy.coursespringboot.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.udemy.coursespringboot.entities.pk.OrderItemPK;
@Entity(name = "tb_order_item")
public class OrderItem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	private Integer quantity;
	private Double price;
	
	
	public OrderItem() {
		
	}

	public OrderItem(Order order,Product product,Integer quantity, Double price) {
		this.quantity = quantity;
		this.price = price;
		id.setOrder(order);
		id.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
	
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	public void setProduct(Product product) {
		id.setProduct(product);
	}
	
	
	
}
