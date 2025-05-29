package br.edu.uniaeso.merca_recife.mapper;

import br.edu.uniaeso.merca_recife.dto.BoxDTO;
import br.edu.uniaeso.merca_recife.entity.Box;
import java.util.ArrayList;
import java.util.Collections;

public class BoxMapper {

    public static BoxDTO toDTO(Box box) {
        if (box == null) {
            return null;
        }
        BoxDTO dto = new BoxDTO();
        dto.setId(box.getId());
        if (box.getMarket() != null) {
            dto.setMarketId(box.getMarket().getId());
        }
        dto.setImage(box.getImage());
        dto.setProducts(box.getProducts() != null ? new ArrayList<>(box.getProducts()) : Collections.emptyList());
        return dto;
    }

    public static Box toEntity(BoxDTO dto) {
        if (dto == null) {
            return null;
        }
        Box box = new Box();
        box.setId(dto.getId());
        box.setImage(dto.getImage());
        box.setProducts(dto.getProducts() != null ? new ArrayList<>(dto.getProducts()) : Collections.emptyList());
        return box;
    }
}
