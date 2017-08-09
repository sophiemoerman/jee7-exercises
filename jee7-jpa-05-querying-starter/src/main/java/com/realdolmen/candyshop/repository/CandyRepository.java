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
        return 0;
    }

    public List<Candy> findCandyByNameLike(String name) {
        // TODO: implement this method
        return null;
    }

    public List<Candy> findUniqueCandyForPersonOrderHistory(Person p) {
        // TODO: implement this method
        return null;
    }
}
