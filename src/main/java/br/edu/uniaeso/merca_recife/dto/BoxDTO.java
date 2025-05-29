package br.edu.uniaeso.merca_recife.dto;

import java.util.ArrayList;
import java.util.List;

public class BoxDTO {

    private Long id;
    private Long marketId;
    private byte[] image;
    private List<String> products = new ArrayList<>();

    public BoxDTO() {}

    public BoxDTO(Long id, Long marketId, byte[] image, List<String> products) {
        this.id = id;
        this.marketId = marketId;
        this.image = image;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}
