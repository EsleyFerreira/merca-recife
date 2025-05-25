package br.edu.uniaeso.merca_recife.dto;

public class BoxDTO {

    private Long id;
    private Long marketId;
    private byte[] image;

    public BoxDTO() {}

    public BoxDTO(Long id, Long marketId, byte[] image) {
        this.id = id;
        this.marketId = marketId;
        this.image = image;
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
}
