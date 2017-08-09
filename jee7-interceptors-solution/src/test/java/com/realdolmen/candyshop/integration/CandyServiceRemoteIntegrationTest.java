package com.realdolmen.candyshop.integration;

import com.realdolmen.candyshop.AbstractRemoteIntegrationTest;
import com.realdolmen.candyshop.domain.Candy;
import com.realdolmen.candyshop.domain.CandyColor;
import com.realdolmen.candyshop.services.CandyServiceRemote;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.naming.NamingException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by cda5732 on 1/03/2017.
 */
public class CandyServiceRemoteIntegrationTest extends AbstractRemoteIntegrationTest {

    private static CandyServiceRemote candyService;

    @BeforeClass
    public static void init() throws NamingException {
        candyService = lookup("jee7-interceptors-solution/CandyService!com.realdolmen.candyshop.services.CandyServiceRemote");
    }

    @Test
    public void shouldFindAllCandy() {
        List<Candy> candies = candyService.findAllCandy();
        assertEquals(6, candies.size());
    }

    @Test
    public void shouldFindCandyByColor() {
        List<Candy> candies = candyService.findCandyByColor(CandyColor.BLUE);
        assertEquals(1, candies.size());
    }

}
