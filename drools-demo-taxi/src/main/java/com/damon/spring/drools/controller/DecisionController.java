package com.damon.spring.drools.controller;

import com.damon.spring.drools.model.Fare;
import com.damon.spring.drools.model.TaxiFareResponse;
import com.damon.spring.drools.model.TaxiRide;
import com.damon.spring.drools.service.TaxiFareCalculatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecisionController
{
    @Autowired
    private TaxiFareCalculatorService taxiService;

    @GetMapping("/taxi")
    private ResponseEntity<TaxiFareResponse> getDiscountPercent()
    {
        final TaxiRide taxiRide = new TaxiRide();
        taxiRide.setIsNightSurcharge(true);
        taxiRide.setDistanceInMile(190L);
        final Fare rideFare = new Fare();
        final TaxiFareResponse taxiFareResp = taxiService.calculateFare(taxiRide, rideFare);
        return new ResponseEntity<>(taxiFareResp, HttpStatus.OK);
    }
}
