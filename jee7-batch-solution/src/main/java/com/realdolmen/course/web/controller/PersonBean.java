package com.realdolmen.course.web.controller;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.service.PersonServiceBean;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Named
@RequestScoped
public class PersonBean {

    private Long jobId;

    @Inject
    private PersonServiceBean personService;

    public List<Person> allPeople() {
        return personService.findAll();
    }

    public void remove(long personId) {
        personService.remove(personId);
    }

    public void startBatchJob() {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        Properties props = new Properties();
        props.put("date", new Date().getTime());
        jobId = jobOperator.start("import", props);
    }

    public Long getJobId() {
        return jobId;
    }
}
