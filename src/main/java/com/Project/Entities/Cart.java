package com.Project.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    // defining fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "package_price")
    private BigDecimal package_price;

    @Column(name = "party_size")
    private int party_size;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)      // mapping the enum value status from enum class.
    private StatusType status;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne      // removed fetch type=lazy  // many carts can belong to one customer.. this is the foreign key from the customer table..
    @JoinColumn(name = "customer_id", nullable = false)  // name here is mapped to the database table name  .. nullable=false because this column is marked as NOTNULL in db.
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")   // one cart can have many cart items. cart_id used as foreign key in CartItem table.
    private Set<CartItem> cartItem = new HashSet<>();

    public void add(CartItem item) {
        if(item != null) {
            if(cartItem == null) {
                cartItem = new HashSet<>();
            }
            cartItem.add(item);
            item.setCart(this);
        }
    }

}
