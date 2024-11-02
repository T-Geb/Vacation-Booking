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
@Table(name = "divisions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Division {

    // defining fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @Column(name = "division", nullable = false)  // added nullable=false for validation in frontend
    private String division_name;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne    // removed fetch type = lazy
    @JoinColumn(name = "country_id", nullable = false)   // many divisions can belong to one country... country_id is foreign key. It's from Country table
    private Country country;

    @Column(name = "country_id", insertable = false, updatable = false)
    private Long country_id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division") // one division can have many customers...division_id is a foreign key in the Customers table.
    private Set<Customer> customers;

}
