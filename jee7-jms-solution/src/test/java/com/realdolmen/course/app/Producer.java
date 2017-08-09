package com.realdolmen.course.app;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.domain.PersonList;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Date;
import java.util.Hashtable;

/**
 * Created by cda5732 on 29/04/2016.
 */
public class Producer {
    public static void main(String[] args) {
        try {
            Context jndiContext = getInitialContext();

            ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/RemoteConnectionFactory");
            Queue queue = (Queue) jndiContext.lookup("rd/queues/RealDolmenQueue");
            // Sends a text message to the queue
            try (JMSContext context = connectionFactory.createContext("administrator", "Azerty123!")) {
                PersonList personList = new PersonList();
                personList.addPerson(new Person("Benny", "Slim"));
                context.createProducer().send(queue, personList);
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private static Context getInitialContext() throws NamingException {
        // Gets the JNDI context
        Hashtable<String, Object> properties = new Hashtable<>();
        properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        properties.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
        properties.put("jboss.naming.client.ejb.context", true);
        return new InitialContext(properties);
    }
}
