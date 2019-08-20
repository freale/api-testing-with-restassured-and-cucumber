Feature:
  Verify different GET operations using Rest-assured

  Scenario: Verify one dog name of the post
    Given I perform GET operation "/pet/810"
    Then I should see the author name as "doggie"

  Scenario: Verify pets that have been sold
    Given I perform GET a operation "/get"
    And I perform GET for status "sold"
    Then I should see the pets names "doggie" and "Charlie"

  Scenario: Verify Parameters of GET
    Given I perform GET operation
    Then I should see verify GET Parameter

  Scenario: Verify POST operation
    Given I perform a POST operation for the store