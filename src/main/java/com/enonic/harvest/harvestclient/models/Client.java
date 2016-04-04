package com.enonic.harvest.harvestclient.models;

import com.enonic.harvest.harvestclient.exceptions.HarvestClientException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.InputStream;
import java.util.Date;

//@JsonRootName(value = "client")  // FIXME: 4/4/16 this is not working as expected
@JsonIgnoreProperties(ignoreUnknown = true)
public class Client
{

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value="created_at")
    private Date createdAt;

    @JsonProperty(value="updated_at")
    private Date updatedAt;

    @JsonProperty(value="highrise_id")
    private Integer highriseId;

    @JsonProperty(value="id")
    private Integer id;

    @JsonProperty(value="cache_version")
    private Integer cacheVersion;

    @JsonProperty(value="currency")
    private String currency;

    @JsonProperty(value="active")
    private boolean active;

    @JsonProperty(value="currency_symbol")
    private String currencySymbol;

    @JsonProperty(value="details")
    private String details;

    @JsonProperty(value="default_invoice_timeframe")
    private String defaultInvoiceTimeframe;

    @JsonProperty(value="last_invoice_kind")
    private String lastInvoiceKind;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public Integer getHighriseId()
    {
        return highriseId;
    }

    public void setHighriseId(Integer highriseId)
    {
        this.highriseId = highriseId;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getCacheVersion()
    {
        return cacheVersion;
    }

    public void setCacheVersion(Integer cacheVersion)
    {
        this.cacheVersion = cacheVersion;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public String getCurrencySymbol()
    {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol)
    {
        this.currencySymbol = currencySymbol;
    }

    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public String getDefaultInvoiceTimeframe()
    {
        return defaultInvoiceTimeframe;
    }

    public void setDefaultInvoiceTimeframe(String defaultInvoiceTimeframe)
    {
        this.defaultInvoiceTimeframe = defaultInvoiceTimeframe;
    }

    public String getLastInvoiceKind()
    {
        return lastInvoiceKind;
    }

    public void setLastInvoiceKind(String lastInvoiceKind)
    {
        this.lastInvoiceKind = lastInvoiceKind;
    }
}
