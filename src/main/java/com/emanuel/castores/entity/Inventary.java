package com.emanuel.castores.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Inventary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventary")
    private int id;



    @ManyToOne
    @JoinColumn(name = "id_product")
    private Products product;

    @ManyToOne// Foreign key column
    @JoinColumn(name = "id_user")
    private Users user;

    private int quantity;
    private int status;
    private Date date;

    public void Inventary() {}
}
