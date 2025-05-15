package br.edu.uniaeso.merca_recife.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_box")
public class Box {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "market_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Market market;

    @Column(columnDefinition = "BYTEA")
    private byte[] image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
