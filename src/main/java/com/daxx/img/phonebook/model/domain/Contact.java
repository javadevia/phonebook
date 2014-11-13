package com.daxx.img.phonebook.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * User: iivanov
 */

@Document(collection = Contact.COLLECTION_NAME)
public class Contact
{
    public static final String COLLECTION_NAME = "contacts";

    @Id
    private String id;
    private String name;
    private String address;
    private String localPhone;
    private String intPhone;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getLocalPhone()
    {
        return localPhone;
    }

    public void setLocalPhone(String localPhone)
    {
        this.localPhone = localPhone;
    }

    public String getIntPhone()
    {
        return intPhone;
    }

    public void setIntPhone(String intPhone)
    {
        this.intPhone = intPhone;
    }
}
