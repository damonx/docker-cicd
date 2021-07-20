package com.damon.spring.drools.service;

import com.damon.spring.drools.model.Fare;
import com.damon.spring.drools.model.TaxiFareResponse;
import com.damon.spring.drools.model.TaxiRide;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxiFareCalculatorService
{

    @Autowired
    private KieContainer kContainer;

    public TaxiFareResponse calculateFare(final TaxiRide taxiRide, final Fare rideFare)
    {
        final KieSession kieSession = kContainer.newKieSession();
        kieSession.setGlobal("rideFare", rideFare);
        kieSession.insert(taxiRide);
        kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println("!! RIDE FARE !! " + rideFare.getTotalFare());
        final TaxiFareResponse response = new TaxiFareResponse();
        response.setFinalFare(rideFare.getTotalFare());
        return response;
    }
}
