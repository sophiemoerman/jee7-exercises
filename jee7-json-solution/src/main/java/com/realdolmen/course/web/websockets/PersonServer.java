package com.realdolmen.course.web.websockets;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.service.PersonServiceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by cda5732 on 29/04/2016.
 */
@ServerEndpoint(value = "/persons", decoders = PersonDecoder.class)
public class PersonServer {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    PersonServiceBean personServiceBean;

    @OnMessage
    public String receive(Person person) {
        logger.info("Received fullName " + person.getFirstName() + " " + person.getLastName());
        try {
            personServiceBean.save(person);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

}
