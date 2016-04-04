package com.enonic.harvest.harvestclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jkc on 4/1/16.
 */
public class InvoicePaymentHolder implements Holder<InvoicePayment> {

    @JsonProperty("payment")
    InvoicePayment invoicePayment;

    public InvoicePayment getInvoicePayment() {
        return invoicePayment;
    }

    public void setInvoicePayment(InvoicePayment invoicePayment) {
        this.invoicePayment = invoicePayment;
    }

    @Override
    public InvoicePayment getEntity() {
        return invoicePayment;
    }
}
