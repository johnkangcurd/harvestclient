package com.enonic.harvest.harvestclient.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAssignment
{
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("project_id")
    private Integer projectId;

    @JsonProperty("deactivated")
    private boolean deactivated;

    @JsonProperty("hourly_rate")
    private BigDecimal hourlyRate;

    @JsonProperty("is_project_manager")
    private boolean isProjectManager;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("created_at")
    private Date createdAt;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getProjectId()
    {
        return projectId;
    }

    public void setProjectId(Integer projectId)
    {
        this.projectId = projectId;
    }

    public boolean isDeactivated()
    {
        return deactivated;
    }

    public void setDeactivated(boolean deactivated)
    {
        this.deactivated = deactivated;
    }

    public BigDecimal getHourlyRate()
    {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate)
    {
        this.hourlyRate = hourlyRate;
    }

    public boolean isProjectManager()
    {
        return isProjectManager;
    }

    public void setProjectManager(boolean isProjectManager)
    {
        this.isProjectManager = isProjectManager;
    }

    public Date getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }
}