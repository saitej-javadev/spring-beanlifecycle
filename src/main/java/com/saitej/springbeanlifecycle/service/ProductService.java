package com.saitej.springbeanlifecycle.service;

import com.saitej.springbeanlifecycle.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {

    int saveProduct(Product product) throws SQLException, ClassNotFoundException;
    List<Product> getAllProducts() throws SQLException, ClassNotFoundException;
    Product getProduct(Integer id) throws SQLException, ClassNotFoundException;
    String deleteProduct(Integer id) throws SQLException, ClassNotFoundException;
    Integer updateProduct(String name, Integer id) throws SQLException, ClassNotFoundException;
}
