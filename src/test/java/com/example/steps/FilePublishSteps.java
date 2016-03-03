package com.example.steps;

import com.example.steps.serenity.ServerSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

/**
 * Created by parimal.patel on 02/03/16.
 */
public class FilePublishSteps {

    @Steps
    ServerSteps server;

    @Given("the file content is available in the queue")
    public void givenTheFileContentIsAvailableInTheQueue() {
        server.checkIfFileIsAvailable();
    }

    @When("the message is fetched from the queue")
    public void whenTheMessageIsFetchedFromTheQueue() {
        server.fetchMessageFromQueue();
    }

    @Then("publish the message to the topic '$topic'")
    public void thenPublishTheMessageToTheTopicAbc(String topic) {
        server.publishMessage(topic);
    }
}
