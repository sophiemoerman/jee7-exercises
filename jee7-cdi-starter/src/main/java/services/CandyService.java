package services;

import domain.Candy;
import domain.CandyColor;
import repositories.CandyRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by SMRBD45 on 10/08/2017.
 */
@ApplicationScoped
public class CandyService {

    @Inject
    CandyRepository candyRepository;

    @Inject
    PersonService personService;

    public CandyRepository getCandyRepository() {
        return candyRepository;
    }

    public PersonService getPersonService() {
        return personService;
    }

    public List<Candy> findAllCandy(){
        return candyRepository.findAllCandy();
    }

    public List<Candy> findCandyByColor(CandyColor color){
        return candyRepository.findCandyByColor(color);
    }

}
