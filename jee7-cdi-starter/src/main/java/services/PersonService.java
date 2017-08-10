package services;

import domain.Person;
import repositories.PersonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Created by SMRBD45 on 10/08/2017.
 */
@ApplicationScoped
public class PersonService {

    @Inject
    PersonRepository personRepository;

    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    public void savePerson(Person p){
        personRepository.savePerson(p);
    }

    public Person findPersonById(int id){
        return personRepository.findPersonById(id);
    }
}
