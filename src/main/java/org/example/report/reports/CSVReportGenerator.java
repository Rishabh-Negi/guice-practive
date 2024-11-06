package org.example.report.reports;

import com.google.inject.Inject;
import lombok.AllArgsConstructor;
import org.example.Dao.CustomerDao;
import org.example.report.ReportGenerator;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor(onConstructor = @__(@Inject))
public class CSVReportGenerator implements ReportGenerator {
    private CustomerDao dao;

    @Override
    public String generateReport()
    {
        System.out.println("dao = " + dao);
        return dao.findCustomers().stream()
                .map(customer -> Stream.of(customer.getId(),
                                customer.getCustomerName(),
                                customer.getCreatedAt().toString())
                        .collect(Collectors.joining(";", "", "\r\n")))
                .collect(Collectors.joining() );
    }

    @Override
    public ReportType getReportType() {
        return ReportType.CSV;
    }
}

