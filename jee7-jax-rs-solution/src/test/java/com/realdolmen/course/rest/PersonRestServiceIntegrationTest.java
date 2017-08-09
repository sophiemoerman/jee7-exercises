package com.realdolmen.course.rest;

import com.realdolmen.course.domain.Person;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.function.Consumer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PersonRestServiceIntegrationTest {
    private static final String REST_SERVICE_URL = "http://localhost:8080/jee7-jax-rs-solution/rest/people";

    private Logger logger = LoggerFactory.getLogger(getClass());

    private WebTarget target;

    private Consumer<PersonList> sharedAssertions = (list) -> {
        assertEquals(5, list.getPersons().size());
        list.getPersons().stream().map(Person::toString).forEach(logger::trace);
    };

    @Before
    public void initializeClient() {
        Client client = ClientBuilder.newClient();
        target = client.target(REST_SERVICE_URL);
    }

    @Test
    public void shouldRetrieveAllPersonsInXML() throws Exception {
        assertForRepresentation("get", MediaType.APPLICATION_XML_TYPE, PersonList.class, sharedAssertions);
    }

    @Test
    public void shouldRetrieveAllPersonsInJSON() throws Exception {
        assertForRepresentation("get", MediaType.APPLICATION_JSON_TYPE, PersonList.class, sharedAssertions);
    }

    private <T> void assertForRepresentation(String method, MediaType mediaType, Class<T> responseType, Consumer<T> assertions) {
        T result = target.request(mediaType).method(method, responseType);
        assertNotNull(result);
        assertions.accept(result);
    }
}
