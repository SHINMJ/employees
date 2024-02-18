package com.example.hr.dto.employee;

import com.example.hr.domain.employee.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeResponse(Long employeeId, String firstName, String lastName,
                               String email, String phoneNumber, LocalDate hireDate,
                               BigDecimal salary, String jobId, String jobTitle,
                               Long departmentId, String departmentName, Long managerId) {

    public static EmployeeResponse of(Employee employee) {
        Long departmentId = null;
        String departmentName = null;
        Long managerId = null;
        if (employee.getDepartment() != null){
            departmentId = employee.getDepartment().getDepartmentId();
            departmentName = employee.getDepartment().getDepartmentName();
        }

        if (employee.getManager() != null){
            managerId = employee.getManager().getEmployeeId();
        }
        return new EmployeeResponse(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(),
                employee.getEmail(), employee.getPhoneNumber(), employee.getHireDate(),
                employee.getSalary(), employee.getJob().getJobId(), employee.getJob().getJobTitle(),
                departmentId, departmentName, managerId);
    }
}
