package com.example.hr.ui.employee;

import com.example.hr.application.employee.DepartmentService;
import com.example.hr.dto.employee.DepartmentLocationResponse;
import com.example.hr.dto.employee.DepartmentSalaryIncreaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
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
