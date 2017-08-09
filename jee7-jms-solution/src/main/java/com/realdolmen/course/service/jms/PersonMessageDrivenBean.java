package com.realdolmen.course.service.jms;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.domain.PersonList;
import com.realdolmen.course.service.PersonServiceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.List;

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/rd/queues/RealDolmenQueue")
        }
)
public class PersonMessageDrivenBean implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @EJB
    PersonServiceBean personService;

    @Override
    public void onMessage(Message message) {

        try {
            PersonList personList = message.getBody(PersonList.class);
            personList.getPersons().forEach(p -> personService.save(p));
        } catch (JMSException e) {
            throw new RuntimeException("Unable to receive JMS message", e);
        }
    }
}
