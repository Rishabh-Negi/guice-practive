package org.example.service;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.example.ThirdPartyEmailAPIClient;
import org.example.report.ReportGenerator;
import org.example.report.ReportGeneratorFactory;
import org.example.report.XMLReportImpl;

public class BillingService {

    private ReportGeneratorFactory reportGeneratorFactory;
    private ThirdPartyEmailAPIClient apiClient;

    @Inject
    public BillingService( ReportGeneratorFactory reportGeneratorFactory, ThirdPartyEmailAPIClient apiClient )
    {
        this.reportGeneratorFactory = reportGeneratorFactory;
        this.apiClient = apiClient;
    }

    public void generate ()
    {
        System.out.println("apiClient = " + apiClient);
        String report = reportGeneratorFactory.getReportGenerator(ReportGenerator.ReportType.XML).generateReport();
        apiClient.sendEmail("fake-XML@email.com", report );
    }
}
