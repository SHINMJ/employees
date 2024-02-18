package com.example.hr.ui.employee;

import com.example.hr.application.employee.EmployeeService;
import com.example.hr.dto.employee.EmployeeResponse;
import com.example.hr.dto.employee.JobHistoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<EmployeeResponse> findEmployeeById(@PathVariable Long employeeId){
        EmployeeResponse response = service.findResponseById(employeeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/employees/{employeeId}/history")
    public ResponseEntity<List<JobHistoryResponse>> findHistoryById(@PathVariable Long employeeId){
        List<JobHistoryResponse> response = service.findHistoryById(employeeId);
        return ResponseEntity.ok(response);
    }

}
