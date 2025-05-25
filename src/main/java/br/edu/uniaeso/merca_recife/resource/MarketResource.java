package br.edu.uniaeso.merca_recife.resource;

import br.edu.uniaeso.merca_recife.dto.MarketDTO;
import br.edu.uniaeso.merca_recife.entity.Market;
import br.edu.uniaeso.merca_recife.mapper.MarketMapper;
import br.edu.uniaeso.merca_recife.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/markets")
public class MarketResource {


    @Autowired
    private MarketService marketService;

    @PostMapping
    public ResponseEntity<MarketDTO> createMarket(@RequestBody MarketDTO marketDTO) {

        Market market = MarketMapper.toEntity(marketDTO);
        Market savedMarket = marketService.save(market);

        return new ResponseEntity<>(MarketMapper.toDTO(savedMarket), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MarketDTO>> getAllMarkets() {
        List<Market> markets = marketService.findAll();

        List<MarketDTO> marketDTOs = markets.stream()
                .map(MarketMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(marketDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarketDTO> getMarketById(@PathVariable Long id) {
        return marketService.findById(id)
                .map(MarketMapper::toDTO) // Converte Entidade para DTO
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarketDTO> updateMarket(@PathVariable Long id, @RequestBody MarketDTO marketDTO) {
        try {
            Market marketDetails = MarketMapper.toEntity(marketDTO);
            Market updatedMarket = marketService.update(id, marketDetails);

            return ResponseEntity.ok(MarketMapper.toDTO(updatedMarket));
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
