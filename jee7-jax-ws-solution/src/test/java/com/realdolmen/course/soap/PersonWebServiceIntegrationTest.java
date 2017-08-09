package com.realdolmen.course.soap;


import com.realdolmen.course.domain.Person;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class PersonWebServiceIntegrationTest{

    private PersonSoapService service;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Before
    public void setupBeforeClass() throws Exception {
        URL wsdlLocation = new URL("http://localhost:8080/jee7-jax-ws-solution/PersonSoapService/PersonSoapServiceEndpoint?wsdl");
        QName serviceName = new QName("http://soap.course.realdolmen.com/", "PersonSoapService");
        Service webService = Service.create(wsdlLocation, serviceName);
        service = webService.getPort(PersonSoapService.class);
    }

    @Test
    public void shouldReturnAllPeople() {
        List<Person> result = service.findAll();
        assertNotNull(result);
        assertFalse(result.isEmpty());
        result.stream().map(Person::toString).forEach(logger::trace);
    }
}
