package br.edu.uniaeso.merca_recife.resource;

import br.edu.uniaeso.merca_recife.dto.MerchantDTO;
import br.edu.uniaeso.merca_recife.entity.Merchant;
import br.edu.uniaeso.merca_recife.mapper.MerchantMapper;
import br.edu.uniaeso.merca_recife.service.MerchantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/merchants")
public class MerchantResource {

    @Autowired
    private MerchantService merchantService;

    @PostMapping
    public ResponseEntity<MerchantDTO> createMerchant(@Valid @RequestBody MerchantDTO merchantDTO) {

        Merchant merchant = MerchantMapper.toEntity(merchantDTO);
        Merchant savedMerchant = merchantService.save(merchant);

        return new ResponseEntity<>(MerchantMapper.toDTO(savedMerchant), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MerchantDTO>> getAllMerchants() {
        List<Merchant> merchants = merchantService.findAll();
        List<MerchantDTO> merchantDTOs = merchants.stream()
                .map(MerchantMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(merchantDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MerchantDTO> getMerchantById(@PathVariable Long id) {
        return merchantService.findById(id)
                .map(MerchantMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MerchantDTO> updateMerchant(@PathVariable Long id, @RequestBody MerchantDTO merchantDTO) {
        try {
            Merchant merchantDetails = MerchantMapper.toEntity(merchantDTO);
            Merchant updatedMerchant = merchantService.update(id, merchantDetails);

            return ResponseEntity.ok(MerchantMapper.toDTO(updatedMerchant));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMerchant(@PathVariable Long id) {
        try {
            merchantService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
