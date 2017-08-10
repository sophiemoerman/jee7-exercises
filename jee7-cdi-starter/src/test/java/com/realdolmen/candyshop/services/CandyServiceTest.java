package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.AbstractWeldContainerTest;
import org.junit.Before;
import org.junit.Test;
import services.CandyService;

import static org.junit.Assert.assertNotNull;

public class CandyServiceTest extends AbstractWeldContainerTest {
    private CandyService candyService;

    @Before
    public void initialize() {
        candyService = container.instance().select(CandyService.class).get();
    }

    @Test
    public void candyServiceHasCandyRepository() throws Exception {
        assertNotNull(candyService);
        candyService.findAllCandy();
        assertNotNull(candyService.getCandyRepository());
    }

    @Test
    public void candyServiceHasPersonService() throws Exception {
        assertNotNull(candyService);
        assertNotNull(candyService.getPersonService());
    }
}
