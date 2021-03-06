package com.example.client;

import com.example.service.RestServer;
import net.thucydides.core.reports.adaptors.specflow.ScenarioSplitter;

/**
 * Created by parimal.patel on 24/02/16.
 */
public class RestClient {
    public ScenarioSplitter calls(String uploadEndpoint, RestServer server) {
        return server.call(uploadEndpoint);
    }
}
