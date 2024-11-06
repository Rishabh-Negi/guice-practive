package org.example.service;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.example.ThirdPartyEmailAPIClient;
import org.example.report.CSVReportImpl;
import org.example.report.ReportGenerator;

public class CustomerService {

    private ReportGenerator reportGenerator;
    private ThirdPartyEmailAPIClient apiClient;

    @Inject
    public CustomerService( @CSVReportImpl ReportGenerator csvReportGenerator, ThirdPartyEmailAPIClient apiClient )
    {
        this.reportGenerator = csvReportGenerator;
        this.apiClient = apiClient;
    }

    public void generate()
    {
        System.out.println("apiClient = " + apiClient);
        String report = reportGenerator.generateReport();
        apiClient.sendEmail("fake-csv@email.com", report );
    }

}

