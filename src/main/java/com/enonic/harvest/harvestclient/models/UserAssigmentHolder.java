package com.enonic.harvest.harvestclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jkc on 4/1/16.
 */
public class UserAssigmentHolder implements Holder<UserAssignment> {
    @JsonProperty("user_assignment")
    UserAssignment userAssignment;

    public UserAssignment getUserAssignment() {
        return userAssignment;
    }

    public void setUserAssignment(UserAssignment userAssignment) {
        this.userAssignment = userAssignment;
    }

    @Override
    public UserAssignment getEntity() {
        return userAssignment;
    }
}
