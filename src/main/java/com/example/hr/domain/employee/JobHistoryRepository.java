package com.example.hr.domain.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId> {
    List<JobHistory> findByJobHistoryIdEmployee(Employee employeeId);

}
