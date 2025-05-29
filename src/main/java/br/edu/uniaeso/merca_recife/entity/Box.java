package br.edu.uniaeso.merca_recife.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_box_products", joinColumns = @JoinColumn(name = "box_id"))
    @Column(name = "product_name")
    private List<String> products = new ArrayList<>();

    public Box() {
    }

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

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}
