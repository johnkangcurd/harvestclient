package com.enonic.harvest.harvestclient.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    private Long highriseId;

    @JsonProperty(value="id")
    private Long id;

    @JsonProperty(value="cache_version")
    private Long cacheVersion;

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

    public Long getHighriseId()
    {
        return highriseId;
    }

    public void setHighriseId(Long highriseId)
    {
        this.highriseId = highriseId;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getCacheVersion()
    {
        return cacheVersion;
    }

    public void setCacheVersion(Long cacheVersion)
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
