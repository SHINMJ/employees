package com.example.hr.ui;

import com.example.hr.IntegrationTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeIntegrationTest extends IntegrationTest {


    @Test
    void 특정사원의_현재정보_조회_성공() {
        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("employees/101")
                .then().log().all()
                .extract();

        조회됨(response);
        assertThat(response.body().jsonPath().getString("firstName")).isEqualTo("Kochhar");
    }

    @Test
    void 특정사원의_이력정보_조회_성공() {
        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("employees/101/history")
                .then().log().all()
                .extract();

        조회됨(response);
        assertThat(response.body().jsonPath().getString("jobId")).isEqualTo("AD_PRES");
    }

    @Test
    void 부서정보와_부서의위치정보목록_조회_성공() {
        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("departments")
                .then().log().all()
                .extract();

        조회됨(response);
    }

    @Test
    void 특정부서정보및위치정보_조회_성공() {
        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("departments/10")
                .then().log().all()
                .extract();

        조회됨(response);
    }

    @Test
    void 위치정보목록_조회_성공() {
        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("locations")
                .then().log().all()
                .extract();

        조회됨(response);
    }

    @Test
    void 특정사원의_부서및위치정보_조회_성공() {
        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("employees/101/departments")
                .then().log().all()
                .extract();

        조회됨(response);
    }

    @Test
    void 특정부서의_급여를_특정비율로인상_성공() {

    }

    @Test
    void 사원_정보_수정_성공() {

    }
}
