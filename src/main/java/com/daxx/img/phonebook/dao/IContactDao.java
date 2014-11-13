package com.daxx.img.phonebook.dao;

import com.daxx.img.phonebook.model.domain.Contact;

import java.util.List;

/**
 * User: iivanov
 */
public interface IContactDao
{
    void saveContact(Contact contact);

    List<Contact> getContactByName(String name);

    List<Contact> getContacts();

    void removeContact(String id);

    void modifyContact(Contact contact);
}
