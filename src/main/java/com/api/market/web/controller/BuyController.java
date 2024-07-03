package com.api.market.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.market.domain.model.Buy;
import com.api.market.domain.service.BuyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/buys")
@RestController
@Tag(name = "Buy")
public class BuyController {
  private BuyService buyService;

  /**
   * Constructor-based injection 
   * No necessary @Autowired annotation because of the single constructor
   * @param productService service
   */
  BuyController(BuyService buyService){
    this.buyService = buyService;
  }

  @GetMapping("")
  @Operation(description = "Search all buys")
  @ApiResponse(responseCode = "200" , description = "OK")
  public ResponseEntity<List<Buy>> getAll(){
    return new ResponseEntity<>(buyService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/customer/{id}")
  @Operation(description = "Search a buy by customer")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "OK"),
    @ApiResponse(responseCode = "404", description = "NOT_FOUND")
  })
  public ResponseEntity<List<Buy>> getByCustomer(@PathVariable("id") String customerId) {
      return buyService.getByCustomer(customerId)
        .map(buys -> new ResponseEntity<>(buys, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/save")
  @Operation(description = "Create a buy")
  public ResponseEntity<Buy> save(@RequestBody Buy buy) {
      return new ResponseEntity<>(buyService.save(buy), HttpStatus.OK);
  }
  
}
