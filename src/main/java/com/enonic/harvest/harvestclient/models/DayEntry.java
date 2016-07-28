package com.enonic.harvest.harvestclient.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.TimeZone;


@JsonIgnoreProperties(ignoreUnknown = true)
public class DayEntry
{

    @JsonProperty(value = "hours")
    private BigDecimal hours;

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "notes")
    private String notes;

    @JsonProperty(value = "project_id")
    private Long projectId;

    @JsonProperty(value = "spent_at")
    private String spentAt;

    @JsonProperty(value = "task_id")
    private Long taskId;

    @JsonProperty(value = "user_id")
    private Long userId;

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

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
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

    public Long getProjectId()
    {
        return projectId;
    }

    public void setProjectId(Long projectId)
    {
        this.projectId = projectId;
    }

    public String getSpentAt()
    {
        return spentAt;
    }

    public void setSpentAt(String spentAt)
    {
        this.spentAt = spentAt;
    }

    public Long getTaskId()
    {
        return taskId;
    }

    public void setTaskId(Long taskId)
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

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
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
