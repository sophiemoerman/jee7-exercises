package web;

import domain.CandyColor;
import services.CandyService;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Created by SMRBD45 on 10/08/2017.
 */
@RequestScoped
public class CandyController {

    @Inject
    CandyService candyService;

    private CandyColor candyColor = CandyColor.BLUE;

    public void saveCandy(){

    }

    public void findAllCandy(){
        candyService.findAllCandy();
    }

    public void findCandyByColor(){
        candyService.findCandyByColor(candyColor);
    }

    public CandyService getCandyService() {
        return candyService;
    }
}
