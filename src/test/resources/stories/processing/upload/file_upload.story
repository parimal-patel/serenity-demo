Narrative:
As a user
I want to perform file upload
So that I can achieve a business goal

Scenario: File Uploading Scenario
Given a REST Client and REST Server
When the REST Client calls file uploader endpoint on REST Server
Then the server should receive the file
And log entry is added in the database and syslog
And the file is pushed to the queue

Scenario: File Publish to Queue
Given the file content is available in the queue
When the message is fetched from the queue
Then publish the message to the topic 'abc'

Scenario: File Subscribe and Process
Given the topic 'abc' is subscribed
When the message is received from topic 'abc'
Then log the receipt of the message