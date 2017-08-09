package com.realdolmen.course.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by cda5732 on 18/05/2016.
 */
@Named
public class PersonWriter extends AbstractItemWriter {
    public Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    EntityManager em;

    @Override
    public void writeItems(List<Object> list) throws Exception {
        logger.info("Saving " + list.size() + " persons");
        list.stream().forEach(p -> em.persist(p));
    }
}
