Feature: Web Automation


  Scenario: Ninja Van Point app - Enter Store Web App - Search order with tracking ID on the homepage
    When QA go to website "https://point.ninjavan.co/"
    And QA input username "username" and password "password"
    And QA click Submit button on the login page
    And QA search order with tracking ID "trackingId" and make sure that the order is found

  @Run
  Scenario: Sauce Demo app - User login to Swag Labs
    When QA go to website "https://www.saucedemo.com/"
    And QA input username "standard_user" and password "secret_sauce"
    And QA click Submit button on the login page
    And QA verify if user arrived at homepage