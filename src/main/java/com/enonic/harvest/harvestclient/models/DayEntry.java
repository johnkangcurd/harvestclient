package com.enonic.harvest.harvestclient.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Date;


@JsonIgnoreProperties(ignoreUnknown = true)
public class DayEntry
{

    @JsonProperty(value = "hours")
    private BigDecimal hours;

    @JsonProperty(value = "id")
    private Integer id;

    @JsonProperty(value = "notes")
    private String notes;

    @JsonProperty(value = "project_id")
    private Integer projectId;

    @JsonProperty(value = "spent_at")
    private Date spentAt;

    @JsonProperty(value = "task_id")
    private Integer taskId;

    @JsonProperty(value = "user_id")
    private Integer userId;

    @JsonProperty(value = "is_billed")
    private boolean isBilled;

    @JsonProperty(value = "is_closed")
    private boolean isClosed;

    @JsonProperty(value = "updated_at")
    private Date updatedAt;

    @JsonProperty(value = "created_at")
    private Date createdAt;

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public BigDecimal getHours()
    {
        return hours;
    }

    public void setHours(BigDecimal hours)
    {
        this.hours = hours;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public boolean isClosed()
    {
        return isClosed;
    }

    public void setClosed(boolean isClosed)
    {
        this.isClosed = isClosed;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public Integer getProjectId()
    {
        return projectId;
    }

    public void setProjectId(Integer projectId)
    {
        this.projectId = projectId;
    }

    public Date getSpentAt()
    {
        return spentAt;
    }

    public void setSpentAt(Date spentAt)
    {
        this.spentAt = spentAt;
    }

    public Integer getTaskId()
    {
        return taskId;
    }

    public void setTaskId(Integer taskId)
    {
        this.taskId = taskId;
    }

    public Date getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public boolean isBilled()
    {
        return isBilled;
    }

    public void setBilled(boolean isBilled)
    {
        this.isBilled = isBilled;
    }
}
