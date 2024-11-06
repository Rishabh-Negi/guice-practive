package org.example;

public class ThirdPartyEmailAPIClient {

    private ThirdPartyEmailAPIClient() {
    }

    // @Inject annotation can not be added
    public ThirdPartyEmailAPIClient(String apiKey) {
        this.apiKey = apiKey;
    }

    private String apiKey;

    public void sendEmail(String address, String report) {
        System.out.println("Fake report " + report +
                "successfully sent to fake address " +
                address + " by fake client with api key "+ this.apiKey);
    }
}