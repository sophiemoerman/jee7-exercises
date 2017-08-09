package com.realdolmen.candyshop.web;

import com.realdolmen.candyshop.domain.CandyColor;
import com.realdolmen.candyshop.services.CandyService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class CandyController {
    @Inject
    CandyService candyService;

    private CandyColor candyColor = CandyColor.GREEN;

    public void findAllCandy() {
        candyService.findAllCandy();
    }

    public void findCandyByColor() {
        candyService.findCandyByColor(candyColor);
    }

    CandyService getCandyService() {
        return candyService;
    }
}
