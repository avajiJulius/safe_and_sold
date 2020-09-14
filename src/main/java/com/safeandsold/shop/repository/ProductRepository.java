package com.safeandsold.shop.repository;

import com.safeandsold.shop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(name = "Product.findById",
    value = "select p from Product p where p.productId = :productId")
    Optional<Product> findById(@Param("productId") Long productId);
    @Query(name = "Product.findByProductName",
    value = "select p from Product p where upper(p.productName) = upper(:productName)")
    List<Product> findByProductName(@Param("productName") String productName);
    @Query(name = "Product.findByPrice",
    value = "select p from Product p where p.price between :minPrice and :maxPrice")
    List<Product> findByPrice(@Param("minPrice") Integer minPrice,
                              @Param("maxPrice") Integer maxPrice);

}
