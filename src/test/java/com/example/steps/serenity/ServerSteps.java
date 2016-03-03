package com.example.steps.serenity;

import com.example.client.RestClient;
import com.example.service.RestServer;
import com.example.queue.Queue;
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
        queue.push("FileObject");
        assertEquals(queue.size(), 1);
    }

    @Step
    public void checkIfFileIsAvailable() {
        assertTrue(fileReceived);
        try {
            Thread.currentThread().sleep(10000);
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
        Object object = queue.fetch();
        assertNotNull(object);
        System.out.println("object = " + object);
    }
}
