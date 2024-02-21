package com.example.hr.infra;

import com.example.hr.application.openpi.WeatherClient;
import com.example.hr.dto.openapi.OpenApiDataRequest;
import com.example.hr.dto.openapi.OpenApiDataResponse;
import com.example.hr.exception.BizException;
import com.example.hr.exception.NotFoundException;
import com.example.hr.infra.dto.WeatherRequest;
import com.example.hr.infra.dto.WeatherResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.yaml.snakeyaml.util.UriEncoder;
import reactor.core.publisher.Mono;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class WeatherClientImpl implements WeatherClient {
    private static final String DEFAULT_DATA_TYPE = "JSON";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    //일 2회(06:00,18:00)회 생성 되며 발표시각을 입력 YYYYMMDD0600 (1800)-최근 24시간 자료만 제공
    private static final String TIME_0600 = "0600";
    private static final String TIME_1800 = "1800";
    private static final int DEFAULT_STN_ID = 108; //전국



    private String serviceKey;
    private String baseUrl;
    private WebClient webClient;

    public WeatherClientImpl(@Value("${openapi.service-key}") String serviceKey, @Value("${openapi.weather-base-url}")String baseUrl) {
        this.serviceKey = serviceKey;
        this.baseUrl = baseUrl;
        createWebClient();
    }

    private void createWebClient(){
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);
        webClient = WebClient.builder()
                .uriBuilderFactory(factory)
                .baseUrl(baseUrl)
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Override
    public OpenApiDataResponse getMidFcstData(OpenApiDataRequest request) {

        WeatherRequest weatherRequest = new WeatherRequest(
                request.page(), request.display(), DEFAULT_DATA_TYPE, DEFAULT_STN_ID, requestDate(request.date()));

        WeatherResponse weatherResponse = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/getMidFcst")
                        .queryParams(weatherRequest.convertQueryParams())
                        .queryParam("ServiceKey", serviceKey )
                        .build()
                )
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .block();
        if (weatherResponse == null){
            throw new BizException("데이터를 가져오지 못했습니다.");
        }

        if (weatherResponse.response().body() == null){
            return weatherResponse.convertFailedResponse();
        }
        return weatherResponse.convertResponse();
    }

    private String requestDate(LocalDateTime dateTime){
        LocalDateTime date_0600 = LocalDateTime.of(LocalDate.from(dateTime), LocalTime.of(6,0));
        LocalDateTime date_1800 = LocalDateTime.of(LocalDate.from(dateTime), LocalTime.of(18,0));
        if (dateTime.isBefore(date_0600)){
            return dateTime.minusDays(1L).toLocalDate().format(DATE_TIME_FORMATTER)+TIME_1800;
        }

        if(dateTime.isBefore(date_1800)){
            return dateTime.toLocalDate().format(DATE_TIME_FORMATTER)+TIME_0600;
        }

        return dateTime.toLocalDate().format(DATE_TIME_FORMATTER)+TIME_1800;
    }
}
