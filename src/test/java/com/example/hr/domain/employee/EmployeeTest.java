package com.example.hr.domain.employee;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private Job job = Job.builder()
            .jobId("job1")
            .jobTitle("job1Title")
            .build();

    private Department department = Department.builder()
            .departmentId(1L)
            .departmentName("department")
            .build();

    @Test
    void salaryIncrease_cur3000_percentage10_5_after3315() {
        Employee employee = Employee.builder()
                .firstName("first")
                .lastName("last")
                .email("email@email.com")
                .hireDate(LocalDate.of(2012, 4, 12))
                .salary(BigDecimal.valueOf(3000))
                .job(job)
                .department(department)
                .build();

        employee.salaryIncrease(10.5);

        assertThat(employee.getSalary()).isEqualByComparingTo(BigDecimal.valueOf(3315));
    }
}