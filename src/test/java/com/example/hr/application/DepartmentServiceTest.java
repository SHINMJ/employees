package com.example.hr.application;

import com.example.hr.application.employee.DepartmentService;
import com.example.hr.application.employee.EmployeeService;
import com.example.hr.domain.employee.*;
import com.example.hr.domain.location.Country;
import com.example.hr.domain.location.Location;
import com.example.hr.dto.employee.DepartmentLocationResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {


    @Mock
    private DepartmentRepository repository;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService service;

    private Location location = Location.builder()
            .locationId(1L)
            .city("city")
            .country(Country.builder()
                    .countryId("KO")
                    .countryName("korea")
                    .build())
            .build();


    @Test
    void findById() {
        Department department = Department.builder()
                .departmentId(1L)
                .departmentName("department")
                .location(location)
                .build();

        Mockito.when(repository.findById(anyLong()))
                .thenReturn(Optional.of(department));

        DepartmentLocationResponse response = service.findResponseById(1L);

        assertAll(
                () -> assertThat(response.department().departmentId()).isEqualTo(department.getDepartmentId()),
                () -> assertThat(response.location().locationId()).isEqualTo(location.getLocationId())
        );
    }

}