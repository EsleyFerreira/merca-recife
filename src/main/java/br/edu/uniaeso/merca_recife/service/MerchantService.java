package br.edu.uniaeso.merca_recife.service;

import br.edu.uniaeso.merca_recife.entity.Merchant;

import java.util.List;
import java.util.Optional;

public interface MerchantService {
    Merchant save(Merchant merchant);
    List<Merchant> findAll();
    Optional<Merchant> findById(Long id);
    Merchant update(Long id, Merchant merchantDetails);
    void deleteById(Long id);
}
