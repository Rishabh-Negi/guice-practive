package org.example.report;

public interface ReportGenerator {
    public String generateReport();
    public ReportType getReportType();

    public enum ReportType {
        XML,
        CSV
    }
}
