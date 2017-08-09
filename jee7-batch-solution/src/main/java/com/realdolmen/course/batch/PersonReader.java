package com.realdolmen.course.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Created by cda5732 on 18/05/2016.
 */
@Named
public class PersonReader extends AbstractItemReader {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private BufferedReader bufferedReader;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("/people.csv")));
        super.open(checkpoint);
    }

    @Override
    public String readItem() throws Exception {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            logger.error("Error occured while reading file", e);
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        bufferedReader.close();
        super.close();
    }
}
