package com.realdolmen.course.service.jms;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.domain.PersonList;
import com.realdolmen.course.utilities.integration.RemoteJmsTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.jms.*;

public class PersonMessageDrivenBeanTest extends RemoteJmsTest {

    protected JMSContext jmsContext;
    protected JMSProducer producer;
    protected Queue queue;

    @Before
    public void initializeJms() throws Exception {
        ConnectionFactory connectionFactory = lookup("jms/RemoteConnectionFactory");

        queue = lookup("rd/queues/RealDolmenQueue");


        jmsContext = connectionFactory.createContext("administrator", "Azerty123!");

        producer = jmsContext.createProducer();
    }

    @After
    public void destroyJms() throws JMSException {
        if (jmsContext != null) {
            jmsContext.close();
        }
    }

    @Test
    public void shouldSendMultiplePersonsMessage() throws JMSException {
        PersonList personList = new PersonList();
        personList.addPerson(new Person("Theo", "Tester"));
        personList.addPerson(new Person("Benny", "Slim"));
        producer.send(queue, personList);
        assertPatiently(() -> assertEquals(4, count(Person.class)));
    }
}
