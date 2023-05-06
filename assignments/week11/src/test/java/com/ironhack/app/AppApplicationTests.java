package com.ironhack.app;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.app.enums.Category;
import com.ironhack.app.enums.Department;
import com.ironhack.app.models.Product;
import com.ironhack.app.repositories.*;
import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;

@SpringBootTest
class AppApplicationTests {

  @Autowired
  private WebApplicationContext webApplicationContext; 

  private MockMvc mockMvc;

  @Autowired
  private ProductRepository productRepository;

  private final ObjectMapper objectMapper = new ObjectMapper();

  private Product product1;
  private Product product2;

  @BeforeEach
  void setUp(){
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    product1 = new Product("oreo-black-10-pack", new BigDecimal("2.15"),Category.COOKIE , Department.SNACKS);
    product2 = new Product("chicken-breast-1kg", new BigDecimal("7.55"),Category.MEAT, Department.FOOD);
    productRepository.saveAll(List.of(product1,product2));
  }

  @AfterEach
  void tearDown(){
    productRepository.delete(product1);
    productRepository.delete(product2);

  }

  @Test
  void testStoreNewProductOnPostRequest() throws Exception{
    Product product3 = new Product("oreo-white-10-pack", new BigDecimal("2.22"), Category.COOKIE, Department.SNACKS);
    String body = objectMapper.writeValueAsString(product3);
    MvcResult result = mockMvc.perform(post("/products/")
    .content(body)
    .contentType(MediaType.APPLICATION_JSON))
    .andExpect(status().isCreated())
    .andReturn();

    assertTrue(result.getResponse().getContentAsString().contains("oreo-white-10-pack"));
  }

  @Test
  void testPostAlreadyExistingProductReturnsConflict() throws Exception{

    Product repeatedProduct = new Product("chicken-breast-1kg", new BigDecimal("7.55"),Category.MEAT, Department.FOOD);
    repeatedProduct.setId(product2.getId());

    String body = objectMapper.writeValueAsString(repeatedProduct);

    mockMvc.perform(post("/products/")
    .content(body)
    .contentType(MediaType.APPLICATION_JSON))
    .andExpect(status().isConflict())
    .andReturn();

  }

  @Test
  void testPutNonExistingProductCreatesNewProduct() throws Exception{

    Product product3 = new Product("oreo-white-10-pack", new BigDecimal("2.22"), Category.COOKIE, Department.SNACKS);
    String body = objectMapper.writeValueAsString(product3);
    MvcResult result = mockMvc.perform(put(String.format("/products/%d",product3.getId()))
    .content(body)
    .contentType(MediaType.APPLICATION_JSON))
    .andExpect(status().isCreated())
    .andReturn();

    assertTrue(result.getResponse().getContentAsString().contains("oreo-white-10-pack"));
  }

  @Test
  void testPutExistingProductUpdatesAttrs() throws Exception{

    Product product3 = new Product("oreo-white-10-pack", new BigDecimal("2.22"), Category.COOKIE, Department.SNACKS);
    product3.setId(product2.getId());
    String body = objectMapper.writeValueAsString(product3);
    MvcResult result = mockMvc.perform(put(String.format("/products/%d",product3.getId()))
    .content(body)
    .contentType(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk())
    .andReturn();

    assertTrue(result.getResponse().getContentAsString().contains("oreo-white-10-pack"));
  }


}
