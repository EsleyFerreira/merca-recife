package br.edu.uniaeso.merca_recife.service;

import br.edu.uniaeso.merca_recife.entity.Market;

import java.util.List;
import java.util.Optional;

public interface MarketService {
    Market save(Market market);
    List<Market> findAll();
    Optional<Market> findById(Long id);
    Market update(Long id, Market marketDetails);
    void deleteById(Long id);
}
