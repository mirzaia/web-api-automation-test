package co.project.cucumber.glue;

import co.project.cucumber.client.ApiClient;
import io.cucumber.java.en.When;

public class ApiSteps {
  private static ApiClient apiClient;
  private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ApiSteps.class);

  private synchronized ApiClient getApiClient() {
    if (apiClient == null) {
      apiClient = new ApiClient();
    }
    return apiClient;
  }

  @When("QA trigger API to fetch list of store that serve last mile delivery is {string}")
  public void qaTriggerApiToListOfStore(String customerCollection) {
    boolean canCustomerCollect = Boolean.parseBoolean(customerCollection);
    String result = getApiClient().getDistributionPoints(canCustomerCollect);
    logger.info("API Response: {}", result);
  }
}
