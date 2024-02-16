package com.example.hr.application;

import com.example.hr.domain.employee.Employee;
import com.example.hr.domain.employee.EmployeeRepository;
import com.example.hr.dto.EmployeeResponse;
import com.example.hr.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    @Transactional(readOnly = true)
    public EmployeeResponse findById(Long employeeId) {

        Employee employee = repository.findById(employeeId)
                .orElseThrow(() -> new NotFoundException("해당 사원을 찾을 수 없습니다."));
        return EmployeeResponse.of(employee);
    }
}
