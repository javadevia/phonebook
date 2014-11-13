package com.daxx.img.phonebook.web.rest;

import com.daxx.img.phonebook.model.domain.Contact;
import com.daxx.img.phonebook.model.dto.ContactDto;
import com.daxx.img.phonebook.service.IContactService;
import com.daxx.img.phonebook.util.mapper.IBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * User: iivanov
 */

@Path("/contacts")
@Component
public class ContactResource
{
    @Autowired
    IBeanMapper beanMapper;

    @Autowired
    IContactService contactService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ContactDto> getContacts()
    {
        final List<Contact> contacts = contactService.getContacts();
        final List<ContactDto> contactDtos = beanMapper.mapCollection(contacts, ContactDto.class);

        return contactDtos;
    }

    @GET
    @Path("/name/{contactName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ContactDto> getContactByName(@PathParam("contactName") String contactName)
    {
        final List<Contact> contacts = contactService.getContactByName(contactName);
        final List<ContactDto> contactDtos = beanMapper.mapCollection(contacts, ContactDto.class);

        return contactDtos;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addContact(ContactDto newContactDto)
    {
        final Contact newContact = beanMapper.map(newContactDto, Contact.class);
        contactService.addContact(newContact);

        return Response.ok("Contact was added").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modifyContact(ContactDto contactDto)
    {
        final Contact contact = beanMapper.map(contactDto, Contact.class);
        contactService.modifyContact(contact);

        return Response.ok("Contact was updated if one exists").build();
    }

    @DELETE
    @Path("/{contactId}")
    public Response removeContact(@PathParam("contactId") String contactId)
    {
        contactService.removeContact(contactId);

        return Response.ok("Contact was removed if one exists").build();
    }
}
