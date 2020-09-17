package com.safeandsold.shop.service;

import com.safeandsold.shop.domain.Product;
import com.safeandsold.shop.repository.ProductRepository;
import com.safeandsold.shop.service.manager.ManagerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService, ManagerProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long productId) {
        Optional<Product> byId = productRepository.findById(productId);
        return byId.get();
    }

    @Override
    public List<Product> findByPrice(Integer minPrice, Integer maxPrice) {
        List<Product> productList = productRepository.findByPrice(minPrice, maxPrice);
        return productList;
    }

    @Override
    public List<Product> findByProductName(String productName)  {
        List<Product> productList = productRepository.findByProductName(productName);
        return productList;
    }

    @Override
    public void editCheckStatus(Long productId) {
        Optional<Product> optional = productRepository.findById(productId);
        boolean status = optional.get().isChecked();
        if(status == false) {
            status = true;
        } else {
            status = false;
        }
    }

    @Override
    public void deleteById(Long productId) {
        this.productRepository.deleteById(productId);
    }

    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }
}
