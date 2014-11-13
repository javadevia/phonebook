package com.daxx.img.phonebook.util.mapper;

import java.util.Collection;
import java.util.List;

/**
 * User: iivanov
 */
public interface IBeanMapper
{
    <T> List<T> mapCollection(final Collection<?> source, final Class<T> destinationClass);

    <T> T map(Object source, Class<T> destinationClass);
}
