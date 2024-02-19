package com.example.hr.ui.employee;

import com.example.hr.application.employee.DepartmentService;
import com.example.hr.dto.employee.DepartmentLocationResponse;
import com.example.hr.dto.employee.DepartmentSalaryIncreaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class DepartmentController {

    private final DepartmentService service;

    @GetMapping("/departments/{id}")
    public ResponseEntity<DepartmentLocationResponse> findById(@PathVariable Long id){
        DepartmentLocationResponse response = service.findResponseById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/departments/{id}/salary-increase")
    public ResponseEntity<Void> departmentSalaryIncrease(@PathVariable Long id, @RequestBody DepartmentSalaryIncreaseRequest request){
        service.salaryIncrease(id, request);
        return ResponseEntity.noContent().build();
    }

}
