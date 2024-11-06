package org.example.report;

import com.google.inject.Inject;

import java.util.Set;

public class ReportGeneratorFactory {
    private final Set<ReportGenerator> reportGenerators;

    @Inject
    public ReportGeneratorFactory(Set<ReportGenerator> reportGenerators )
    {
        this.reportGenerators = reportGenerators;
    }

    public ReportGenerator getReportGenerator( ReportGenerator.ReportType reportType)
    {
        return reportGenerators.stream()
                .filter(generator -> generator.getReportType().equals(reportType))
                .findFirst().orElseThrow();
    }

}
