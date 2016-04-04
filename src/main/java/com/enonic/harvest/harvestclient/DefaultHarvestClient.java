package com.enonic.harvest.harvestclient;

import com.enonic.harvest.harvestclient.exceptions.HarvestClientException;
import com.enonic.harvest.harvestclient.exceptions.MissingParameterException;
import com.enonic.harvest.harvestclient.models.*;
import com.enonic.harvest.harvestclient.models.Client;
import com.enonic.harvest.harvestclient.parameters.GetDayEntriesByProjectParameters;
import com.enonic.harvest.harvestclient.parameters.GetDayEntriesByUserParameters;
import com.enonic.harvest.harvestclient.parameters.GetRecentInvoicesParameters;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

class DefaultHarvestClient
        implements HarvestClient
{
    private String username;
    private String password;
    private String subDomain;

    private SimpleDateFormat dateFormatter     = new SimpleDateFormat("yyyyMMdd");
    private SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");

    public DefaultHarvestClient(String username, String password, String subDomain)
    {
        this.username = username;
        this.password = password;
        this.subDomain = subDomain;
    }

    public List<User> getUsers()
            throws HarvestClientException
    {
        final UriBuilder builder = UriBuilder.fromUri(getBaseUrl())
                .path("people");
        URI uri = builder.build();
        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<UserHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<User> getUsers(Date updatedSince)
            throws HarvestClientException
    {
        final UriBuilder builder = UriBuilder.fromUri(getBaseUrl())
                .path("people")
                .queryParam("updated_since", encodeDate(updatedSince, "utf-8"));
        URI uri = builder.build();
        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<UserHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    public User getUser(long id)
            throws HarvestClientException
    {
        final UriBuilder builder = UriBuilder.fromUri(getBaseUrl())
                .path("people/{userId}");
        URI uri = builder.build(id);
        Response response = this.requestData(uri);
        return response.readEntity(User.class);
    }

    public List<Client> getClients()
            throws HarvestClientException
    {
        final UriBuilder builder = UriBuilder.fromUri(getBaseUrl())

                .path("clients");
        URI uri = builder.build();
        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<ClientHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    private <T> List<T> extractListFromHolderList(List<Holder> holderList){
        List<T> list = new ArrayList<>();
        for(Holder h : holderList){
            list.add((T) h.getEntity());
        }
        return list;
    }

    public List<Client> getClients(Date updatedSince)
            throws HarvestClientException
    {
        final UriBuilder builder = UriBuilder.fromUri(getBaseUrl())
                .path("clients")
                .queryParam("updated_since", encodeDate(updatedSince, "utf-8"));
        URI uri = builder.build();
        System.out.println(uri.toString());
        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<ClientHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    public Client getClient(long id)
            throws HarvestClientException
    {
        final UriBuilder builder = UriBuilder.fromUri(getBaseUrl())
                .path("clients/{clientId}");
        URI uri = builder.build(id);
        Response response = this.requestData(uri);
        return response.readEntity(Client.class);
    }

    public List<DayEntry> getDayEntriesByUser(GetDayEntriesByUserParameters params)
            throws HarvestClientException
    {
        if (params.fromDate == null)
            throw new MissingParameterException("fromDate");
        if (params.toDate == null)
            throw new MissingParameterException("toDate");
        if (params.userId == null)
            throw new MissingParameterException("userId");

        final UriBuilder builder = UriBuilder.fromUri(getBaseUrl())
                .path("people/{userId}/entries")
                .queryParam("from", this.dateFormatter.format(params.fromDate))
                .queryParam("to", this.dateFormatter.format(params.toDate));

        if (params.updatedSince != null)
        {
            builder.queryParam("updated_since", this.dateFormatter.format(params.updatedSince));
        }
        URI uri = builder.build(params.userId);
        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<DayEntryHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<DayEntry> getDayEntriesByProject(GetDayEntriesByProjectParameters params)
            throws HarvestClientException
    {
        if (params.fromDate == null)
            throw new MissingParameterException("fromDate");
        if (params.toDate == null)
            throw new MissingParameterException("toDate");
        if (params.projectId == null)
            throw new MissingParameterException("projectId");

        final UriBuilder builder = UriBuilder.fromUri(getBaseUrl())
                .path("projects/{projectId}/entries")
                .queryParam("from", this.dateFormatter.format(params.fromDate))
                .queryParam("to", this.dateFormatter.format(params.toDate));

        if (params.updatedSince != null)
        {
            builder.queryParam("updated_since", this.dateTimeFormatter.format(params.updatedSince));
        }

        URI uri = builder.build(params.projectId);
        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<DayEntryHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Project> getProjects()
            throws HarvestClientException
    {
        final UriBuilder builder = UriBuilder.fromUri(getBaseUrl())

                .path("projects");
        URI uri = builder.build();
        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<ProjectHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Project> getProjects(Date updatedSince)
            throws HarvestClientException
    {
        final UriBuilder builder = UriBuilder.fromUri(getBaseUrl())
                .path("projects")
                .queryParam("updated_since", encodeDate(updatedSince, "utf-8"));
        URI uri = builder.build();

        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<ProjectHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Project> getProjects(long clientId)
            throws HarvestClientException
    {
        final UriBuilder builder = UriBuilder.fromUri(getBaseUrl())
                .path("projects")
                .queryParam("client", clientId);
        URI uri = builder.build();

        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<ProjectHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Project> getProjects(long clientId, Date updatedSince)
            throws HarvestClientException
    {
        final UriBuilder builder = UriBuilder.fromUri(getBaseUrl())
                .path("projects")
                .queryParam("client", clientId)
                .queryParam("updated_since", encodeDate(updatedSince, "utf-8"));
        URI uri = builder.build();

        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<ProjectHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));

    }

    public Project getProject(long id)
            throws HarvestClientException
    {
        final UriBuilder builder = UriBuilder.fromUri(getBaseUrl())

                .path("projects/{projectId}");
        URI uri = builder.build(id);
        Response response = this.requestData(uri);
        return response.readEntity(Project.class);
    }

    public List<UserAssignment> getUserAssignments(long projectId)
            throws HarvestClientException
    {
        final UriBuilder builder = UriBuilder.fromUri(getBaseUrl())

                .path("projects/{projectId}/user_assignments");
        URI uri = builder.build(projectId);
        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<UserAssigmentHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<UserAssignment> getUserAssignments(long projectId, Date updatedSince)
            throws HarvestClientException
    {
        final UriBuilder builder = UriBuilder.fromUri(getBaseUrl())

                .path("projects/{projectId}/user_assignments");
        builder.queryParam("updated_since", encodeDate(updatedSince, "utf-8"));
        URI uri = builder.build(projectId);
        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<UserAssigmentHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Task> getTasks()
            throws HarvestClientException
    {
        final UriBuilder builder = UriBuilder.fromUri(getBaseUrl())

                .path("tasks");
        URI uri = builder.build();
        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<TaskHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Task> getTasks(Date updatedSince)
            throws HarvestClientException
    {
        final UriBuilder builder = UriBuilder.fromUri(getBaseUrl())

                .path("tasks")
                .queryParam("updated_since", encodeDate(updatedSince, "utf-8"));
        URI uri = builder.build();
        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<TaskHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    public Task getTask(long id)
            throws HarvestClientException
    {
        final UriBuilder builder = UriBuilder.fromUri(getBaseUrl())

                .path("tasks/{taskId}");
        URI uri = builder.build(id);
        Response response = this.requestData(uri);
        return response.readEntity(Task.class);
    }

    public List<TaskAssignment> getTaskAssignments(long projectId)
            throws HarvestClientException
    {
        UriBuilder builder = UriBuilder.fromUri(getBaseUrl())

                .path("projects/{projectId}/task_assignments");
        URI uri = builder.build(projectId);
        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<TaskAssignmentHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<TaskAssignment> getTaskAssignments(long projectId, Date updatedSince)
            throws HarvestClientException
    {
        UriBuilder builder = UriBuilder.fromUri(getBaseUrl())

                .path("projects/{projectId}/task_assignments")
                .queryParam("updated_since", encodeDate(updatedSince, "utf-8"));

        URI uri = builder.build(projectId);
        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<TaskAssignmentHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Invoice> getRecentInvoices(GetRecentInvoicesParameters params)
            throws HarvestClientException
    {
        UriBuilder builder = UriBuilder.fromUri(getBaseUrl())
                .path("invoices");

        if (params.page != null)
            builder.queryParam("page", params.page.toString());
        if (params.fromDate != null)
            builder.queryParam("from", this.dateFormatter.format(params.fromDate));
        if (params.toDate != null)
            builder.queryParam("to", this.dateFormatter.format(params.toDate));
        if (params.updatedSince != null)
            builder.queryParam("updated_since", this.dateFormatter.format(params.updatedSince));
        if (params.status != null)
            builder.queryParam("status", params.status);
        if (params.client != null)
            builder.queryParam("client", params.client.toString());

        URI uri = builder.build();
        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<InvoiceHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    public Invoice getInvoice(long id)
            throws HarvestClientException
    {
        UriBuilder builder = UriBuilder.fromUri(getBaseUrl())

                .path("invoices/{invoiceId}");
        URI uri = builder.build(id);

        Response response = this.requestData(uri);
        return response.readEntity(Invoice.class);
    }

    public List<InvoiceItemCategory> getInvoiceItemCategories()
            throws HarvestClientException
    {
        UriBuilder builder = UriBuilder.fromUri(getBaseUrl())

                .path("invoice_item_categories");
        URI uri = builder.build();
        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<InvoiceItemCategoryHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<InvoiceMessage> getInvoiceMessages(long invoiceId)
            throws HarvestClientException
    {
        UriBuilder builder = UriBuilder.fromUri(getBaseUrl())

                .path("invoices/{invoiceId}/messages");
        URI uri = builder.build(invoiceId);
        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<InvoiceMessageHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    public InvoiceMessage getInvoiceMessage(long invoiceId, long id)
            throws  HarvestClientException
    {
        UriBuilder builder = UriBuilder.fromUri(getBaseUrl())

                .path("invoices/{invoiceId}/messages/{messageId}");
        URI uri = builder.build(invoiceId, id);
        Response response = this.requestData(uri);
        return response.readEntity(InvoiceMessage.class);
    }

    public List<InvoicePayment> getInvoicePayments(long invoiceId)
            throws HarvestClientException
    {
        UriBuilder builder = UriBuilder.fromUri(getBaseUrl())

                .path("invoices/{invoiceId}/payments");
        URI uri = builder.build(invoiceId);
        Response response = this.requestData(uri);
        return response.readEntity(new GenericType<List<InvoicePaymentHolder>>(){}).stream().map(Holder :: getEntity).collect(Collectors.toCollection(ArrayList::new));
    }

    public InvoicePayment getInvoicePayment(long invoiceId, long id)
            throws HarvestClientException
    {
        UriBuilder builder = UriBuilder.fromUri(getBaseUrl())

                .path("invoices/{invoiceId}/payments/{paymentId}");
        URI uri = builder.build(invoiceId, id);
        Response response = this.requestData(uri);
        return response.readEntity(InvoicePayment.class);
    }

    private Response requestData(URI uri)
            throws HarvestClientException
    {
        final javax.ws.rs.client.Client client = ClientBuilder.newClient();
        final WebTarget webTarget = client.target(uri);
        final Invocation.Builder request = webTarget.request(MediaType.APPLICATION_JSON)
            .header("Authorization", getAuthenticationHeader());
        return request.get();
    }

    private String getBaseUrl(){
        return  "https://"+getSubDomain()+".harvestapp.com/";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubDomain() {
        return subDomain;
    }

    public void setSubDomain(String subDomain) {
        this.subDomain = subDomain;
    }

    private String getAuthenticationHeader() {
        String credentials = this.getUsername() + ":" + this.getPassword();
        return "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());
    }

    private String encodeDate(Date dateToEncode, String encoding){
        String encodedDate;
        try
        {
            encodedDate = URLEncoder.encode(this.dateTimeFormatter.format(dateToEncode), encoding);
        }
        catch (UnsupportedEncodingException e)
        {
            throw new HarvestClientException("Unsupported encoding.", e);
        }
        return encodedDate;
    }
}
