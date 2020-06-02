Meta:

Narrative: As a user, I want to access my account after performing login action

Scenario: Login with valid credentials
Given I open ALTEX home page
And I open login dropdown
And I enter valid password
When I enter valid email address
And I click on login button
And I access Sumar cont page
Then I verify that Cosmin Test is displayed
