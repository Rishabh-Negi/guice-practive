package org.example.report;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import org.example.Dao.CustomerDao;
import org.example.ThirdPartyEmailAPIClient;
import org.example.report.reports.CSVReportGenerator;
import org.example.report.reports.XMLReportGenerator;

public class ReportModule extends AbstractModule {
    @Override
    protected void configure()
    {
        bind(ReportGenerator.class).annotatedWith(CSVReportImpl.class).to(CSVReportGenerator.class);
        bind(CustomerDao.class).in(Singleton.class);
        //MOCKING
        bind(String.class).toInstance("MY-API-KEY");
    }

    // Better if constructor call is there
    @Singleton
    @Provides
    public ThirdPartyEmailAPIClient instantiateClient(String apiKey) {
        return new ThirdPartyEmailAPIClient(apiKey);
    }

    //No point of doing this
    @Provides
    @XMLReportImpl
    public ReportGenerator injectXMLReportGenerator(XMLReportGenerator xmlReportGenerator)
    {
        return xmlReportGenerator;
    }
}
