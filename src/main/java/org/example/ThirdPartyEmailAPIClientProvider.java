package org.example;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import org.example.ThirdPartyEmailAPIClient;

public class ThirdPartyEmailAPIClientProvider implements Provider<ThirdPartyEmailAPIClient> {

    private String apiKey;

    @Inject
    public ThirdPartyEmailAPIClientProvider(@Named("apiKey") String apiKey)
    {
        this.apiKey = apiKey;
    }

    @Override
    public ThirdPartyEmailAPIClient get() {
        return new ThirdPartyEmailAPIClient(apiKey);
    }
}
