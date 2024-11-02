package com.Project.Services;

import com.Project.Dao.CartRepository;
import com.Project.Entities.Cart;
import com.Project.Entities.CartItem;
import com.Project.Entities.StatusType;
import com.Project.dto.Purchase;
import com.Project.dto.PurchaseResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service    // a service implementation
public class CheckoutServiceImpl implements CheckoutService {

    private CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve cart info from dto
        Cart cart = purchase.getCart();
        Set<CartItem> cartItems = purchase.getCartItems();

        /* Adding validation to return a meaningful message instead of order tracking number when cart is empty */
        if(cart == null || cartItems == null || cartItems.isEmpty()) {

            return new PurchaseResponse("Cart is Empty. Please add items to cart first!");
        }

        // generate tracking number only if cart is valid
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(StatusType.ordered);

        // populate cart with cartItems
        cartItems.forEach(item -> cart.add(item));

        // save to the database
        cartRepository.save(cart);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        // generating a random UUID number (UUID version - 4)
        return UUID.randomUUID().toString();
    }
}
