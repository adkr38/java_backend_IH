package com.ironhack.app.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ironhack.app.repositories.ProductRepository;
import com.ironhack.app.models.*;
import java.util.Optional;

@Service
public class ProductService{

  @Autowired
  private ProductRepository productRepository;


/**
 * Returns number of rows modified. 
 */
  public int Save(Product product){

    Optional<Product> optionalProduct = productRepository.findById(product.getId());

    if (optionalProduct.isPresent()){
      return 0;
    }

    productRepository.save(product);
    return 1;

  }

  public int UpdateProduct(int id, Product product){

    Optional<Product> optionalProduct = productRepository.findById(id);
    if (optionalProduct.isEmpty()){
      productRepository.save(product);
      return 1;
    }

    Product productFromDb =  optionalProduct.get();
    product.setId(productFromDb.getId());
    productRepository.save(product);
    return 0;
  }


}
