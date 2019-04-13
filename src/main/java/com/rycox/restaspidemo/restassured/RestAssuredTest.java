package com.rycox.restaspidemo.restassured;


import com.rycox.restaspidemo.restassured.api.DummyRestExampleApi;
import com.rycox.restaspidemo.restassured.api.MockApi;
import com.rycox.restaspidemo.restassured.configuration.EnvironmentConfiguration;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {EnvironmentConfiguration.class})
@TestPropertySource("classpath:test-${test.environment}.properties")
public abstract class RestAssuredTest {


    @Autowired
    public MockApi mockApi;

    @Autowired
    public DummyRestExampleApi dummyApi;
}
