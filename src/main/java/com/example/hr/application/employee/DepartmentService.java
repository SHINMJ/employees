package com.example.hr.application.employee;

import com.example.hr.domain.employee.Department;
import com.example.hr.domain.employee.DepartmentRepository;
import com.example.hr.dto.employee.DepartmentLocationResponse;
import com.example.hr.dto.employee.DepartmentSalaryIncreaseRequest;
import com.example.hr.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class DepartmentService {

    private final DepartmentRepository repository;
    private final EmployeeService employeeService;

    @Transactional(readOnly = true)
    public DepartmentLocationResponse findResponseById(Long id) {
        Department department = findById(id);
        return DepartmentLocationResponse.of(department);
    }

    public void salaryIncrease(Long id, DepartmentSalaryIncreaseRequest request) {
        Department department = findById(id);
        employeeService.salaryIncreaseByDepartment(department, request);
    }

    private Department findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("해당 정보를 찾을 수 없습니다."));
    }

}
