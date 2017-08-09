package com.realdolmen.course.web.websockets;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.service.PersonServiceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

// TODO Add a PersonDecoder here
@ServerEndpoint("/persons")
public class PersonServer {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    PersonServiceBean personServiceBean;

    // TODO Receive Person objects instead of String, but make sure to return "success" or "failure"
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
