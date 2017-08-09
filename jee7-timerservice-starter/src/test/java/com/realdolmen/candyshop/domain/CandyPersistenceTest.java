package com.realdolmen.candyshop.domain;


import com.realdolmen.candyshop.AbstractPersistenceTest;
import com.realdolmen.candyshop.util.UserUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CandyPersistenceTest extends AbstractPersistenceTest {
    @Test
    public void candyCanBePersisted() throws Exception {
        Candy c = new MnM();
        c.setColor(CandyColor.VIOLET);
        em.persist(c);
        assertNotNull(c.getId());
    }

    @Test
    public void candyCanBeLoaded() throws Exception {
        Candy c = em.find(Candy.class, 1000L);
        assertEquals(CandyColor.RED, c.getColor());
    }

    @Test
    public void candyIsPolymorphic() throws Exception {
        Candy candy = em.find(Candy.class, 1000L);
        assertTrue(candy instanceof MnM);
    }

    @Test
    public void userCreatedIsAutomaticallyFilledIn() throws Exception {
        Candy c = new GummyBears();
        c.setName("Dummy Gummy");
        em.persist(c);
        flushAndClear();

        Candy pc = em.find(Candy.class, c.getId());
        assertEquals(UserUtils.currentUser(), pc.getUserCreated());
    }

    @Test
    public void userModifiedIsAutomaticallyFilledIn() throws Exception {
        Candy c = em.find(Candy.class, 2000L);
        c.setName("Gummy Dummy");
        flushAndClear();
        Candy pc = em.find(Candy.class, c.getId());
        assertEquals(UserUtils.currentUser(), pc.getUserModified());
    }
}
