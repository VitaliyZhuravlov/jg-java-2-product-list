package com.jg.productlist.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Optional;

@Data
@Entity
@Table(name = "users")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
}
