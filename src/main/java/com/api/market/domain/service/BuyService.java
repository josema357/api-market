package com.api.market.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.market.domain.model.Buy;
import com.api.market.domain.repository.BuyRepository;

@Service
public class BuyService {
  private BuyRepository buyRepository;

  /**
   * Constructor-based injection 
   * No necessary @Autowired annotation because of the single constructor
   * @param productRepository repository
   */
  BuyService(BuyRepository buyRepository){
    this.buyRepository = buyRepository;
  }

  public List<Buy> getAll(){
    return buyRepository.getAll();
  }

  public Optional<List<Buy>> getByCustomer(String customerId){
    return buyRepository.getByCustomer(customerId);
  }

  public Buy save(Buy buy){
    return buyRepository.save(buy);
  }
}
