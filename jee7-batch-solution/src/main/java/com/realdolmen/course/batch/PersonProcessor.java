package com.realdolmen.course.batch;

import com.realdolmen.course.domain.Person;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;
import java.util.StringTokenizer;

/**
 * Created by cda5732 on 18/05/2016.
 */
@Named
public class PersonProcessor implements ItemProcessor {
    @Override
    public Person processItem(Object t) throws Exception {
        StringTokenizer tokenizer = new StringTokenizer((String) t, ",");
        String id = tokenizer.nextToken();
        String fullName = tokenizer.nextToken();

        StringTokenizer nameTokenizer = new StringTokenizer(fullName, " ");
        String firstName = "";
        String lastName = "";
        if (nameTokenizer.countTokens() >= 1) {
            firstName = nameTokenizer.nextToken();
        }

        while (nameTokenizer.hasMoreTokens()) {
            lastName += " " + nameTokenizer.nextToken();
        }


        return new Person(firstName, lastName);
    }
}
