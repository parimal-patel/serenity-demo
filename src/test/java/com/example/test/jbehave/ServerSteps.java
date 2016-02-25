package com.example.test.jbehave;

import com.example.test.client.RestClient;
import com.example.test.service.RestServer;
import com.example.test.queue.Queue;
import net.thucydides.core.steps.ScenarioSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by parimal.patel on 24/02/16.
 */
public class ServerSteps extends ScenarioSteps{
    RestClient client;
    RestServer server;
    Queue queue;
    private boolean fileReceived;

    public void initialize() {
        client = new RestClient();
        server = new RestServer();
        queue = new Queue();
    }

    public void endpoint_called_by_client(String uploadEndpoint) {
        client.calls(uploadEndpoint, server);
    }

    public void receivefile() {
        fileReceived = true;
    }

    public void add_log_in_database_and_syslog() {
        System.out.println("Inserted 1 record in DB for receiving a file");
        System.out.println("Received a file");
        assertTrue(fileReceived);
    }

    public void pushes_file_to_queue() {
        queue.push("FileObject");
        assertEquals(queue.size(), 1);
    }
}
