package com.realdolmen.candyshop.repositories;

import com.realdolmen.candyshop.domain.Candy;
import com.realdolmen.candyshop.domain.CandyColor;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class CandyRepository {
    @Inject
    Logger logger;

    public List<Candy> findAllCandy() {
        logger.info("Retrieving all candy");
        return Collections.emptyList();
    }

    public List<Candy> findCandyByColor(CandyColor color) {
        logger.info("Retrieving candy by color " + color);
        return Collections.emptyList();
    }
}
