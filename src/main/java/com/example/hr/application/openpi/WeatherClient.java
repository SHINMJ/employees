package com.example.hr.application.openpi;

import com.example.hr.dto.openapi.OpenApiDataRequest;
import com.example.hr.dto.openapi.OpenApiDataResponse;
import org.springframework.stereotype.Component;

@Component
public interface WeatherClient {
    OpenApiDataResponse getMidFcstData(OpenApiDataRequest request);
}
