package br.edu.uniaeso.merca_recife.service.impl;

import br.edu.uniaeso.merca_recife.entity.Merchant;
import br.edu.uniaeso.merca_recife.repository.MerchantRepository;
import br.edu.uniaeso.merca_recife.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    @Override
    @Transactional
    public Merchant save(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Merchant> findAll() {
        return merchantRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Merchant> findById(Long id) {
        return merchantRepository.findById(id);
    }

    @Override
    @Transactional
    public Merchant update(Long id, Merchant merchantDetails) {
        Merchant existingMerchant = merchantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Merchant not found with id: " + id));

        if (merchantDetails.getName() != null) {
            existingMerchant.setName(merchantDetails.getName());
        }
        if (merchantDetails.getCpf() != null) {
            existingMerchant.setCpf(merchantDetails.getCpf());
        }
        if (merchantDetails.getEmail() != null) {
            existingMerchant.setEmail(merchantDetails.getEmail());
        }
        if (merchantDetails.getContact() != null) {
            existingMerchant.setContact(merchantDetails.getContact());
        }
        if (merchantDetails.getProductsSold() != null) {
            existingMerchant.setProductsSold(merchantDetails.getProductsSold());
        }
        existingMerchant.setApproved(merchantDetails.isApproved());

        if (merchantDetails.getOwnedBoxes() != null) {
            existingMerchant.setOwnedBoxes(merchantDetails.getOwnedBoxes());
        }

        return merchantRepository.save(existingMerchant);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!merchantRepository.existsById(id)) {
            throw new RuntimeException("Merchant not found with id: " + id + " for deletion.");
        }
        merchantRepository.deleteById(id);
    }
}
