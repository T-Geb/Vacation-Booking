package com.Project.Controllers;


import com.Project.Services.CheckoutService;
import com.Project.dto.Purchase;
import com.Project.dto.PurchaseResponse;

import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;
    // only have one constructor so we don't need autowire
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }
    /* Adding a post mapping for purchase that takes in the Purchase information and returns a PurchaseResponse using the method from CheckoutService*/
    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }

}
