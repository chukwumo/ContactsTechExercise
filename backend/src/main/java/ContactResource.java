import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

import dao.ContactDao;
import dao.ContactDaoImpl;
import model.CallListEntry;
import model.Contact;

@Path("/contacts")
public class ContactResource {

    private final ContactDao contactDao;

    public ContactResource() {
        contactDao = new ContactDaoImpl();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContacts() {
        List<Contact> contacts = contactDao.getContacts();
        return Response.ok().entity(contacts).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createContact(@Valid Contact contact) {
        contactDao.insertOrUpdateContact(contact, null);
        return Response.ok().entity(contact).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateContact(@PathParam("id") Long id, @Valid Contact contact) {
        contactDao.insertOrUpdateContact(contact, id);
        return Response.ok().entity(contact).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContact(@PathParam("id") Long id) {
        Contact contact = contactDao.getContact(id);
        return Response.ok().entity(contact).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteContact(@PathParam("id") Long id) {
        contactDao.deleteContact(id);
        return Response.ok().build();
    }

    @GET
    @Path("/call-list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCallList() {
        List<CallListEntry> callList = contactDao.getCallList();
        return Response.ok().entity(callList).build();
    }
}
