package com.daxx.img.phonebook.util.mapper.impl;

import com.daxx.img.phonebook.util.mapper.IBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This mapper provide functionality for mapping from domain beans to DTO bean and and vice versa.
 * Current mapper uses Dozer framework.
 *
 * User: iivanov
 */

@Component
public class BeanMapper implements IBeanMapper
{
    @Autowired
    Mapper dozerBeanMapper;

    public <T> List<T> mapCollection(final Collection<?> source, final Class<T> destinationClass)
    {
        if (source != null)
        {
            final List<T> list = new ArrayList<T>(source.size());
            for (final Object item : source)
            {
                list.add(dozerBeanMapper.map(item, destinationClass));
            }
            return list;
        }

        return null;
    }

    public <T> T map(Object source, Class<T> destinationClass)
    {
        return dozerBeanMapper.map(source, destinationClass);
    }
}
