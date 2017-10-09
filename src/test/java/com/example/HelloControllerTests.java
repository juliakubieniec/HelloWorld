package com.example;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by user on 08.10.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTests {

    @LocalServerPort
    private int port;

    private URL url;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUrl() throws MalformedURLException {
       this.url = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void getHello() {
        ResponseEntity<String> responseEntity = template.getForEntity(url.toString(), String.class);
        assertThat(responseEntity.getBody(), equalTo("Greetings from Spring Boot!"));
    }
}
