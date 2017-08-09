package com.realdolmen.course.web.websockets;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

/**
 * Created by cda5732 on 19/05/2016.
 */
public class Resources {

    @Resource
    ManagedScheduledExecutorService ses;

    @Produces
    public ManagedScheduledExecutorService ses() {
        return ses;
    }
}
