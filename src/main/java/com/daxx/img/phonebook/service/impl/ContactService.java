package com.daxx.img.phonebook.service.impl;

import com.daxx.img.phonebook.dao.IContactDao;
import com.daxx.img.phonebook.model.domain.Contact;
import com.daxx.img.phonebook.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: iivanov
 */
@Service
public class ContactService implements IContactService
{
    @Autowired
    IContactDao contactDao;


    @Override
    public List<Contact> getContacts()
    {
        return contactDao.getContacts();
    }

    @Override
    public List<Contact> getContactByName(String contactName)
    {
        return contactDao.getContactByName(contactName);
    }

    @Override
    public void addContact(Contact newContact)
    {
        contactDao.saveContact(newContact);
    }

    @Override
    public void modifyContact(Contact contact)
    {
        contactDao.modifyContact(contact);
    }

    @Override
    public void removeContact(String contactId)
    {
        contactDao.removeContact(contactId);
    }
}
