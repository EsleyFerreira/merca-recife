package br.edu.uniaeso.merca_recife.dto;

import jakarta.validation.constraints.Email;
import java.util.List;

public class MerchantDTO {

    private Long id;
    private String name;
    private String cpf;

    @Email
    private String email;
    private String contact;
    private boolean approved;
    private List<String> productsSold;
    private List<BoxDTO> ownedBoxes;

    public MerchantDTO() {
    }

    public MerchantDTO(Long id, String name, String cpf, String email, String contact, boolean approved, List<String> productsSold, List<BoxDTO> ownedBoxes) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.contact = contact;
        this.approved = approved;
        this.productsSold = productsSold;
        this.ownedBoxes = ownedBoxes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public List<BoxDTO> getOwnedBoxes() {
        return ownedBoxes;
    }

    public void setOwnedBoxes(List<BoxDTO> ownedBoxes) {
        this.ownedBoxes = ownedBoxes;
    }

    public List<String> getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(List<String> productsSold) {
        this.productsSold = productsSold;
    }
}
