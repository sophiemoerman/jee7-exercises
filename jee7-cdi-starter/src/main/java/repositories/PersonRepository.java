package repositories;


import domain.Person;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;



/**
 * Created by SMRBD45 on 10/08/2017.
 */
@ApplicationScoped
public class PersonRepository {
    @Inject
    Logger logger;

    public void savePerson(Person person) {
        logger.info("Saving person");
    }

    public Person findPersonById(int id) {
        logger.info("Retrieving Person by id" +id);
        return new Person();
    }
}
