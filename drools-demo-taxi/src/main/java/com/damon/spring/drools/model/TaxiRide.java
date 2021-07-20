package com.damon.spring.drools.model;

public class TaxiRide
{
    private Boolean isNightSurcharge;
    private Long distanceInMile;

    public Boolean getIsNightSurcharge()
    {
        return isNightSurcharge;
    }

    public void setIsNightSurcharge(final Boolean isNightSurcharge)
    {
        this.isNightSurcharge = isNightSurcharge;
    }

    public Long getDistanceInMile()
    {
        return distanceInMile;
    }

    public void setDistanceInMile(final Long distanceInMile)
    {
        this.distanceInMile = distanceInMile;
    }

}
