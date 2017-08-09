package com.realdolmen.candyshop.interceptors;

import org.slf4j.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Created by cda5732 on 1/03/2017.
 */
@Interceptor
@ActivateTimer
public class MethodTimerInterceptor {
    @Inject
    private Logger logger;

    @AroundInvoke
    public Object timeMethod(InvocationContext ic) throws Exception {
        long start = System.nanoTime();
        try {
            return ic.proceed();
        } finally {
            long end = System.nanoTime();
            logger.info(ic.getMethod().getName() + " took " + (end - start) / 1_000_000.0 + "ms");
        }
    }
}
