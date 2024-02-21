package com.example.hr.application.employee;

import com.example.hr.domain.employee.*;
import com.example.hr.dto.employee.DepartmentSalaryIncreaseRequest;
import com.example.hr.dto.employee.EmployeeResponse;
import com.example.hr.dto.employee.JobHistoryResponse;
import com.example.hr.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final JobHistoryRepository jobHistoryRepository;

    @Transactional(readOnly = true)
    public EmployeeResponse findResponseById(Long employeeId) {
        Employee employee = findById(employeeId);
        return EmployeeResponse.of(employee);
    }

    @Transactional(readOnly = true)
    public List<JobHistoryResponse> findHistoryById(Long employeeId) {
        Employee employee = findById(employeeId);
        List<JobHistory> jobHistories = jobHistoryRepository.findByJobHistoryIdEmployee(employee);
        return jobHistories.stream()
                .map(JobHistoryResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    private Employee findById(Long employeeId){
        return repository.findById(employeeId)
                .orElseThrow(() -> new NotFoundException("해당 사원을 찾을 수 없습니다."));
    }

    public void salaryIncreaseByDepartment(Department department, DepartmentSalaryIncreaseRequest request) {
        List<Employee> employees = repository.findAllByDepartment(department);

        List<Employee> increases = employees.stream()
                .map(employee -> employee.salaryIncrease(request.percentage())).toList();

        repository.saveAll(increases);
    }
}
