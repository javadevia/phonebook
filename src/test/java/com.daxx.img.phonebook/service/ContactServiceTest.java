package com.daxx.img.phonebook.service;

import com.daxx.img.phonebook.dao.IContactDao;
import com.daxx.img.phonebook.model.domain.Contact;
import com.daxx.img.phonebook.service.impl.ContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * User: iivanov
 */

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest
{
    @Mock
    IContactDao contactDao;

    @InjectMocks
    IContactService contactService = new ContactService();

    @Test
    public void testAddContact()
    {
        final String contactName = "Vasya";

        final Contact contact = new Contact();

        contact.setId("1");
        contact.setName(contactName);
        contact.setAddress("Address");
        contact.setLocalPhone("056");
        contact.setIntPhone("380");

        final List<Contact> expectedContactList = new ArrayList<Contact>();
        expectedContactList.add(contact);

        when(contactDao.getContactByName(eq(contactName))).thenReturn(expectedContactList);

        contactService.addContact(contact);
        final List<Contact> contactsResult = contactService.getContactByName(contactName);

        assertEquals(expectedContactList, contactsResult);
        Mockito.verify(contactDao, times(1)).saveContact(any(Contact.class));
        Mockito.verify(contactDao, times(1)).getContactByName(contactName);
    }

}
