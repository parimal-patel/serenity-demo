package com.example.steps.serenity;

import com.example.client.RestClient;
import com.example.service.RestServer;
import com.example.queue.Queue;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by parimal.patel on 24/02/16.
 */
public class ServerSteps extends ScenarioSteps{
    RestClient client;
    RestServer server;
    Queue queue;
    private boolean fileReceived;

    @Step
    public void initialize() {
        client = new RestClient();
        server = new RestServer();
        queue = new Queue();
    }

    @Step
    public void endpoint_called_by_client(String uploadEndpoint) {
        client.calls(uploadEndpoint, server);
    }

    @Step
    public void receivefile() {
        fileReceived = true;
    }

    @Step
    public void add_log_in_database_and_syslog() {
        System.out.println("Inserted 1 record in DB for receiving a file");
        System.out.println("Received a file");
        assertTrue(fileReceived);
    }

    @Step
    public void pushes_file_to_queue() {
        int queueSizeBefore = queue.size();
        queue.push("FileObject");
        assertEquals(queue.size(), queueSizeBefore + 1);
    }

    @Step
    public void checkIfFileIsAvailable() {
        assertTrue(fileReceived);
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void publishMessage(String topic) {
        System.out.println("Publishing message to " + topic);
    }

    @Step
    public void fetchMessageFromQueue() {
        Object message = queue.fetch();
        assertNotNull(message);
        Serenity.setSessionVariable("message").to(message);
        System.out.println("object = " + message);
    }

    @Step
    public void subscribesTopic(String topic) {
        System.out.println("Subscribed topic: " + topic);
    }

    @Step
    public void receivesMessageFromTopic(String topic) {
        System.out.println("Received Message: " + Serenity.sessionVariableCalled("message").toString());
    }

    @Step
    public void logsTheMessage() {
        System.out.println("Log: " + Serenity.sessionVariableCalled("message"));
    }
}
