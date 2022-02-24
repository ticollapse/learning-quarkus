package teste.vitor.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ordem")
public class Order { // Pattern Repository, classe menos sobrecarreda, funcoes bem definidas

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "preco")
    private Double price;

    @Column(name = "tipo")
    private String type;

    @Column(name="data")
    private LocalDate date;

    private String status;

    @Column(name = "user_id")
    private Long userId;


    public void setPrice(Double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
