package com.api.market.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.market.domain.model.Buy;
import com.api.market.domain.service.BuyService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/buys")
@RestController
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
  public ResponseEntity<List<Buy>> getAll(){
    return new ResponseEntity<>(buyService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/customer/{id}")
  public ResponseEntity<List<Buy>> getByCustomer(@PathVariable("id") String customerId) {
      return buyService.getByCustomer(customerId)
        .map(buys -> new ResponseEntity<>(buys, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/save")
  public ResponseEntity<Buy> save(@RequestBody Buy buy) {
      return new ResponseEntity<>(buyService.save(buy), HttpStatus.OK);
  }
  
}
