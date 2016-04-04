package com.enonic.harvest.harvestclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jkc on 4/1/16.
 */
public class InvoiceItemCategoryHolder implements Holder<InvoiceItemCategory> {
    @JsonProperty("invoice_category")
    InvoiceItemCategory invoiceItemCategory;

    public InvoiceItemCategory getInvoiceItemCategory() {
        return invoiceItemCategory;
    }

    public void setInvoiceItemCategory(InvoiceItemCategory invoiceItemCategory) {
        this.invoiceItemCategory = invoiceItemCategory;
    }

    @Override
    public InvoiceItemCategory getEntity() {
        return invoiceItemCategory;
    }
}
