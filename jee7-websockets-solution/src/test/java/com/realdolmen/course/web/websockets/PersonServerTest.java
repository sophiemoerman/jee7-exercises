package com.realdolmen.course.web.websockets;

import com.realdolmen.course.utilities.integration.RemoteIntegrationTest;
import org.junit.Test;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by cda5732 on 17/05/2016.
 */
@ClientEndpoint
public class PersonServerTest extends RemoteIntegrationTest{

    private Semaphore semaphore = new Semaphore(0);
    private static String message;

    @OnMessage
    public void onMessage(String message) {
        PersonServerTest.message = message;
        semaphore.release();
    }

    @Test
    public void shouldReturnSucceeded() throws IOException, DeploymentException, InterruptedException {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        String uri = "ws://localhost:8080/jee7-websockets-solution/persons";
        Session session = container.connectToServer(PersonServerTest.class, URI.create(uri));
        session.getAsyncRemote().sendText("Theo Tester");
        semaphore.tryAcquire(1, TimeUnit.SECONDS);
        assertEquals("success", message);
    }
}
