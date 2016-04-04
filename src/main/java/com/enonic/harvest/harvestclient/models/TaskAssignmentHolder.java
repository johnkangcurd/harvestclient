package com.enonic.harvest.harvestclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jkc on 4/1/16.
 */
public class TaskAssignmentHolder implements Holder<TaskAssignment> {

    @JsonProperty("task_assignment")
    TaskAssignment taskAssignment;

    public TaskAssignment getTaskAssignment() {
        return taskAssignment;
    }

    public void setTaskAssignment(TaskAssignment taskAssignment) {
        this.taskAssignment = taskAssignment;
    }

    @Override
    public TaskAssignment getEntity() {
        return taskAssignment;
    }
}
