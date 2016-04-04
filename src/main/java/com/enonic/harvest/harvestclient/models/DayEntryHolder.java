package com.enonic.harvest.harvestclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jkc on 4/1/16.
 */
public class DayEntryHolder implements Holder<DayEntry> {
    @JsonProperty("day_entry")
    DayEntry dayEntry;

    public DayEntry getDayEntry() {
        return dayEntry;
    }

    public void setDayEntry(DayEntry dayEntry) {
        this.dayEntry = dayEntry;
    }

    @Override
    public DayEntry getEntity() {
        return dayEntry;
    }
}
