package com.coding.jpaPractice.jpaPractice;

import com.coding.jpaPractice.jpaPractice.entities.ProductEntity;
import com.coding.jpaPractice.jpaPractice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class JpaPracticeApplicationTests {

    @Autowired
    ProductRepository productRepository;
	@Test
	void contextLoads() {
	}

    @Test
    void testProductRepository() {

        ProductEntity productEntity = ProductEntity.builder()
                .sku("SKU123")
                .title("Sample Product")
                .price(BigDecimal.valueOf(19.99))
                .quantity(100)
                .build();

        ProductEntity savedProduct = productRepository.save(productEntity);
        System.out.println("Saved Product: " + savedProduct);
    }

    @Test
    void testFindAllProducts() {
        System.out.println("All Products: " + productRepository.findAll());
    }

    @Test
    void testFindProductByTitle(){
       ProductEntity product = productRepository.findByTitle("Pepsi");
        System.out.println("Found Product by Title: " + product);
    }

    @Test
    void testFindByCreatedAtAfter(){
        List<ProductEntity> products = productRepository.findByCreatedAtAfter(
                LocalDateTime.of(2027, 1, 1, 0, 0, 0));
            System.out.println("Found Products by Created At After: " + products);

    }

    @Test
    void testFindByQuantityAndPrice(){
        List<ProductEntity> products = productRepository.findByQuantityAndPrice(10, BigDecimal.valueOf(15.6));
        System.out.println("Found Products by Quantity and Price: " + products);
    }

    @Test
    void testTitleContaining(){
        //List<ProductEntity> products = productRepository.findByTitleContaining("psi");
        List<ProductEntity> products = productRepository.findByTitleContainingIgnoreCase("psi");

        System.out.println("Found Products by Title Containing: " + products);
    }
}
