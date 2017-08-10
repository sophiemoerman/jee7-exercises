package web;

import domain.Person;
import services.PersonService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Created by SMRBD45 on 10/08/2017.
 */
@RequestScoped
public class PersonController {

    @Inject
    PersonService personService;

    public PersonService getPersonService() {
        return personService;
    }

    public void savePerson(Person p){
        personService.savePerson(p);
    }

    public Person findPersonById(int id){

        return personService.findPersonById(id);
    }
}
