package com.saitej.springbeanlifecycle.service;

import com.saitej.springbeanlifecycle.model.Product;
import com.saitej.springbeanlifecycle.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public int saveProduct(Product product) throws SQLException, ClassNotFoundException {
        return productRepository.saveProduct(product);
    }

    @Override
    public List<Product> getAllProducts() throws SQLException, ClassNotFoundException {
        return productRepository.getAllProducts();
    }

    @Override
    public Product getProduct(Integer id) throws SQLException, ClassNotFoundException {
        return productRepository.getProduct(id);
    }

    @Override
    public String deleteProduct(Integer id) throws SQLException, ClassNotFoundException {
        return productRepository.deleteProduct(id);
    }

    @Override
    public Integer updateProduct(String name,Integer id) throws SQLException, ClassNotFoundException {
        return productRepository.updateProduct(name,id);
    }
}
