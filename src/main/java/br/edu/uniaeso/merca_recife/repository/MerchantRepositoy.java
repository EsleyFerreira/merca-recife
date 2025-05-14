package br.edu.uniaeso.merca_recife.repository;

import br.edu.uniaeso.merca_recife.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepositoy extends JpaRepository<Merchant, Long> {
}
