package br.edu.uniaeso.merca_recife.service;

import br.edu.uniaeso.merca_recife.entity.Box;

import java.util.List;
import java.util.Optional;

public interface BoxService {
    Box save(Box box);
    List<Box> findAll();
    Optional<Box> findById(Long id);
    Box update(Long id, Box boxDetails);
    void deleteById(Long id);
}
