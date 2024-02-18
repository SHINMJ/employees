package com.example.hr.dto.employee;

import com.example.hr.domain.employee.Department;

public record DepartmentResponse(Long departmentId, String departmentName,
                                 Long managerId) {

    public static DepartmentResponse of(Department department){
        return new DepartmentResponse(department.getDepartmentId(), department.getDepartmentName(), department.getManagerId());
    }
}
