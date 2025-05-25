package br.edu.uniaeso.merca_recife.mapper;

import br.edu.uniaeso.merca_recife.dto.MarketDTO;
import br.edu.uniaeso.merca_recife.entity.Box;
import br.edu.uniaeso.merca_recife.entity.Market;
import java.util.stream.Collectors;

public class MarketMapper {

    public static MarketDTO toDTO(Market market) {
        if (market == null) {
            return null;
        }
        MarketDTO dto = new MarketDTO();
        dto.setId(market.getId());
        if (market.getBoxes() != null) {
            dto.setBoxIds(market.getBoxes().stream().map(Box::getId).collect(Collectors.toList()));
        }
        return dto;
    }

    public static Market toEntity(MarketDTO dto) {
        if (dto == null) {
            return null;
        }

        Market market = new Market();
        market.setId(dto.getId());
        if (dto.getBoxIds() != null) {
            market.setBoxes(dto.getBoxIds().stream().map(boxId -> {
                Box box = new Box();
                box.setId(boxId);
                return box;
            }).collect(Collectors.toList()));
        }
        return market;
    }
}
