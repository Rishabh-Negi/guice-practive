package org.example.service;

public class RetryQueueClient {
    public void send( String Message )
    {
        System.out.println("Message " + Message + "Sent successfully to the queue");
    }
}
