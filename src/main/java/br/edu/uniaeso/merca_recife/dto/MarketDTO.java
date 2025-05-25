package br.edu.uniaeso.merca_recife.dto;

import java.util.List;

public class MarketDTO {

    private Long id;
    private List<Long> boxIds;

    public MarketDTO() {
    }

    public MarketDTO(Long id, List<Long> boxIds) {
        this.id = id;
        this.boxIds = boxIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getBoxIds() {
        return boxIds;
    }

    public void setBoxIds(List<Long> boxIds) {
        this.boxIds = boxIds;
    }
}
