package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.domain.Person;
import org.slf4j.Logger;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by cda5732 on 1/03/2017.
 */
@Singleton
public class NotificationService {
    @Resource
    TimerService timerService;

    @Inject
    Logger logger;

    @Inject
    PersonService personService;

    public void scheduleNotification(Person person) {
        timerService.createTimer(5000, person.getId());
    }

    @Timeout
    public void printNotification(Timer timer) {
        Long id = (Long) timer.getInfo();
        Person person = personService.findPersonById(id);
        if (person != null) {
            logger.info(String.format("Person %s %s registered 5 seconds ago!", person.getFirstName(), person.getLastName()));
        } else {
            logger.info("Registered person is no longer available...");
        }
    }
}
