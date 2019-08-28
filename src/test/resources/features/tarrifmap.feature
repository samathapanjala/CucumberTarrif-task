Feature: Add tarrif plans
  
  I want to use this template for my feature files

  @tag1
  Scenario: navigate Congratulationyou add Tariff Plans
    Given User should launch browsers
    And user click add customer links
    When user provide valid detailss
      | MonthlyRental | FreeLocalMinutes | InternationalFreeMinutes | FreeSMSPack | LocalPerMinutesCharges | InternationalPerMinutesCharges | SMSPerCharges |
      |           100 |              200 |                        300 |         400 |                    500 |                             600 |             700 |
      |            50 |              150 |                        250 |         350 |                    450 |                             550 |             650 |
    Then To verify the customer id is displayeds
