package nz.co.spark.flowable.workflow.poc.domain;

public class HolidayRequestProcess extends Process
{
    String employName;
    Integer requestDays;
    String reason;

    public String getEmployName()
    {
        return employName;
    }

    public void setEmployName(final String employName)
    {
        this.employName = employName;
    }

    public Integer getRequestDays()
    {
        return requestDays;
    }

    public void setRequestDays(final Integer requestDays)
    {
        this.requestDays = requestDays;
    }

    public String getReason()
    {
        return reason;
    }

    public void setReason(final String reason)
    {
        this.reason = reason;
    }

    @Override
    public String toString()
    {
        return "HolidayRequestProcess{" +
                "process='" + super.toString() + '\'' +
                "employName='" + employName + '\'' +
                ", requestDays=" + requestDays +
                ", reason='" + reason + '\'' +
                '}';
    }
}
