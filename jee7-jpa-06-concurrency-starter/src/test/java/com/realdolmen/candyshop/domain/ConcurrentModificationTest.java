package com.realdolmen.candyshop.domain;

import org.junit.Test;

import javax.persistence.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ConcurrentModificationTest {
    @Test
    public void concurrentModificationOfPersonIsRejected() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CandyShopPersistenceUnit");

        EntityManager em1 = emf.createEntityManager();
        em1.getTransaction().begin();

        EntityManager em2 = emf.createEntityManager();
        em2.getTransaction().begin();

        Person p1 = em1.find(Person.class, 1000L);
        Person p2 = em2.find(Person.class, 1000L);

        p1.setFirstName("Janis");
        p2.setFirstName("June");

        em1.persist(p1);
        em1.getTransaction().commit();

        persistAndExpectOptimisticLockingException(em2, p2);
    }

    private void persistAndExpectOptimisticLockingException(EntityManager em, Object o) {
        try {
            em.persist(o);
            em.getTransaction().commit();
            fail("Optimistic locking exception expected but was not thrown");
        } catch (RollbackException e) {
            assertEquals(OptimisticLockException.class, e.getCause().getClass());
        }
    }

    @Test
    public void concurrentModificationOfCandyIsRejected() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CandyShopPersistenceUnit");

        EntityManager em1 = emf.createEntityManager();
        em1.getTransaction().begin();

        EntityManager em2 = emf.createEntityManager();
        em2.getTransaction().begin();

        Candy c1 = em1.find(Candy.class, 1000L);
        Candy c2 = em2.find(Candy.class, 1000L);

        c1.setColor(CandyColor.GREEN);
        c2.setColor(CandyColor.BLUE);

        em1.persist(c1);
        em1.getTransaction().commit();

        persistAndExpectOptimisticLockingException(em2, c2);
    }
}
