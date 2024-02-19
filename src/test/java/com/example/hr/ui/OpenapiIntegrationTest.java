package com.example.hr.ui;

import com.example.hr.IntegrationTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

public class OpenapiIntegrationTest extends IntegrationTest {

    @Test
    void 현재중기날씨예보_조회_성공() {
        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("openapi/mid-fcst-info")
                .then().log().all()
                .extract();

        조회됨(response);
        assertThat(response.body().jsonPath().getString("code")).isEqualTo("00");

    }
}
