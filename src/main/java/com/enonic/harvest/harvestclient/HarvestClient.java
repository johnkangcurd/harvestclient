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

    User getUser(int id)
            throws HarvestClientException;

    List<Client> getClients()
            throws HarvestClientException;

    List<Client> getClients(Date updatedSince)
            throws HarvestClientException;

    Client getClient(int id)
            throws HarvestClientException;

    List<DayEntry> getDayEntriesByUser(GetDayEntriesByUserParameters params)
            throws HarvestClientException;

    List<DayEntry> getDayEntriesByProject(GetDayEntriesByProjectParameters params)
            throws HarvestClientException;

    List<Project> getProjects()
            throws HarvestClientException;

    List<Project> getProjects(Date updatedSince)
            throws HarvestClientException;

    List<Project> getProjects(int clientId)
            throws HarvestClientException;

    List<Project> getProjects(int clientId, Date updatedSince)
            throws HarvestClientException;

    Project getProject(int id)
            throws HarvestClientException;

    List<Task> getTasks()
            throws HarvestClientException;

    List<Task> getTasks(Date updatedSince)
            throws HarvestClientException;

    Task getTask(int id)
            throws HarvestClientException;

    List<UserAssignment> getUserAssignments(int projectId)
            throws HarvestClientException;

    List<UserAssignment> getUserAssignments(int projectId, Date updatedSince)
            throws HarvestClientException;

    List<TaskAssignment> getTaskAssignments(int projectId)
            throws HarvestClientException;

    List<TaskAssignment> getTaskAssignments(int projectId, Date updatedSince)
            throws HarvestClientException;

    List<Invoice> getRecentInvoices(GetRecentInvoicesParameters params)
            throws HarvestClientException;

    Invoice getInvoice(int id)
            throws HarvestClientException;

    List<InvoiceItemCategory> getInvoiceItemCategories()
            throws  HarvestClientException;

    List<InvoiceMessage> getInvoiceMessages(int invoiceId)
            throws HarvestClientException;

    InvoiceMessage getInvoiceMessage(int invoiceId, int id)
            throws  HarvestClientException;

    List<InvoicePayment> getInvoicePayments(int invoiceId)
            throws HarvestClientException;

    InvoicePayment getInvoicePayment(int invoiceId, int id)
            throws HarvestClientException;
}
