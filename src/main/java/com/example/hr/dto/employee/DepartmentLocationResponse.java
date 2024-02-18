package com.example.hr.dto.employee;

import com.example.hr.domain.employee.Department;
import com.example.hr.dto.location.LocationResponse;

public record DepartmentLocationResponse(DepartmentResponse department,
                                         LocationResponse location) {

    public static DepartmentLocationResponse of(Department department) {
        return new DepartmentLocationResponse(DepartmentResponse.of(department), LocationResponse.of(department.getLocation()));
    }
}
