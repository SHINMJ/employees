package com.example.hr.ui;

import com.example.hr.application.EmployeeService;
import com.example.hr.dto.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping("/employess/{employeeId}")
    public ResponseEntity<EmployeeResponse> findEmployeeById(@PathVariable Long employeeId){
        EmployeeResponse response = service.findById(employeeId);
        return ResponseEntity.ok(response);
    }

}
