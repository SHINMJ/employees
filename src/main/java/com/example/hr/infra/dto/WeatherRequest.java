package com.example.hr.infra.dto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

public record WeatherRequest(int pageNo, int numOfRows, String dataType,
                             int stnId, String tmFc) {

    public MultiValueMap<String, String> convertQueryParams() {
        ObjectMapper objectMapper = new ObjectMapper();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        Map<String, String> map = objectMapper.convertValue(this, new TypeReference<>() {});

        params.setAll(map);

        return params;
    }
}
