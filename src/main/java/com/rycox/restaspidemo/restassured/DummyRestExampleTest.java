package com.rycox.restaspidemo.restassured;

import com.rycox.restaspidemo.restassured.domain.Employee;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DummyRestExampleTest extends RestAssuredTest {

    Employee employeeUnderTest;

    @After
    public void cleanup() {
        if (employeeUnderTest != null) {
            // do my cleanup();
            Response deleteResponse = mockApi.deleteEmployee(employeeUnderTest.getId());
            Assert.assertEquals(200, deleteResponse.getStatusCode());

            mockApi.getSingleEmployee(employeeUnderTest.getId()).then().assertThat().statusCode(404);
        }

    }

    @Test
    public void testEmployees() {
        Response response = mockApi.getEmployees();
        Assert.assertEquals(200, response.getStatusCode());
        List<Employee> employeeList = new ArrayList<>();
        employeeList = response.as(employeeList.getClass());
        Assert.assertTrue(employeeList.size() > 0);
    }

    @Test
    public void testCreateEmployee() {
        employeeUnderTest = createEmployeeObject();
        Response response = mockApi.createEmployee(employeeUnderTest);
        Assert.assertEquals(201, response.getStatusCode());

        employeeUnderTest = response.as(Employee.class);
        Assert.assertNotNull(employeeUnderTest.getId());

        Employee verificationObject = mockApi.getSingleEmployee(employeeUnderTest.getId()).as(Employee.class);
        Assert.assertEquals(employeeUnderTest.getName(), verificationObject.getName());
    }

    @Test
    public void testGetEmployeeByIdNotFoundReturns404() {
        Response response = mockApi.getSingleEmployee("9860");
        Assert.assertEquals(404, response.getStatusCode());
    }

    private Employee createEmployeeObject() {
        Employee employee = new Employee();
        employee.setName("Steve");
        employee.setAge("35");
        employee.setSalary("100000000000");
        return employee;
    }
}
