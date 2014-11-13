package com.daxx.img.phonebook.dao.impl;

import com.daxx.img.phonebook.dao.IContactDao;
import com.daxx.img.phonebook.model.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: iivanov
 */

@Repository
public class ContactDao implements IContactDao
{
    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void saveContact(Contact contact) {
        mongoOperations.insert(contact);
    }

    @Override
    public List<Contact> getContactByName(String name) {
        final Query query = Query.query(Criteria.where("name").is(name));
        return mongoOperations.find(query, Contact.class);
    }

    @Override
    public List<Contact> getContacts() {
        return mongoOperations.findAll(Contact.class);
    }

    @Override
    public void removeContact(String id) {
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)), Contact.class);
    }

    @Override
    public void modifyContact(Contact contact)
    {
        final Query  query = new Query(Criteria.where("id").is(contact.getId()));
        final Update update = Update.update("name", contact.getName())
                                  .set("address", contact.getAddress())
                                  .set("localPhone", contact.getLocalPhone())
                                  .set("intPhone", contact.getIntPhone());
        mongoOperations.updateFirst(query, update, Contact.class);
    }
}
