package br.edu.uniaeso.merca_recife.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_merchant")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String contact;
    private boolean approved;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_merchant_pruducts_sold", joinColumns = @JoinColumn(name = "merchant_id"))
    @Column(name = "product_name")
    private List<String> productsSold;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_mechant_boxes",
            joinColumns = @JoinColumn(name = "merchant_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "box_id", referencedColumnName = "id", nullable = false),
            uniqueConstraints = @UniqueConstraint(name = "unq_merchant_box", columnNames = {"merchant_id", "box_id"})
    )
    private List<Box> ownedBoxes;

    public Merchant() {
    }

    public Merchant(Long id, String name, String cpf, String email, String contact, boolean approved, List<String> productsSold, List<Box> ownedBoxes) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.contact = contact;
        this.approved = approved;
        this.productsSold = productsSold;
        this.ownedBoxes = ownedBoxes;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<String> getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(List<String> productsSold) {
        this.productsSold = productsSold;
    }

    public List<Box> getOwnedBoxes() {
        return ownedBoxes;
    }

    public void setOwnedBoxes(List<Box> ownedBoxes) {
        this.ownedBoxes = ownedBoxes;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
