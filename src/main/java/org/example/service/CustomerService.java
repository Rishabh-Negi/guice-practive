package org.example.service;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.example.ThirdPartyEmailAPIClient;
import org.example.report.CSVReportImpl;
import org.example.report.ReportGenerator;
import org.example.report.ReportGeneratorFactory;

public class CustomerService {

    private ReportGeneratorFactory reportGeneratorFactory;
    private ThirdPartyEmailAPIClient apiClient;
    // Provider injection to build instance when needed
    private RetryQueueClientProvider retryQueueClientProvider;

    @Inject
    public CustomerService( ReportGeneratorFactory reportGeneratorFactory,
                            ThirdPartyEmailAPIClient apiClient,
                            RetryQueueClientProvider retryQueueClientProvider )
    {
        this.reportGeneratorFactory = reportGeneratorFactory;
        this.apiClient = apiClient;
        this.retryQueueClientProvider = retryQueueClientProvider;
    }

    public void generate()
    {
        System.out.println("apiClient = " + apiClient);
        String report = reportGeneratorFactory.getReportGenerator(ReportGenerator.ReportType.CSV).generateReport();
        System.out.println("report = " + report);
        try {
//               if (1 == 1) {
//                  throw new RuntimeException();
//              }
            apiClient.sendEmail("fake-csv@email.com", report);
        } catch (Exception e) {
            System.out.println("error = " + e);
            retryQueueClientProvider.get().send("Error while trying to send a report: " + report);
        }
    }

}

