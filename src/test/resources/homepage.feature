Feature: Login

  @Web
  Scenario: Enter Store Web App - Search order with tracking ID on the homepage
    When QA go to website "https://point.ninjavan.co/"
    And QA input username "username" and password "password"
    And QA click Submit button on the login page
    And QA search order with tracking ID "trackingId" and make sure that the order is found

  @Api
  Scenario: Fetch the list of store that serve last mile delivery
    When QA trigger API to fetch list of store that serve last mile delivery is "true"

  @Run
  Scenario: User login to Swag Labs
    When QA go to website "https://www.saucedemo.com/"
    And QA input username "standard_user" and password "secret_sauce"
    And QA click Submit button on the login page
    And QA verify if user arrived at homepage