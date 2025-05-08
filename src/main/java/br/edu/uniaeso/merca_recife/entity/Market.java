package br.edu.uniaeso.merca_recife.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_market")
public class Market {
    @Id
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_market_boxes",
            joinColumns = @JoinColumn(name = "market_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "box_id", referencedColumnName = "id", nullable = false),
            uniqueConstraints = @UniqueConstraint(name = "unq_market_box", columnNames = {"market_id", "box_id"})
    )
    private List<Box> boxes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
    }
}
