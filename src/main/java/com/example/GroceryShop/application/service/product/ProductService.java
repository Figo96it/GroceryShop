package com.example.GroceryShop.application.service.product;

import com.example.GroceryShop.domain.model.Price;
import com.example.GroceryShop.domain.model.Product;
import com.example.GroceryShop.domain.model.ProductCategory;
import com.example.GroceryShop.domain.model.ProductGroup;
import java.util.List;

public interface ProductService {

  Product getProductById(Long id);

  Product addProduct(
      String productName,
      String productDescription,
      List<Price> prices,
      float percentOfTaxe,
      ProductCategory productCategory,
      ProductGroup productGroup);

  void deleteProduct(Long id);

  List<Product> listProducts();

  Product editProduct(
      Long id,
      String productName,
      String productDescription,
      List<Price> prices,
      float percentOfTaxe,
      ProductCategory productCategory,
      ProductGroup productGroup);
}
