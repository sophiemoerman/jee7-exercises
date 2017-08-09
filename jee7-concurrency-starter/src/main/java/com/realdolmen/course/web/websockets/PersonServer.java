package com.realdolmen.course.web.websockets;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.service.PersonServiceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by cda5732 on 29/04/2016.
 */
@ServerEndpoint(value = "/persons", decoders = PersonDecoder.class)
public class PersonServer {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    PersonServiceBean personServiceBean;

    // TODO Inject the `ManagedScheduledExecutorService`

    @OnMessage
    public void receive(Person person, Session session) {
        logger.info("Received fullName " + person.getFirstName() + " " + person.getLastName());

        // TODO Schedule the save operation to happen after 30 seconds
        try {
            personServiceBean.save(person);
            session.getBasicRemote().sendText("success");
        } catch (Exception e) {
            logger.error("Error in saving Person and return result");
        }

    }

}
