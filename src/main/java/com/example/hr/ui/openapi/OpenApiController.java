package com.example.hr.ui.openapi;

import com.example.hr.application.openpi.OpenApiService;
import com.example.hr.dto.openapi.OpenApiDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OpenApiController {

    private final OpenApiService service;

    @GetMapping("/openapi/mid-fcst-info")
    public ResponseEntity<OpenApiDataResponse> getCurrentMidFcsData(){
        OpenApiDataResponse response = service.getCurrentMidFcsData();
        return ResponseEntity.ok(response);
    }
}
