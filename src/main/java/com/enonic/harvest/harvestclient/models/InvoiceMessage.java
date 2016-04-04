package com.enonic.harvest.harvestclient.models;

import com.enonic.harvest.harvestclient.exceptions.HarvestClientException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceMessage
{
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("body")
    private String body;

    @JsonProperty("invoice_id")
    private Integer invoiceId;

    @JsonProperty("send_me_a_copy")
    private boolean sendMeACopy;

    @JsonProperty("sent_by")
    private String sentBy;

    @JsonProperty("sent_by_email")
    private String sentByEmail;

    @JsonProperty("full_recipient_list")
    private String fullRecipientList;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("created_at")
    private Date createdAt;

    public static InvoiceMessage fromInputStream(final InputStream xml)
            throws HarvestClientException
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(InvoiceMessage.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Source source = new StreamSource(xml);
            // We have to explicitly tell it what class we want, since we can't have two
            // classes annotated with @XmlRootElement("invoice_message")
            // This is due to a bug in the Harvest API for InvoiceMessages using same element
            // name for both the list and the items in it.
            return unmarshaller.unmarshal(source, InvoiceMessage.class).getValue();
        }
        catch (Exception e)
        {
            throw new HarvestClientException("Unable to parse XML into Invoice.", e);
        }

    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public Integer getInvoiceId()
    {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId)
    {
        this.invoiceId = invoiceId;
    }

    public boolean isSendMeACopy()
    {
        return sendMeACopy;
    }

    public void setSendMeACopy(boolean sendMeACopy)
    {
        this.sendMeACopy = sendMeACopy;
    }

    public String getSentBy()
    {
        return sentBy;
    }

    public void setSentBy(String sentBy)
    {
        this.sentBy = sentBy;
    }

    public String getSentByEmail()
    {
        return sentByEmail;
    }

    public void setSentByEmail(String sentByEmail)
    {
        this.sentByEmail = sentByEmail;
    }

    public String getFullRecipientList()
    {
        return fullRecipientList;
    }

    public void setFullRecipientList(String fullRecipientList)
    {
        this.fullRecipientList = fullRecipientList;
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
