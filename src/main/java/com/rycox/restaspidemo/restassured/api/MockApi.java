package com.rycox.restaspidemo.restassured.api;

import com.rycox.restaspidemo.restassured.domain.Employee;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class MockApi {

    @Value("${mock.rest.url}")
    private String mockRestUrl;

    public Response getEmployees() {
        return given().get(mockRestUrl + "/employee");
    }

    public Response getSingleEmployee(String id) {
        return given().get(mockRestUrl + "/employee/" + id);
    }

    public Response createEmployee(Employee employee) {
        return given().contentType("application/json").body(employee).post(mockRestUrl + "/employee");
    }

    public Response deleteEmployee(String id) {
        return given().delete(mockRestUrl + "/employee/" + id);
    }
}
