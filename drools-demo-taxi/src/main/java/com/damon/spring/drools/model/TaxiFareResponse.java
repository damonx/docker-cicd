package com.damon.spring.drools.model;

public class TaxiFareResponse
{
    private long finalFare;
    private long miles;

    public long getFinalFare()
    {
        return finalFare;
    }

    public void setFinalFare(final long finalFare)
    {
        this.finalFare = finalFare;
    }

    public long getMiles()
    {
        return miles;
    }

    public void setMiles(final long miles)
    {
        this.miles = miles;
    }
}
