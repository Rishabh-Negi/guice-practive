package org.example.report.reports;

import com.google.inject.Inject;
import lombok.AllArgsConstructor;
import org.example.Dao.CustomerDao;
import org.example.report.ReportGenerator;

import java.util.stream.Collectors;

@AllArgsConstructor(onConstructor = @__(@Inject))
public class XMLReportGenerator implements ReportGenerator {
    private CustomerDao dao;

    @Override
    public String generateReport() {
        System.out.println("dao = " + dao);
        return "<customers>\r\n" + dao.findCustomers().stream()                .map(customer ->
                        "<id>" + customer.getId() + "<id/>\r\n"
                                + "<customerName>" + customer.getCustomerName() + "<customer/>\r\n"
                                + "<createdAt>" + customer.getCreatedAt().toString() + "<createdAt/>\r\n"
                ).collect(Collectors.joining("", "<customer>\r\n", "<customer/>\r\n")) +
                " <customers/>";
    }

    @Override
    public ReportType getReportType() {
        return ReportType.XML;
    }
}
