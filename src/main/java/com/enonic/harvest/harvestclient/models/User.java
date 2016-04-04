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

@JsonIgnoreProperties(ignoreUnknown = true)
public class User
{

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("has_access_to_all_future_projects")
    private boolean hasAccessToAllFutureProjects;

    @JsonProperty("default_hourly_rate")
    private BigDecimal defaultHourlyRate;

    @JsonProperty("is_active")
    private boolean isActive;

    @JsonProperty("is_admin")
    private boolean isAdmin;

    @JsonProperty("is_contractor")
    private boolean isContractor;

    @JsonProperty("telephone")
    private String telephone;

    @JsonProperty("department")
    private String department;

    @JsonProperty("timezone")
    private String timezone;

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

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public boolean hasAccessToAllFutureProjects()
    {
        return hasAccessToAllFutureProjects;
    }

    public void setAccessToAllFutureProjects(boolean hasAccessToAllFutureProjects)
    {
        this.hasAccessToAllFutureProjects = hasAccessToAllFutureProjects;
    }

    public BigDecimal getDefaultHourlyRate()
    {
        return defaultHourlyRate;
    }

    public void setDefaultHourlyRate(BigDecimal defaultHourlyRate)
    {
        this.defaultHourlyRate = defaultHourlyRate;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public void setActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public boolean isAdmin()
    {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin)
    {
        this.isAdmin = isAdmin;
    }

    public boolean isContractor()
    {
        return isContractor;
    }

    public void setContractor(boolean isContractor)
    {
        this.isContractor = isContractor;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getTimezone()
    {
        return timezone;
    }

    public void setTimezone(String timezone)
    {
        this.timezone = timezone;
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public static User fromInputStream(final InputStream xml)
            throws HarvestClientException
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(User.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (User) unmarshaller.unmarshal(xml);
        }
        catch (Exception e)
        {
            throw new HarvestClientException("Unable to parse XML into User.", e);
        }

    }
}
