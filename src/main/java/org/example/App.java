package org.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import jakarta.inject.Inject;
import org.example.report.ReportModule;
import org.example.report.reports.CSVReportGenerator;
import org.example.report.ReportGenerator;
import org.example.service.BillingService;
import org.example.service.CustomerService;

public class App 
{
    public static void main( String[] args )
    {
        Injector injector = Guice.createInjector( new ReportModule() );
        CustomerService customerService = injector.getInstance(CustomerService.class);
        customerService.generate();

        BillingService billingService = injector.getInstance(BillingService.class);
        billingService.generate();
    }
}
