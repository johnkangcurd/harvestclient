package com.enonic.harvest.harvestclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jkc on 4/1/16.
 */
public class InvoiceMessageHolder implements Holder<InvoiceMessage> {

    @JsonProperty("message")
    InvoiceMessage invoiceMessage;

    public InvoiceMessage getInvoiceMessage() {
        return invoiceMessage;
    }

    public void setInvoiceMessage(InvoiceMessage invoiceMessage) {
        this.invoiceMessage = invoiceMessage;
    }

    @Override
    public InvoiceMessage getEntity() {
        return invoiceMessage;
    }
}
