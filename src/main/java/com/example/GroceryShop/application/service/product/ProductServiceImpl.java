package com.example.GroceryShop.application.service.product;

import com.example.GroceryShop.domain.model.Price;
import com.example.GroceryShop.domain.model.Product;
import com.example.GroceryShop.domain.model.ProductCategory;
import com.example.GroceryShop.domain.model.ProductGroup;
import com.example.GroceryShop.infrastructure.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product getProductById(Long id) {
    return productRepository.findById(id).orElse(null);
  }

  @Override
  public Product addProduct(
      String productName,
      String productDescription,
      List<Price> prices,
      float percentOfTaxe,
      ProductCategory productCategory,
      ProductGroup productGroup) {
    Product product =
        new Product(
            productName, productDescription, prices, percentOfTaxe, productCategory, productGroup);
    return productRepository.save(product);
  }

  @Override
  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }

  @Override
  public List<Product> listProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product editProduct(
      Long id,
      String productName,
      String productDescription,
      List<Price> prices,
      float percentOfTaxe,
      ProductCategory productCategory,
      ProductGroup productGroup) {
    Optional<Product> optionalProduct = productRepository.findById(id);
    if (optionalProduct.isPresent()) {
      Product product = optionalProduct.get();
      product.setProductName(productName);
      product.setProductDescription(productDescription);
      product.setPrices(prices);
      product.setPercentOfTax(percentOfTaxe);
      product.setProductCategory(productCategory);
      product.setProductGroup(productGroup);
      return productRepository.save(product);
    } else {
      throw new IllegalArgumentException("Product with id " + id + " not found.");
    }
  }
}
