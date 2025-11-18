package co.project.cucumber.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClient {

  public ApiClient() {
  }

  public String getDistributionPoints(boolean canCustomerCollect) {
    String path = "https://api-sandbox.ninjavan.co/sg/2.1/pudos";

    RequestSpecification request = RestAssured
        .given()
        .queryParam("can_customer_collect", canCustomerCollect);

    Response response = request
        .when()
        .get(path)
        .then()
        .statusCode(200)
        .extract()
        .response();

    if (response.statusCode() != 200) {
      throw new RuntimeException("unexpected http status: " + response.statusCode());
    } else {
      return response.asString();
    }
  }
}
