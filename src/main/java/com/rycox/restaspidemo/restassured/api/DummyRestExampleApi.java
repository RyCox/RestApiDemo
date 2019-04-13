package com.rycox.restaspidemo.restassured.api;

import com.rycox.restaspidemo.restassured.domain.Employee;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class DummyRestExampleApi {

    @Value("${dummy.rest.url}")
    private String dummyApiUrl;

    public Response getEmployees() {
        return given().get(dummyApiUrl + "/employees");
    }

    public Response getEmployeeById(String id) {
        return given().get(dummyApiUrl + "/employee/" + id);
    }

    public Response createEmployee(Employee employee) {
        return given().body(employee)
                .post(dummyApiUrl + "/create");
    }

}
