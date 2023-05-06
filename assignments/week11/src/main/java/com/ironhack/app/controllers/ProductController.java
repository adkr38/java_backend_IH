package com.ironhack.app.controllers;
import com.ironhack.app.services.*;

import jakarta.validation.Valid;

import com.ironhack.app.dtos.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ironhack.app.models.*;
import com.ironhack.app.repositories.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("products/")
class ProductController{

  @Autowired
  private ProductRepository productRepository; 

  @Autowired
  private ProductService productService;

  @GetMapping("/")
  public ResponseEntity<ResponseDTO> findAll(){
    return ResponseEntity.status(200).body(new SuccessDTO<>(200, "success", productRepository.findAll()));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseDTO> findById(@PathVariable int id){
    Optional<Product> optionalProduct = productRepository.findById(id);
    if (optionalProduct.isEmpty()){
      return ResponseEntity.status(404).body(new ErrorDTO<>(404, "not found"));
    }
    return ResponseEntity.status(200).body(new SuccessDTO<>(200, "success", List.of(optionalProduct.get())));
  }

  @PostMapping("/")
  public ResponseEntity<ResponseDTO> save(@RequestBody @Valid Product product){
    int result = productService.Save(product);
    if (result == 0){
      return ResponseEntity.status(409).body(new ErrorDTO<>(409, "Conflict - Resource already exists"));
    }
    return ResponseEntity.status(201).body(new SuccessDTO<>(201, "Resource created", List.of(product)));

  }

  @PutMapping("/{id}")
  public ResponseEntity<ResponseDTO> update(@PathVariable int id, @RequestBody @Valid Product product){
    int result = productService.UpdateProduct(id, product);

    if (result == 0){
      return ResponseEntity.status(200).body(new SuccessDTO<>(200 , "Resource updated", List.of(product)));
    }

      return ResponseEntity.status(201).body(new SuccessDTO<>(201 , "Resource created", List.of(product)));

  }



}
