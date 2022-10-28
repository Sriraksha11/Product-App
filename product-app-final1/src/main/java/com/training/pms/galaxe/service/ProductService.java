package com.training.pms.galaxe.service;

import java.util.List;

import com.training.pms.galaxe.model.Product;



public interface ProductService {
	
	//CRUD Methods
		public String saveProduct(Product product);
		
		public String updateProduct(Product product);
		
		public String deleteProduct(int productId);
		
		public Product getProduct(int productId);
		
		public List<Product> getProduct();
		
		//Other methods
		public List<Product> searchProduct(String productName);
		
		//To search the products in certain range of price
		public List<Product> searchProduct(int min, int max);
		
		public List<Product> checkStockStatus(int minStock);
		
		public boolean isProductExists(int productId);

}
