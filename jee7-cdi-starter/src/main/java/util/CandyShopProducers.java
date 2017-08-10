package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;


/**
 * Created by SMRBD45 on 10/08/2017.
 */
@ApplicationScoped
public class CandyShopProducers {
    @Produces
    public Logger logger(InjectionPoint ip){
        return LoggerFactory.getLogger(ip.getMember().getDeclaringClass().getName());
    }
}
