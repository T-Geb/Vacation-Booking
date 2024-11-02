package com.Project.dto;


import com.Project.Entities.Cart;
import com.Project.Entities.CartItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {         // data transfer object, to transfer data between Angular front-end and Spring Boot back-end.

    private Cart cart;
    private Set<CartItem> cartItems;


}
