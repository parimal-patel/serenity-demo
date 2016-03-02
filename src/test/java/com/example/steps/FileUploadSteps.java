package com.example.steps;

import com.example.steps.serenity.ServerSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by parimal.patel on 24/02/16.
 */
public class FileUploadSteps {
    private static final String UPLOAD_ENDPOINT = "upload";

    @Steps
    ServerSteps server;

    @Given("a REST Client and REST Server")
    public void givenARESTClientAndRESTServer() {
        server.initialize();
    }

    @When("the REST Client calls file uploader endpoint on REST Server")
    public void whenTheRESTClientCallsFileUploaderEndpointOnRESTServer() {
        server.endpoint_called_by_client(UPLOAD_ENDPOINT);
    }

    @Then("the server should receive the file")
    public void thenTheServerShouldReceiveTheFile() {
        server.receivefile();
    }

    @Then("log entry is added in the database and syslog")
    public void thenLogEntryIsAddedInTheDatabaseAndSyslog() {
        server.add_log_in_database_and_syslog();
    }

    @Then("the file is pushed to the queue")
    public void thenTheFileIsPushedToTheQueue() {
        server.pushes_file_to_queue();
    }
}
