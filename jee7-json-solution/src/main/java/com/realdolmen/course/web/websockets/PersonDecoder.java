package com.realdolmen.course.web.websockets;

import com.realdolmen.course.domain.Person;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.StringReader;

/**
 * Created by cda5732 on 17/05/2016.
 */
public class PersonDecoder implements Decoder.Text<Person> {
    @Override
    public Person decode(String s) throws DecodeException {
        JsonObject object = Json.createReader(new StringReader(s)).readObject();
        return new Person(
                object.getString("firstName"),
                object.getString("lastName")
        );
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
