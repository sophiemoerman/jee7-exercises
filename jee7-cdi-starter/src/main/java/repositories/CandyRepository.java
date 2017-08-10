package repositories;

import domain.Candy;
import domain.CandyColor;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;


/**
 * Created by SMRBD45 on 10/08/2017.
 */

@ApplicationScoped
public class CandyRepository {

    @Inject
    Logger logger;

    public List<Candy> findAllCandy() {
        logger.info("Retrieving all candy");
        return Collections.emptyList();
    }

    public List<Candy> findCandyByColor(CandyColor color){
        logger.info("Retrieving candy by color" + color);
        return Collections.emptyList();
    }
}
