package com.enonic.harvest.harvestclient.models;

import com.enonic.harvest.harvestclient.exceptions.HarvestClientException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project
{

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("client_id")
    private Integer clientId;

    @JsonProperty("code")
    private String code;

    @JsonProperty("active")
    private boolean active;

    @JsonProperty("notes")
    private String notes;

    @JsonProperty("billable")
    private boolean billable;

    @JsonProperty("bill_by")
    private String billBy;

    @JsonProperty("hourly_rate")
    private BigDecimal hourlyRate;

    @JsonProperty("budget_by")
    private String budgetBy;

    @JsonProperty("budget")
    private BigDecimal budget;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("cost_budget")
    private BigDecimal costBudget;

    @JsonProperty("cost_budget_include_expenses")
    private boolean costBudgetIncludeExpenses;

    @JsonProperty("notify_when_over_budget")
    private boolean notifyWhenOverBudget;

    @JsonProperty("over_budget_notification_percentage")
    private BigDecimal overBudgetNotificationPercentage;

    @JsonProperty("over_budget_notified_at")
    private Date overBudgetNotifiedAt;

    @JsonProperty("show_budget_to_all")
    private boolean showBudgetToAll;

    @JsonProperty("hint_earliest_record_at")
    private Date hintEarliestRecordAt;

    @JsonProperty("hint_latest_record_at")
    private Date hintLatestRecordAt;

    private List<UserAssignment> userAssignments;
    private List<TaskAssignment> taskAssignments;

    public String getName()
    {
        return name;
    }

    public UserAssignment getUserAssignmentByUser(int userId)
    {
        for (UserAssignment userAssignment : this.userAssignments)
        {
            if (userAssignment.getUserId() == userId)
                return userAssignment;
        }
        return null;
    }

    public TaskAssignment getTaskAssignmentByTask(int taskId)
    {
        for (TaskAssignment taskAssignment : this.taskAssignments)
        {
            if (taskAssignment.getTaskId() == taskId)
                return taskAssignment;
        }
        return null;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getClientId()
    {
        return clientId;
    }

    public void setClientId(Integer clientId)
    {
        this.clientId = clientId;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public boolean isBillable()
    {
        return billable;
    }

    public void setBillable(boolean billable)
    {
        this.billable = billable;
    }

    public String getBillBy()
    {
        return billBy;
    }

    public void setBillBy(String billBy)
    {
        this.billBy = billBy;
    }

    public BigDecimal getHourlyRate()
    {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate)
    {
        this.hourlyRate = hourlyRate;
    }

    public String getBudgetBy()
    {
        return budgetBy;
    }

    public void setBudgetBy(String budgetBy)
    {
        this.budgetBy = budgetBy;
    }

    public BigDecimal getBudget()
    {
        return budget;
    }

    public void setBudget(BigDecimal budget)
    {
        this.budget = budget;
    }

    public List<UserAssignment> getUserAssignments() {
        return userAssignments;
    }

    public void setUserAssignments(List<UserAssignment> userAssignments) {
        this.userAssignments = userAssignments;
    }

    public List<TaskAssignment> getTaskAssignments() {
        return taskAssignments;
    }

    public void setTaskAssignments(List<TaskAssignment> taskAssignments) {
        this.taskAssignments = taskAssignments;
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

    public BigDecimal getCostBudget()
    {
        return costBudget;
    }

    public void setCostBudget(BigDecimal costBudget)
    {
        this.costBudget = costBudget;
    }

    public boolean getCostBudgetIncludeExpenses()
    {
        return costBudgetIncludeExpenses;
    }

    public void setCostBudgetIncludeExpenses(boolean costBudgetIncludeExpenses)
    {
        this.costBudgetIncludeExpenses = costBudgetIncludeExpenses;
    }

    public boolean getNotifyWhenOverBudget()
    {
        return notifyWhenOverBudget;
    }

    public void setNotifyWhenOverBudget(boolean notifyWhenOverBudget)
    {
        this.notifyWhenOverBudget = notifyWhenOverBudget;
    }

    public BigDecimal getOverBudgetNotificationPercentage()
    {
        return overBudgetNotificationPercentage;
    }

    public void setOverBudgetNotificationPercentage(BigDecimal overBudgetNotificationPercentage)
    {
        this.overBudgetNotificationPercentage = overBudgetNotificationPercentage;
    }

    public Date getOverBudgetNotifiedAt()
    {
        return overBudgetNotifiedAt;
    }

    public void setOverBudgetNotifiedAt(Date overBudgetNotifiedAt)
    {
        this.overBudgetNotifiedAt = overBudgetNotifiedAt;
    }

    public boolean getShowBudgetToAll()
    {
        return showBudgetToAll;
    }

    public void setShowBudgetToAll(boolean showBudgetToAll)
    {
        this.showBudgetToAll = showBudgetToAll;
    }

    public Date getHintEarliestRecordAt()
    {
        return hintEarliestRecordAt;
    }

    public void setHintEarliestRecordAt(Date hintEarliestRecordAt)
    {
        this.hintEarliestRecordAt = hintEarliestRecordAt;
    }

    public Date getHintLatestRecordAt()
    {
        return hintLatestRecordAt;
    }

    public void setHintLatestRecordAt(Date hintLatestRecordAt)
    {
        this.hintLatestRecordAt = hintLatestRecordAt;
    }

    public static Project fromInputStream(final InputStream xml)
            throws HarvestClientException
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(Project.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Project) unmarshaller.unmarshal(xml);
        }
        catch (Exception e)
        {
            throw new HarvestClientException("Unable to parse XML into Project.", e);
        }

    }
}
