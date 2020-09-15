package com.safeandsold.shop.service;

import com.safeandsold.shop.domain.Product;
import com.safeandsold.shop.exception.ProductNotFoundException;
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
    public Product findById(Long productId) throws ProductNotFoundException {
        Optional<Product> byId = productRepository.findById(productId);
        if(!byId.isEmpty() && byId!=null) {
            return byId.get();
        }
        throw new ProductNotFoundException("Product whit this ID is Not Found");
    }

    @Override
    public List<Product> findByPrice(Integer minPrice, Integer maxPrice) throws ProductNotFoundException {
        List<Product> productList = productRepository.findByPrice(minPrice, maxPrice);
        if(!productList.isEmpty() && productList != null) {
            return productList;
        }
        throw new ProductNotFoundException("Product whit this price is Not Found");
    }

    @Override
    public List<Product> findByProductName(String productName) throws ProductNotFoundException {
        List<Product> productList = productRepository.findByProductName(productName);
        if(!productList.isEmpty() && productList != null) {
            return productList;
        }
        throw new ProductNotFoundException("Product whit this product name is Not Found");
    }

    @Override
    public void editCheckStatus(Long productId) {
        Optional<Product> optional = productRepository.findById(productId);
        if(!optional.isEmpty() && optional != null) {
            boolean status = optional.get().isChecked();
            if(status == false) {
                status = true;
            } else {
                status = false;
            }
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
