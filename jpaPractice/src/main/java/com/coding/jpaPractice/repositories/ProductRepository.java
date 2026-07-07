package com.coding.jpaPractice.repositories;

import com.coding.jpaPractice.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    ProductEntity findByTitle(String title);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime createdAt);


    //List<ProductEntity> findByQuantityAndPrice(int quantity, BigDecimal price);

    @Query("SELECT p FROM ProductEntity p WHERE p.quantity = ?1 AND p.price = ?2")
    List<ProductEntity> findByQuantityAndPrice(int quantity, BigDecimal price);

    List<ProductEntity> findByTitleContaining(String title);

    List<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    List<ProductEntity> findByOrderByPrice();

    List<ProductEntity> findBy(Sort sort);
}