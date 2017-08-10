package com.realdolmen.candyshop.web;

import com.realdolmen.candyshop.AbstractWeldContainerTest;

import domain.Person;
import org.junit.Test;
import web.PersonController;

import static org.junit.Assert.assertNotNull;

public class PersonControllerTest extends AbstractWeldContainerTest {
    @Test
    public void personControllerHasPersonService() throws Exception {
        PersonController personController = container.instance().select(PersonController.class).get();
        assertNotNull(personController);
        personController.savePerson(new Person());
        personController.findPersonById(1507);
        assertNotNull(personController.getPersonService());
    }
}
