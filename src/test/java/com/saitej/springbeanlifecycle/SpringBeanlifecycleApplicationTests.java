package com.saitej.springbeanlifecycle;

import com.saitej.springbeanlifecycle.model.Product;
import com.saitej.springbeanlifecycle.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class SpringBeanlifecycleApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    void testCreateProduct() throws SQLException, ClassNotFoundException {

        Product product = new Product();
        product.setId(9);
        product.setName("MI");
        product.setDescription("From xaomi");
        product.setPrice(10000.0);

        int i = productService.saveProduct(product);
        System.out.println(i);
        assertNotNull(i);

    }

    @Test
    void testGetAllProducts() throws SQLException, ClassNotFoundException {
        List<Product> products = productService.getAllProducts();
        System.out.println(products);
        assertEquals(7,products.size());
    }

    @Test
    void testGetProduct() throws SQLException, ClassNotFoundException {
        Product product = productService.getProduct(7);
        System.out.println(product);
        assertNotNull(product);
    }


    @Test
    void testUpdateProduct() throws SQLException, ClassNotFoundException {
        Integer count = productService.updateProduct("OnePlus Nord", 3);
        System.out.println(count);
        assertNotNull(count);
    }


    @Test
    void testDeleteProduct() throws SQLException, ClassNotFoundException {
        String s = productService.deleteProduct(4);
        System.out.println(s);
        assertEquals(1,1);

    }
}
