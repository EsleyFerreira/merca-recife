package br.edu.uniaeso.merca_recife.resource;


import br.edu.uniaeso.merca_recife.entity.Market;
import br.edu.uniaeso.merca_recife.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/markets")
public class MarketResource {

    @Autowired
    private MarketService marketService;

    @PostMapping
    public ResponseEntity<Market> createMarket(@RequestBody Market market) {
        Market savedMarket = marketService.save(market);
        return new ResponseEntity<>(savedMarket, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Market>> getAllMarkets() {
        List<Market> markets = marketService.findAll();
        return ResponseEntity.ok(markets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Market> getMarketById(@PathVariable Long id) {
        return marketService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Market> updateMarket(@PathVariable Long id, @RequestBody Market marketDetails) {
        try {
            Market updatedMarket = marketService.update(id, marketDetails);
            return ResponseEntity.ok(updatedMarket);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarket(@PathVariable Long id) {
        try {
            marketService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
