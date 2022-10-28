package com.training.pms.galaxe.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="freshProducts")

@Data
@AllArgsConstructor
@Component
public class Product {
	
	@Id
	private int productId;
	private String productName;
	private int quantity;
	private int price;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}


	
}
