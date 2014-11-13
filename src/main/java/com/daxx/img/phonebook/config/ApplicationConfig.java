package com.daxx.img.phonebook.config;

import com.mongodb.MongoClient;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;

/**
 * User: iivanov
 */

@Configuration
@ComponentScan({"com.daxx.img.phonebook.dao", "com.daxx.img.phonebook.service", "com.daxx.img.phonebook.util"})
@PropertySource("classpath:database.properties")
public class ApplicationConfig
{
    @Autowired
    Environment environment;

    @Bean
    public DozerBeanMapper dozerBeanMapper()
    {
        return new DozerBeanMapper();
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException
    {
        final String  host     = environment.getProperty("mongo.host");
        final Integer port     = Integer.valueOf(environment.getProperty("mongo.port"));
        final String  dbName   = environment.getProperty("mongo.db");
        final String  username = environment.getProperty("mongo.username");
        final String  password = environment.getProperty("mongo.password");

        UserCredentials userCredentials = new UserCredentials(username, password);

        return new SimpleMongoDbFactory(new MongoClient(host, port), dbName, userCredentials);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException
    {
        return new MongoTemplate(mongoDbFactory());
    }
}
