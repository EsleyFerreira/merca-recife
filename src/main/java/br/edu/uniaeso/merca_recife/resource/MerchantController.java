package br.edu.uniaeso.merca_recife.resource;

import br.edu.uniaeso.merca_recife.entity.Merchant;
import br.edu.uniaeso.merca_recife.repository.MerchantRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/merchants")
public class MerchantController {

    @Autowired
    private MerchantRepositoy merchantRepositoy;

    @PostMapping
    public Merchant createMerchant(@RequestBody Merchant merchant) {
        return merchantRepositoy.save(merchant);
    }

    @GetMapping
    public List<Merchant> getAllMerchants() {
        return merchantRepositoy.findAll();
    }

    @GetMapping("/{id}")
    public Merchant getMerchant(@PathVariable Long id) {
        return merchantRepositoy.findById(id).orElse(null);
    }

    @DeleteMapping ("/{id}")
    public void deleteMerchant(@PathVariable Long id) {
        merchantRepositoy.deleteById(id);
    }

    @PatchMapping ("/{id}")
    public Merchant updateMerchant(@PathVariable Long id, @RequestBody Merchant merchant) {
        Merchant existingMerchant = merchantRepositoy.findById(id).orElse(null);

        if (existingMerchant != null) {
            existingMerchant.setName(merchant.getName());
            existingMerchant.setCpf(merchant.getCpf());
            existingMerchant.setEmail(merchant.getEmail());
            existingMerchant.setContact(merchant.getContact());
            return merchantRepositoy.save(existingMerchant);
        }
        return null;
    }
}
