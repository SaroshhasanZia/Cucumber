Feature: Login Action

  Scenario: Successful Login with Valid Credentials
    Given User open browser
    When User Navigate login page as "https://test-tvs.dnow.com/login"
    And User enters UserName as "sadmin" and Password as "Dnow!2345"
    Then Message displayed is "success"
    And close the browser


  Scenario: UnSuccessful Login with InValid Password
    Given User open browser
    When User Navigate login page as "https://test-tvs.dnow.com/login"
    And User enters UserName as "sadmin" and Password as "Dnow!234590"
    Then Message displayed is "The username or password you entered is incorrect."
    And close the browser


  Scenario: UnSuccessful Login with InValid username
    Given User open browser
    When User Navigate login page as "https://test-tvs.dnow.com/login"
    And User enters UserName as "sadminook" and Password as "Dnow!2345"
    Then Message displayed is "The username or password you entered is incorrect."
    And close the browser