package com.enonic.harvest.harvestclient.models;

import com.enonic.harvest.harvestclient.exceptions.HarvestClientException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceItemCategory
{
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("use_as_expense")
    private boolean useAsExpense;

    @JsonProperty("use_as_service")
    private boolean useAsService;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("created_at")
    private Date createdAt;

    public static InvoiceItemCategory fromInputStream(final InputStream xml)
            throws HarvestClientException
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(InvoiceItemCategory.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (InvoiceItemCategory) unmarshaller.unmarshal(xml);
        }
        catch (Exception e)
        {
            throw new HarvestClientException("Unable to parse XML into Invoice.", e);
        }

    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isUseAsExpense()
    {
        return useAsExpense;
    }

    public void setUseAsExpense(boolean useAsExpense)
    {
        this.useAsExpense = useAsExpense;
    }

    public boolean isUseAsService()
    {
        return useAsService;
    }

    public void setUseAsService(boolean useAsService)
    {
        this.useAsService = useAsService;
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
