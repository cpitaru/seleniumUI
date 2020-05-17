Meta:

Narrative: As a user, I want to add a product to my cart

Scenario: Add a product to Cart
Given I open ALTEX home page
And I open login dropdown
And I enter valid email address
And I enter valid password
And I click on login button
When I search after a product
And I add the product to my Cart
And I close the modal view
Then the modal view is closed and message from Results page is displayed