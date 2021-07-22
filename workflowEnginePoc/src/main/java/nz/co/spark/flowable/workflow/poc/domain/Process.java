package nz.co.spark.flowable.workflow.poc.domain;

import java.util.Date;

public class Process
{
    private String executionId;
    private String processInstanceId;
    private String name;
    private String description;
    private String processDefinitionId;
    private String processDefinitionName;
    private String processDefinitionKey;
    private Date startTime;
    private String startUser;

    public String getExecutionId()
    {
        return executionId;
    }

    public void setExecutionId(final String executionId)
    {
        this.executionId = executionId;
    }

    public String getProcessInstanceId()
    {
        return processInstanceId;
    }

    public void setProcessInstanceId(final String processInstanceId)
    {
        this.processInstanceId = processInstanceId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }

    public String getProcessDefinitionId()
    {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(final String processDefinitionId)
    {
        this.processDefinitionId = processDefinitionId;
    }

    public String getProcessDefinitionName()
    {
        return processDefinitionName;
    }

    public void setProcessDefinitionName(final String processDefinitionName)
    {
        this.processDefinitionName = processDefinitionName;
    }

    public String getProcessDefinitionKey()
    {
        return processDefinitionKey;
    }

    public void setProcessDefinitionKey(final String processDefinitionKey)
    {
        this.processDefinitionKey = processDefinitionKey;
    }

    public Date getStartTime()
    {
        return startTime;
    }

    public void setStartTime(final Date startTime)
    {
        this.startTime = startTime;
    }

    public String getStartUser()
    {
        return startUser;
    }

    public void setStartUser(final String startUser)
    {
        this.startUser = startUser;
    }

    @Override
    public String toString()
    {
        return "Process{" +
                "executionId='" + executionId + '\'' +
                ", processInstanceId='" + processInstanceId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", processDefinitionId='" + processDefinitionId + '\'' +
                ", processDefinitionName='" + processDefinitionName + '\'' +
                ", processDefinitionKey='" + processDefinitionKey + '\'' +
                ", startTime=" + startTime +
                ", startUser='" + startUser + '\'' +
                '}';
    }

}
