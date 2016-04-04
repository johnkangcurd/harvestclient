package com.enonic.harvest.harvestclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jkc on 4/1/16.
 */
public class ClientHolder implements Holder<Client>{
    @JsonProperty("client")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getEntity() {
        return this.client;
    }
}
