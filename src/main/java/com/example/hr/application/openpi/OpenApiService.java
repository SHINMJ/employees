package com.example.hr.application.openpi;

import com.example.hr.dto.openapi.OpenApiDataRequest;
import com.example.hr.dto.openapi.OpenApiDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class OpenApiService {

    private final WeatherClient weatherClient;

    public OpenApiDataResponse getCurrentMidFcsData(){
        OpenApiDataRequest request = new OpenApiDataRequest(LocalDateTime.now());
        return weatherClient.getMidFcstData(request);
    }
}
