package br.edu.uniaeso.merca_recife.resource;


import br.edu.uniaeso.merca_recife.entity.Box;
import br.edu.uniaeso.merca_recife.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boxes")
public class BoxResource {

    @Autowired
    private BoxService boxService;

    @PostMapping
    public ResponseEntity<Box> createBox(@RequestBody Box box) {
        Box savedBox = boxService.save(box);
        return new ResponseEntity<>(savedBox, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Box>> getAllBoxes() {
        List<Box> boxes = boxService.findAll();
        return ResponseEntity.ok(boxes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Box> getBoxById(@PathVariable Long id) {
        return boxService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Box> updateBox(@PathVariable Long id, @RequestBody Box boxDetails) {
        try {
            Box updatedBox = boxService.update(id, boxDetails);
            return ResponseEntity.ok(updatedBox);
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