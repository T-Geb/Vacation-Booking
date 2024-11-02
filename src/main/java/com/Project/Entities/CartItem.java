package com.Project.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    // defining fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    @ManyToOne    // removed fetch type = lazy
    @JoinColumn(name = "vacation_id", nullable = false)  // one vacation can have many cart items... vacation_id here is a foreign key.. it's from the Vacation table
    private Vacation vacation;

    @ManyToMany
    @JoinTable(name = "excursion_cartitem", joinColumns = @JoinColumn(name = "cart_item_id"), inverseJoinColumns = @JoinColumn(name = "excursion_id"))
    private Set<Excursion> excursions;  /*Mapping a many-to-many relationship...This side defines the join table...You only need to define the join table on one side. */

    @ManyToOne         // Removed Fetch type = Lazy.
    @JoinColumn(name = "cart_id", nullable = false)  // many cart items can belong to one cart... cart_id here is a foreign key... it's from Cart table.
    private Cart cart;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

}
