package com.training.pms.galaxe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.pms.galaxe.dao.ProductDAO;
import com.training.pms.galaxe.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	public ProductServiceImpl() {
		
	}

	@Autowired
	ProductDAO productDAO;
	
	@Override
	public String saveProduct(Product product) {
		if(product.getPrice() <0 | product.getQuantity() <0)
		{
			return "Product price or QOH cannot be negative. Not Saved";
		}
		else {
			productDAO.save(product);
			return "Product Saved Successfully";
		}
	}
	

	@Override
	public String updateProduct(Product product) {
		if(product.getPrice() <0 | product.getQuantity() <0)
		{
			return "Product price or QOH cannot be negative. Not Saved";
		}
		else {
			productDAO.save(product);
			return "Product Saved Successfully";
		}
	}

	
	@Override
	public String deleteProduct(int productId) {
		productDAO.deleteById(productId);
		return "Product deleted";
	}

	@Override
	public Product getProduct(int productId) {
			Optional<Product> product= productDAO.findById(productId);
			return product.get();
	}

	@Override
	public List<Product> getProduct() {
		return (List<Product>) productDAO.findAll();
	}

	@Override
	public List<Product> searchProduct(String productName) {
		return productDAO.findByProductName(productName);
	}

	@Override
	public List<Product> searchProduct(int min, int max) {
		// TODO Auto-generated method stub
		return  productDAO.findByPriceBetween(min, max);
	}

	@Override
	public List<Product> checkStockStatus(int minStock) {
		// TODO Auto-generated method stub
		return productDAO.findByQuantityGreaterThan(minStock);
	}

	@Override
	public boolean isProductExists(int productId) {
		Optional<Product> product= productDAO.findById(productId);
		return product.isPresent();
	}

}
