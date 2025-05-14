package br.edu.uniaeso.merca_recife.repository;

import br.edu.uniaeso.merca_recife.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
}
