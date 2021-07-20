package com.damon.spring.drools.model;

public class Fare
{
    private Long nightSurcharge;
    private Long rideFare;
    private Long totalFare;

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

    public void setTotalFare(final Long totalFare)
    {
        this.totalFare = totalFare;
    }

    public Long getTotalFare()
    {
        return totalFare;
    }

}

