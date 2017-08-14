package com.realdolmen.candyshop.repository;

import com.realdolmen.candyshop.domain.Candy;
import com.realdolmen.candyshop.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CandyRepository {
    EntityManager em;

    public double findAverageCandyPrice() {
        // TODO: implement this method
        return em.createQuery("select avg(c.price) from Candy c",Double.class).getSingleResult();


    }

    public List<Candy> findCandyByNameLike(String name) {
        TypedQuery<Candy> query = em.createNamedQuery("find candy by name like", Candy.class);
        query.setParameter("myName", '%' + name + '%');
        return query.getResultList();
    }

    public List<Candy> findUniqueCandyForPersonOrderHistory(Person p) {
        // TODO: implement this method
        return em.createQuery("select distinct c from Order o join o.orderLines ol join ol.candy c where o.person = :myPerson order by c.name", Candy.class)
                .setParameter("myPerson", p)
                .getResultList();
    }
}
