package com.example.steps;

import com.example.steps.serenity.ServerSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by parimal.patel on 03/03/16.
 */
public class FileSubscribeSteps {

    @Steps
    ServerSteps server;

    @Given("the topic '$topic' is subscribed")
    public void givenTheTopicIsSubscribed(String topic) {
        server.subscribesTopic(topic);
    }

    @When("the message is received from topic '$topic'")
    public void whenTheMessageIsReceivedFromTopic(String topic) {
        server.receivesMessageFromTopic(topic);
    }

    @Then("log the receipt of the message")
    public void thenLogTheReceiptOfTheMessage() {
        server.logsTheMessage();
    }
}
