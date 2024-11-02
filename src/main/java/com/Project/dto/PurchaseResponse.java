package com.Project.dto;

import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor  // to generate the constructor needed for the field to be used in CheckoutServiceImpl.java
public class PurchaseResponse { //this class will be used to send back POJO as JSON


    private String OrderTrackingNumber;

}
