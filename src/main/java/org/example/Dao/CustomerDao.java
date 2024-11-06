package org.example.Dao;
import java.time.LocalDate;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

public class CustomerDao {

    public Set<Customer> findCustomers() {
        return Set.of(
                new Customer("1", "Customer1", LocalDate.now()),
                new Customer("2", "Customer2", LocalDate.now().minusDays(1))

        );
    }

    @Data
    @AllArgsConstructor
    public static class Customer {
        private String id;
        private String customerName;
        private LocalDate createdAt;
    }
}
