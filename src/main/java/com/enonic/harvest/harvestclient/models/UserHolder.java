package com.enonic.harvest.harvestclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jkc on 4/1/16.
 */
public class UserHolder implements Holder<User>{
    @JsonProperty("user")
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getEntity() {
        return this.user;
    }
}
