package com.example.hr.infra;

import com.example.hr.dto.openapi.OpenApiDataRequest;
import com.example.hr.dto.openapi.OpenApiDataResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {WeatherClientImpl.class})
class WeatherClientImplTest {

    @Autowired
    private WeatherClientImpl weatherClient;

    @Test
    void getMidFcstData_success() {
        OpenApiDataResponse response = weatherClient.getMidFcstData(new OpenApiDataRequest(LocalDateTime.now()));

        assertThat(response.code()).isEqualTo("00");
        System.out.println(response);
    }

    @Test
    void getMidFcstData_failed() {
        OpenApiDataResponse response = weatherClient.getMidFcstData(new OpenApiDataRequest(LocalDateTime.now().plusDays(2L)));

        assertThat(response.code()).isEqualTo("03");
        System.out.println(response);
    }
}