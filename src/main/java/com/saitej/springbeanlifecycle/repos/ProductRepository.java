package com.saitej.springbeanlifecycle.repos;


import com.saitej.springbeanlifecycle.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {


    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    public static final String INSERT = "INSERT INTO PRODUCTS (ID,NAME,DESCRIPTION,PRICE)VALUES(?,?,?,?)";
    public static final String SELECT = "SELECT * FROM PRODUCTS";
    public static final String GET_SINGLE_PRODUCT = "SELECT ID,NAME,DESCRIPTION,PRICE FROM PRODUCTS WHERE ID = ?";
    public static final String UPDATE = "UPDATE PRODUCTS SET NAME=? where id=?";
    Connection con = null;


    @PostConstruct
    public void init() throws SQLException, ClassNotFoundException {
        System.out.println("ProductRepository.init");
        getDBConnection();
    }


   public void  getDBConnection() throws ClassNotFoundException, SQLException {

       //Load the Driver Class
       Class.forName("com.mysql.cj.jdbc.Driver");

       //Create Connection
        con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public int saveProduct(Product product) throws ClassNotFoundException, SQLException {


        // Create Statement object
        PreparedStatement ps = con.prepareStatement(INSERT);
        ps.setInt(1, product.getId());
        ps.setString(2, product.getName());
        ps.setString(3, product.getDescription());
        ps.setDouble(4, product.getPrice());

        // execute Query an collect results
        int count = ps.executeUpdate();
        System.out.println("inserted successfully...with count " + count);

        ps.close();


        return count;

    }

    public List<Product> getAllProducts() throws ClassNotFoundException, SQLException {


        // Create Statement object
        PreparedStatement ps = con.prepareStatement(SELECT);

        // execute query and collect results
        ResultSet rs = ps.executeQuery();
        List<Product> products = new ArrayList<Product>();
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getDouble(4));
            Product product = new Product();
            product.setId(rs.getInt(1));
            product.setName(rs.getString(2));
            product.setDescription(rs.getString(3));
            product.setPrice(rs.getDouble(4));
            products.add(product);
        }


        ps.close();
        rs.close();
        return products;

    }

    public Product getProduct(Integer id) throws ClassNotFoundException, SQLException {

        System.out.println("ProductRepository.getProduct");

        // Create Statement object
        PreparedStatement ps = con.prepareStatement(GET_SINGLE_PRODUCT);
        ps.setInt(1, id);

        // execute query and collect results
        ResultSet rs = ps.executeQuery();
        Product product = new Product();
        while (rs.next()) {
          //  System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getDouble(4));


            product.setId(rs.getInt(1));
            product.setName(rs.getString(2));
            product.setDescription(rs.getString(3));
            product.setPrice(rs.getDouble(4));
        }

        ps.close();
        rs.close();
        return product;
    }


    public Integer updateProduct(String name,Integer id) throws ClassNotFoundException, SQLException {


        // Create Statement object
        PreparedStatement ps = con.prepareStatement(UPDATE);
        ps.setString(1,name);
        ps.setInt(2,id);

        // execute Query an collect results
        int count = ps.executeUpdate();
        System.out.println("updated successfully...with count " + count);

        ps.close();


        return count;
    }

    public String deleteProduct(Integer id) throws ClassNotFoundException, SQLException {

        // Create Statement object
        PreparedStatement ps = con.prepareStatement("DELETE FROM PRODUCTS WHERE ID =?");
        ps.setInt(1,id);

        // execute Query an collect results
        int count = ps.executeUpdate();
        System.out.println("Deleted successfully...with count " + count);

        ps.close();


        return "Deleted successfully...with count " + count;


    }


    public void closeConnection(){
        System.out.println("ProductRepository.closeConnection");
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void destroy(){
        closeConnection();
    }
}
