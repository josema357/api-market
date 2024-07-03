package com.api.market.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.market.domain.model.Product;
import com.api.market.domain.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RequestMapping("/products")
@RestController
@Tag(name = "Product")
public class ProductController {
  private ProductService productService;

  /**
   * Constructor-based injection 
   * No necessary @Autowired annotation because of the single constructor
   * @param productService service
   */
  ProductController(ProductService productService){
    this.productService = productService;
  }
  
  @GetMapping("")
  @Operation(description = "Search all products")
  @ApiResponse(responseCode = "200" , description = "OK")
  public ResponseEntity<List<Product>> getAll(){
    return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  @Operation(description = "Search a product with an ID")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "OK"),
    @ApiResponse(responseCode = "404", description = "NOT_FOUND")
  })
  public ResponseEntity<Product> getProduct(@Parameter(description = "The ID of the product", required = true) @PathVariable("id") int productId){
    return productService.getProduct(productId)
      .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/category/{categoryId}")
  @Operation(description = "Search a product by caterogy")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "OK"),
    @ApiResponse(responseCode = "404", description = "NOT_FOUND")
  })
  public ResponseEntity<List<Product>> getByCategory(@Parameter(description = "The ID of the category", required = true) @PathVariable("categoryId") int categoryId){
    return productService.getByCategory(categoryId)
      .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/save")
  @Operation(description = "Create a product")
  public ResponseEntity<Product> save(@RequestBody Product product){
    return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> delete(@Parameter(description = "The ID of the product", required = true) @PathVariable("id") int productId){
    if(productService.delete(productId)){
      return new ResponseEntity<>(HttpStatus.OK);
    }else{
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
