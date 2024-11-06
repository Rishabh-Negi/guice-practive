package org.example.report;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;
import org.example.Dao.CustomerDao;
import org.example.ThirdPartyEmailAPIClient;
import org.example.report.reports.CSVReportGenerator;
import org.example.report.reports.XMLReportGenerator;
import org.example.service.RetryQueueClient;
import org.example.service.RetryQueueClientProvider;
import org.example.ThirdPartyEmailAPIClientProvider;


public class ReportModule extends AbstractModule {
    @Override
    protected void configure()
    {
        Multibinder<ReportGenerator> reportGeneratorMultibinder = Multibinder.newSetBinder(binder(), ReportGenerator.class);
        reportGeneratorMultibinder.addBinding().to(CSVReportGenerator.class);
        reportGeneratorMultibinder.addBinding().to(XMLReportGenerator.class);

//        bind(ReportGenerator.class).annotatedWith(CSVReportImpl.class).to(CSVReportGenerator.class);
//        bind(ReportGenerator.class).annotatedWith(XMLReportImpl.class).to(XMLReportGenerator.class);

        bind(CustomerDao.class).in(Scopes.SINGLETON);
        //MOCKING
        bind(String.class).annotatedWith(Names.named("apiKey")).toInstance("MY-API-KEY");

        bind(ThirdPartyEmailAPIClient.class).toProvider(ThirdPartyEmailAPIClientProvider.class).in(Scopes.SINGLETON);
        bind(RetryQueueClient.class).toProvider(RetryQueueClientProvider.class).in(Scopes.SINGLETON);
    }

//    @Singleton
//    @Provides
//    public ThirdPartyEmailAPIClient instantiateClient(String apiKey) {
//        return new ThirdPartyEmailAPIClient(apiKey);
//    }

//No point of doing this
//    @Provides
//    @XMLReportImpl
//    public ReportGenerator injectXMLReportGenerator(XMLReportGenerator xmlReportGenerator)
//    {
//        return xmlReportGenerator;
//    }
}
