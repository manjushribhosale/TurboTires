package com.ford.turbo.controllers;

import com.ford.turbo.objects.TireData;
import com.ford.turbo.services.Operators.*;
import com.ford.turbo.services.Operators.CalculateOrder;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import java.util.List;

@RestController
@Api(value="Turbo", description = "Provides tire information and placing orders!")
public class TurboController {

    //Controller for creating endpoints and making respective function calls.

    @Autowired
    private TireDataProvider tireDataProvider;

    CalculateOrder calculateOrder = new CalculateOrder();

    //Enpoint for loading tire data
    @RequestMapping(value="/getTireDetails", method = RequestMethod.GET )
    public List<TireData> tireData(){
        return tireDataProvider.getTireData();
    }

    //Endpoint for calculating tire order
    @RequestMapping(value="/calculateTotalOrder", method=RequestMethod.POST)
    public Double calculateTotalOrder(WebRequest request){
        return calculateOrder.calculateOrderTotal(request);
    }

}