package com.ford.turbo.services.Operators;

import org.springframework.web.context.request.WebRequest;

public class CalculateOrder {

    public Double calculateOrderTotal(WebRequest request) {
        Double totalOrderAmount = 0.0;
        Integer totalQty = 0;

        //Get all request parameters values
        String[] priceArray = request.getParameter("tire_price").toString().split(",");
        String[] qtyArray = request.getParameter("tire_qty").toString().split(",");

        try {
            //Loop through all selected tires(received via request) to calculate their final total amount
            for (int i = 0; i < priceArray.length; i++) {
                Integer tire_price = Integer.parseInt(priceArray[i]);
                Integer tire_qty = Integer.parseInt(qtyArray[i]);
                totalQty = totalQty + tire_qty;
                totalOrderAmount = totalOrderAmount + (tire_price * tire_qty);
            }

            //Apply 20% discount if tire quantity is 4 or more.
            if (totalQty >= 4) {
                totalOrderAmount = totalOrderAmount - ((totalOrderAmount * 20) / 100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalOrderAmount;
    }
}
