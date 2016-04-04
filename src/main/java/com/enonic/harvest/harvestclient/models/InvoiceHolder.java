package com.enonic.harvest.harvestclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jkc on 4/1/16.
 */
public class InvoiceHolder implements Holder<Invoice> {
    @JsonProperty("invoice")
    Invoice invoice;

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public Invoice getEntity() {
        return invoice;
    }
}
