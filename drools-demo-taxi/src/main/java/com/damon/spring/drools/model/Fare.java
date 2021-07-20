package com.damon.spring.drools.model;

public class Fare
{
    private Long nightSurcharge;
    private Long rideFare;

    public Fare()
    {
        nightSurcharge = 0L;
        rideFare = 0L;
    }

    public Long getNightSurcharge()
    {
        return nightSurcharge;
    }

    public void setNightSurcharge(final Long nightSurcharge)
    {
        this.nightSurcharge = nightSurcharge;
    }

    public Long getRideFare()
    {
        return rideFare;
    }

    public void setRideFare(final Long rideFare)
    {
        this.rideFare = rideFare;
    }

    public Long getTotalFare()
    {
        return nightSurcharge + rideFare;
    }

}

