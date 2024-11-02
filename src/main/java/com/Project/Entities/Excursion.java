package com.Project.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Excursion {

    // defining fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private Long id;

    @Column(name = "excursion_title")
    private String excursion_title;

    @Column(name = "excursion_price")
    private BigDecimal excursion_price;

    @Column(name = "image_url")
    private String image_URL;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne   // removed fetch type lazy
    @JoinColumn(name = "vacation_id", nullable = false)  // foreign key... vacation_id from Vacation table.. many excursions can belong to one vacation.
    private Vacation vacation;

    // many to many is lazy by default...
    @ManyToMany(mappedBy = "excursions")   // this side references joined table created in CartItem class with mappedBy
    private Set<CartItem> cartItems;   // come back and fix if the naming has problems.. UML said it was cartitems


}
