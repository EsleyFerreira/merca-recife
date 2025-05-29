package br.edu.uniaeso.merca_recife.service.impl;

import br.edu.uniaeso.merca_recife.entity.Market;
import br.edu.uniaeso.merca_recife.repository.MarketRepository;
import br.edu.uniaeso.merca_recife.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MarketServiceImpl implements MarketService {

    @Autowired
    private MarketRepository marketRepository;

    @Override
    @Transactional
    public Market save(Market market) {
        return marketRepository.save(market);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Market> findAll() {
        return marketRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Market> findById(Long id) {
        return marketRepository.findById(id);
    }

    @Override
    @Transactional
    public Market update(Long id, Market marketDetails) {
        Market existingMarket = marketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Market not found with id: " + id));
        if (marketDetails.getBoxes() != null) {
            existingMarket.setBoxes(marketDetails.getBoxes());
        }
        return marketRepository.save(existingMarket);
    }
    private Long id;

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!marketRepository.existsById(id)) {
            throw new RuntimeException("Market not found with id: " + id + " for deletion.");
        }
        marketRepository.deleteById(id);
    }
}
