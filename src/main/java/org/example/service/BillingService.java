package org.example.service;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.example.ThirdPartyEmailAPIClient;
import org.example.report.ReportGenerator;
import org.example.report.XMLReportImpl;

public class BillingService {

    private ReportGenerator reportGenerator;
    private ThirdPartyEmailAPIClient apiClient;

    @Inject
    public BillingService( @XMLReportImpl ReportGenerator reportGenerator, ThirdPartyEmailAPIClient apiClient )
    {
        this.reportGenerator = reportGenerator;
        this.apiClient = apiClient;
    }

    public void generate ()
    {
        System.out.println("apiClient = " + apiClient);
        String report = reportGenerator.generateReport();
        apiClient.sendEmail("fake-XML@email.com", report );
    }
}
