package com.daxx.img.phonebook.model.dto;

/**
 * User: iivanov
 */
public class ContactDto
{
    private String   id;
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
