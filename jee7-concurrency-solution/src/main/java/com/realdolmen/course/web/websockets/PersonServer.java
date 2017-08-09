package com.realdolmen.course.web.websockets;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.service.PersonServiceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.TimeUnit;

/**
 * Created by cda5732 on 29/04/2016.
 */
@ServerEndpoint(value = "/persons", decoders = PersonDecoder.class)
public class PersonServer {
    @Inject
    PersonServiceBean personServiceBean;

    @Inject
    ManagedScheduledExecutorService ses;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @OnMessage
    public void receive(Person person, Session session) {
        logger.info("Received fullName " + person.getFirstName() + " " + person.getLastName() + " " + ses);

        ses.schedule(() -> {
            try {
                personServiceBean.save(person);
                session.getBasicRemote().sendText("success");
            } catch (Exception e) {
                logger.error("Error in saving Person and returning result");
            }

        }, 30, TimeUnit.SECONDS);

    }

}
