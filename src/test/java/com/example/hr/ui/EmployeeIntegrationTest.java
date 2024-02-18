package com.example.hr.ui;

import com.example.hr.IntegrationTest;
import com.example.hr.dto.employee.DepartmentSalaryIncreaseRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeIntegrationTest extends IntegrationTest {


    @Test
    void 특정사원의_현재정보_조회_성공() {
        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("employees/100")
                .then().log().all()
                .extract();

        조회됨(response);
        assertThat(response.body().jsonPath().getString("firstName")).isEqualTo("Steven");
    }

    @Test
    void 특정사원_현재정보_조회_실패_404() {
        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("employees/2")
                .then().log().all()
                .extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    void 특정사원의_이력정보_조회_성공() {
        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("employees/101/history")
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
    void 특정부서의_급여를_특정비율로인상_성공() {
        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(new DepartmentSalaryIncreaseRequest(10.5))
                .when().put("departments/10/salary-increase")
                .then().log().all()
                .extract();

        수정됨(response);
    }

}
