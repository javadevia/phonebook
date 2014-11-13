package com.daxx.img.phonebook.service;

import com.daxx.img.phonebook.model.domain.Contact;

import java.util.List;

/**
 * This interface declare main operations with contacts
 *
 * User: iivanov
 */
public interface IContactService
{
    /**
     * This method finds all contact.
     * @return list of all contacts
     */
    List<Contact> getContacts();

    /**
     * This method finds contact by name.
     * @param contactName name of contact
     * @return list of contact with specified name
     */
    List<Contact> getContactByName(String contactName);

    /**
     * This method add contact.
     * @param newContact new contact which will be added.
     */
    void addContact(Contact newContact);

    /**
     * This method modify contact by id.
     * @param contact modified contact. Id of contact must be set.
     */
    void modifyContact(Contact contact);

    /**
     * This method removes contact by id.
     * @param contactId id of removed contact.
     */
    void removeContact(String contactId);
}
