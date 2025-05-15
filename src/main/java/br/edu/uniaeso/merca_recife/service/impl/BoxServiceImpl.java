package br.edu.uniaeso.merca_recife.service.impl;

import br.edu.uniaeso.merca_recife.entity.Box;

import br.edu.uniaeso.merca_recife.repository.BoxRepository;
import br.edu.uniaeso.merca_recife.service.BoxService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class BoxServiceImpl implements BoxService {

    @Autowired
    private BoxRepository boxRepository;

    @Override
    @Transactional
    public Box save(Box box) {
        return boxRepository.save(box);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Box> findAll() {
        return boxRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Box> findById(Long id) {
        return boxRepository.findById(id);
    }

    @Override
    @Transactional
    public Box update(Long id, Box boxDetails) {
        Box existingBox = boxRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Box não encontrado com o id: " + id));

        if (boxDetails.getImage() != null) {
            existingBox.setImage(boxDetails.getImage());
        }
        return boxRepository.save(existingBox);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!boxRepository.existsById(id)) {
            throw new RuntimeException("Box não encontrado com o id: " + id + " para exclusão.");
        }
        boxRepository.deleteById(id);
    }
}

