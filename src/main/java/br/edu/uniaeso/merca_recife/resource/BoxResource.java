package br.edu.uniaeso.merca_recife.resource;

import br.edu.uniaeso.merca_recife.dto.BoxDTO;
import br.edu.uniaeso.merca_recife.entity.Box;
import br.edu.uniaeso.merca_recife.entity.Market;
import br.edu.uniaeso.merca_recife.mapper.BoxMapper;
import br.edu.uniaeso.merca_recife.service.BoxService;
import br.edu.uniaeso.merca_recife.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/boxes")
public class BoxResource {

    @Autowired
    private BoxService boxService;

    @Autowired
    private MarketService marketService;

    @PostMapping
    public ResponseEntity<BoxDTO> createBox(@RequestBody BoxDTO boxDTO) {
        if (boxDTO.getMarketId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "marketId não pode ser nulo");
        }

        Market market = marketService.findById(boxDTO.getMarketId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Market não encontrado com id: " + boxDTO.getMarketId()));

        Box box = BoxMapper.toEntity(boxDTO);
        box.setMarket(market);

        Box savedBox = boxService.save(box);
        return new ResponseEntity<>(BoxMapper.toDTO(savedBox), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BoxDTO>> getAllBoxes() {
        List<Box> boxes = boxService.findAll();
        List<BoxDTO> boxDTOs = boxes.stream()
                .map(BoxMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(boxDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoxDTO> getBoxById(@PathVariable Long id) {
        return boxService.findById(id)
                .map(BoxMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoxDTO> updateBox(@PathVariable Long id, @RequestBody BoxDTO boxDTO) {

        Box boxDetails = BoxMapper.toEntity(boxDTO);

        try {
            Box updatedBox = boxService.update(id, boxDetails);
            return ResponseEntity.ok(BoxMapper.toDTO(updatedBox));
        } catch (RuntimeException e) {

            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBox(@PathVariable Long id) {
        try {
            boxService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
