package br.edu.uniaeso.merca_recife.repository;

import br.edu.uniaeso.merca_recife.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepositoy extends JpaRepository<Merchant, Long> {
}
