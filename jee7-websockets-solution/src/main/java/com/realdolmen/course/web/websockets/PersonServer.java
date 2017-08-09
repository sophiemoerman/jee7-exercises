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
@ServerEndpoint("/persons")
public class PersonServer {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    PersonServiceBean personServiceBean;

    @OnMessage
    public String receive(String fullName) {
        logger.info("Received fullName " + fullName);
        if (fullName != null && !fullName.trim().isEmpty()) {
            String[] split = fullName.split(" ");
            if(split.length == 2) {
                Person person = new Person(split[0], split[1]);
                personServiceBean.save(person);
                return "success";
            }
        }
        return "failure";
    }

}
