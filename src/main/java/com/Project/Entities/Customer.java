package com.Project.Entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    // defining fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id") //maps name to database column
    private Long id;    // has to be same to frontend

    @Column(name = "customer_first_name", nullable = false)  // added nullable=false for validation in frontend
    private String firstName;

    @Column(name = "customer_last_name", nullable = false)   // added nullable=false for validation in frontend
    private String lastName;

    @Column(name = "address", nullable = false)  // added nullable=false for validation in frontend
    private String address;

    @Column(name = "postal_code", nullable = false)  // added nullable=false for validation in frontend
    private String postal_code;

    @Column(name = "phone", nullable = false)   // added nullable=false for validation in frontend
    private String phone;

    @Column(name = "create_date",updatable = false)
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne       // removed fetch type = lazy
    @JoinColumn(name = "division_id")   // foreign id used in Customers table from Division table.    Removed nullable=false because division_id can have null values.
    private Division division;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")  //  mapped by - refers to the variable name in the target class that's using the foreign key not the class name itself
    private Set<Cart> carts = new HashSet<>();           // one customer can have many carts... customer id is a foreign key in the Carts table.

    // adding constructor to be used in BootStrapData.java
    public Customer(String firstName, String lastName, String address, String postal_code, String phone, Division division) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postal_code = postal_code;
        this.phone = phone;
        this.division = division;
    }
}
