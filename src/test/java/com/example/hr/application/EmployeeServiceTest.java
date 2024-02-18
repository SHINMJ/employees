package com.example.hr.application;

import com.example.hr.application.employee.EmployeeService;
import com.example.hr.domain.employee.Department;
import com.example.hr.domain.employee.Employee;
import com.example.hr.domain.employee.EmployeeRepository;
import com.example.hr.domain.employee.Job;
import com.example.hr.dto.employee.EmployeeResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    private Job job = Job.builder()
            .jobId("job1")
            .jobTitle("job1Title")
            .build();

    private Department department = Department.builder()
            .departmentId(1L)
            .departmentName("department")
            .build();

    @Test
    void findById() {
        Employee employee = Employee.builder()
                .employeeId(1L)
                .lastName("lastname")
                .email("email@emai.com")
                .hireDate(LocalDate.now())
                .job(job)
                .department(department)
                .build();

        Mockito.when(repository.findById(anyLong()))
                .thenReturn(Optional.of(employee));

        EmployeeResponse response = service.findResponseById(1L);

        assertAll(
                () -> assertThat(response.employeeId()).isEqualTo(employee.getEmployeeId()),
                () -> assertThat(response.jobId()).isEqualTo(job.getJobId()),
                () -> assertThat(response.departmentId()).isEqualTo(department.getDepartmentId()),
                () -> assertNull(response.managerId())
        );
    }
}