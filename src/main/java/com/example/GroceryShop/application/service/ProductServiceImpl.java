package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.Product;
import com.example.GroceryShop.infrastructure.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;

  @Autowired
  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product addProduct(
      String productName, String productDescription, float basePrice, float percentOfTaxe) {
    // Create new product
    Product product = new Product(productName, productDescription, basePrice, percentOfTaxe);
    // Save to dataBase
    return productRepository.save(product);
  }

  @Override
  public Product getProductById(Long id) {
    // Find product by id from repository
    return productRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteProduct(Long id) {
    // Delete product by id from repository
    productRepository.deleteById(id);
  }

  @Override
  public List<Product> listProducts() {
    return productRepository.findAll();
  }

  public void changeProductPrice(Long id, float newBasePrice) {
    Product product = productRepository.findById(id).orElse(null);
//    product.setBasePrice(
//        newBasePrice); //  ??? jak uzyc automatycznego gettera, który jest tagowany?
//    productRepository.save(product);
    // productRepository.findProductByProductName("S");
  }

  //    public void changeProductTax(Long id, float newTax){
  //        Product product = productRepository.findById(id).orElse(null);
  //        product.setBasePrice(newBasePrice) ;//  ??? jak uzyc automatycznego gettera, który jest
  // tagowany?
  //        productRepository.save(product);
  //      }
  //    public void changeProductDescription(Long id, String newProductDescription){
  //        Product product = productRepository.findById(id).orElse(null);
  //        product.setBasePrice(newBasePrice) ;//  ??? jak uzyc automatycznego gettera, który jest
  // tagowany?
  //        productRepository.save(product);
  //    }

}
