package com.enonic.harvest.harvestclient.models;

import com.enonic.harvest.harvestclient.exceptions.HarvestClientException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Invoice
{
    @JsonProperty("id")
    private Long id;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("due_amount")
    private BigDecimal dueAmount;

    @JsonProperty("due_at")
    private Date dueAt;

    @JsonProperty("due_at_human_format")
    private String dueAtHumanFormat;

    @JsonProperty("period_end")
    private Date periodEnd;

    @JsonProperty("period_start")
    private Date periodStart;

    @JsonProperty("client_id")
    private Long clientId;

    @JsonProperty("subject")
    private Long subject;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("issued_at")
    private Date issuedAt;

    @JsonProperty("created_by_id")
    private Long createdById;

    @JsonProperty("notes")
    private String notes;

    @JsonProperty("number")
    private String number;

    @JsonProperty("purchase_order")
    private String purchaseOrder;

    @JsonProperty("client_key")
    private String clientKey;

    @JsonProperty("state")
    private String state;

    @JsonProperty("tax")
    private BigDecimal tax;

    @JsonProperty("tax2")
    private BigDecimal tax2;

    @JsonProperty("tax_amount")
    private BigDecimal taxAmount;

    @JsonProperty("tax_amount2")
    private BigDecimal taxAmount2;

    @JsonProperty("discount_amount")
    private BigDecimal discountAmount;

    @JsonProperty("discount")
    private BigDecimal discount;

    @JsonProperty("recurring_invoice_id")
    private Long recurringInvoiceId;

    @JsonProperty("estimate_id")
    private Long estimateId;

    @JsonProperty("retainer_id")
    private Long retainerId;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("created_at")
    private Date createdAt;

    public static Invoice fromInputStream(final InputStream xml)
            throws HarvestClientException
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(Invoice.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Invoice) unmarshaller.unmarshal(xml);
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

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public BigDecimal getDueAmount()
    {
        return dueAmount;
    }

    public void setDueAmount(BigDecimal dueAmount)
    {
        this.dueAmount = dueAmount;
    }

    public Date getDueAt()
    {
        return dueAt;
    }

    public void setDueAt(Date dueAt)
    {
        this.dueAt = dueAt;
    }

    public String getDueAtHumanFormat()
    {
        return dueAtHumanFormat;
    }

    public void setDueAtHumanFormat(String dueAtHumanFormat)
    {
        this.dueAtHumanFormat = dueAtHumanFormat;
    }

    public Date getPeriodEnd()
    {
        return periodEnd;
    }

    public void setPeriodEnd(Date periodEnd)
    {
        this.periodEnd = periodEnd;
    }

    public Date getPeriodStart()
    {
        return periodStart;
    }

    public void setPeriodStart(Date periodStart)
    {
        this.periodStart = periodStart;
    }

    public Long getClientId()
    {
        return clientId;
    }

    public void setClientId(Long clientId)
    {
        this.clientId = clientId;
    }

    public Long getSubject()
    {
        return subject;
    }

    public void setSubject(Long subject)
    {
        this.subject = subject;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public Date getIssuedAt()
    {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt)
    {
        this.issuedAt = issuedAt;
    }

    public Long getCreatedById()
    {
        return createdById;
    }

    public void setCreatedById(Long createdById)
    {
        this.createdById = createdById;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getPurchaseOrder()
    {
        return purchaseOrder;
    }

    public void setPurchaseOrder(String purchaseOrder)
    {
        this.purchaseOrder = purchaseOrder;
    }

    public String getClientKey()
    {
        return clientKey;
    }

    public void setClientKey(String clientKey)
    {
        this.clientKey = clientKey;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public BigDecimal getTax()
    {
        return tax;
    }

    public void setTax(BigDecimal tax)
    {
        this.tax = tax;
    }

    public BigDecimal getTax2()
    {
        return tax2;
    }

    public void setTax2(BigDecimal tax2)
    {
        this.tax2 = tax2;
    }

    public BigDecimal getTaxAmount()
    {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount)
    {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getTaxAmount2()
    {
        return taxAmount2;
    }

    public void setTaxAmount2(BigDecimal taxAmount2)
    {
        this.taxAmount2 = taxAmount2;
    }

    public BigDecimal getDiscountAmount()
    {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount)
    {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getDiscount()
    {
        return discount;
    }

    public void setDiscount(BigDecimal discount)
    {
        this.discount = discount;
    }

    public Long getRecurringInvoiceId()
    {
        return recurringInvoiceId;
    }

    public void setRecurringInvoiceId(Long recurringInvoiceId)
    {
        this.recurringInvoiceId = recurringInvoiceId;
    }

    public Long getEstimateId()
    {
        return estimateId;
    }

    public void setEstimateId(Long estimateId)
    {
        this.estimateId = estimateId;
    }

    public Long getRetainerId()
    {
        return retainerId;
    }

    public void setRetainerId(Long retainerId)
    {
        this.retainerId = retainerId;
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
