package com.Project.Services;

import com.Project.dto.Purchase;
import com.Project.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

}
