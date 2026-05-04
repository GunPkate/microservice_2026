package com.gunp.microservice.product;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductApplicationTests {

	@ServiceConnection
	static MongoDBContainer mongoDBContainer= new MongoDBContainer("mongo:7.0.5");

	@LocalServerPort
	Integer port;

	@BeforeEach
	void setup(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	@Test
	void testCreateProduct() {
		String reqBody = """
				{
					"name": "IPhone 15",
					"description": "IPhone 15 is a smartphone from Apple.",
					"price": 25000
				}
				""";
		RestAssured.given()
				.contentType("application/json")
				.body(reqBody)
				.when()
				.post("api/product")
				.then()
				.statusCode(201)
				.body("id", Matchers.notNullValue())
				.body("name",Matchers.anything())
				.body("description",Matchers.anything())
				.body("price",Matchers.anything())

		;
	}

}
