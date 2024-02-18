package com.example.hr.dto.employee;

import com.example.hr.domain.employee.JobHistory;

import java.time.LocalDate;

public record JobHistoryResponse(EmployeeResponse employee, LocalDate startDate,
                                 LocalDate endDate, JobResponse job,
                                 DepartmentResponse department) {

    public static JobHistoryResponse of(JobHistory jobHistory) {
        return new JobHistoryResponse(EmployeeResponse.of(jobHistory.getEmployee()), jobHistory.getStartDate(),
                jobHistory.getEndDate(), JobResponse.of(jobHistory.getJob()),
                DepartmentResponse.of(jobHistory.getDepartment()));
    }
}
