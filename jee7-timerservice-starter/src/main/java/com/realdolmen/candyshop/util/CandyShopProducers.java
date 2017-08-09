package com.realdolmen.candyshop.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.TimerService;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Timer;

public class CandyShopProducers {

    @PersistenceContext
    EntityManager em;

    @Produces
    public Logger logger(InjectionPoint ip) {
        return LoggerFactory.getLogger(ip.getMember().getDeclaringClass());
    }

    @Produces
    public EntityManager entityManager() {
        return em;
    }


}
