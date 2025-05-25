package br.edu.uniaeso.merca_recife.mapper;

import br.edu.uniaeso.merca_recife.dto.BoxDTO;
import br.edu.uniaeso.merca_recife.entity.Box;
import br.edu.uniaeso.merca_recife.entity.Market;

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
        return dto;
    }

    public static Box toEntity(BoxDTO dto) {
        if (dto == null) {
            return null;
        }
        Box box = new Box();
        box.setId(dto.getId());
        if (dto.getMarketId() != null) {
            Market market = new Market();
            market.setId(dto.getMarketId());
            box.setMarket(market);
        }
        box.setImage(dto.getImage());
        return box;
    }
}
