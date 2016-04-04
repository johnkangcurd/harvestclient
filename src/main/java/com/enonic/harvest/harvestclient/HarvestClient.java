package com.enonic.harvest.harvestclient;

import com.enonic.harvest.harvestclient.exceptions.HarvestClientException;
import com.enonic.harvest.harvestclient.parameters.GetDayEntriesByProjectParameters;
import com.enonic.harvest.harvestclient.parameters.GetDayEntriesByUserParameters;
import com.enonic.harvest.harvestclient.parameters.GetRecentInvoicesParameters;
import com.enonic.harvest.harvestclient.models.*;

import java.util.Date;
import java.util.List;

public interface HarvestClient
{
    List<User> getUsers()
            throws HarvestClientException;

    List<User> getUsers(Date updatedSince)
            throws HarvestClientException;

    User getUser(long id)
            throws HarvestClientException;

    List<Client> getClients()
            throws HarvestClientException;

    List<Client> getClients(Date updatedSince)
            throws HarvestClientException;

    Client getClient(long id)
            throws HarvestClientException;

    List<DayEntry> getDayEntriesByUser(GetDayEntriesByUserParameters params)
            throws HarvestClientException;

    List<DayEntry> getDayEntriesByProject(GetDayEntriesByProjectParameters params)
            throws HarvestClientException;

    List<Project> getProjects()
            throws HarvestClientException;

    List<Project> getProjects(Date updatedSince)
            throws HarvestClientException;

    List<Project> getProjects(long clientId)
            throws HarvestClientException;

    List<Project> getProjects(long clientId, Date updatedSince)
            throws HarvestClientException;

    Project getProject(long id)
            throws HarvestClientException;

    List<Task> getTasks()
            throws HarvestClientException;

    List<Task> getTasks(Date updatedSince)
            throws HarvestClientException;

    Task getTask(long id)
            throws HarvestClientException;

    List<UserAssignment> getUserAssignments(long projectId)
            throws HarvestClientException;

    List<UserAssignment> getUserAssignments(long projectId, Date updatedSince)
            throws HarvestClientException;

    List<TaskAssignment> getTaskAssignments(long projectId)
            throws HarvestClientException;

    List<TaskAssignment> getTaskAssignments(long projectId, Date updatedSince)
            throws HarvestClientException;

    List<Invoice> getRecentInvoices(GetRecentInvoicesParameters params)
            throws HarvestClientException;

    Invoice getInvoice(long id)
            throws HarvestClientException;

    List<InvoiceItemCategory> getInvoiceItemCategories()
            throws  HarvestClientException;

    List<InvoiceMessage> getInvoiceMessages(long invoiceId)
            throws HarvestClientException;

    InvoiceMessage getInvoiceMessage(long invoiceId, long id)
            throws  HarvestClientException;

    List<InvoicePayment> getInvoicePayments(long invoiceId)
            throws HarvestClientException;

    InvoicePayment getInvoicePayment(long invoiceId, long id)
            throws HarvestClientException;
}
