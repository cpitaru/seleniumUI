Meta:

Narrative: As a user, I want to add a product to my Wishlist

Scenario: Add a product to Wishlist
Given I open ALTEX home page
And I open login dropdown
And I enter valid email address
And I enter valid password
And I click on login button
When I search after a product
And I add the product to my Wishlist
And I click on user dropdown
And select Wishlist option
Then the product was added to my Wishlist
