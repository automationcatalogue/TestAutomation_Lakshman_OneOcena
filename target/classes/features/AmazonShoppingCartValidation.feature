Feature: Amazon Shopping Cart feature

@AmazonShoppingCartValidation
Scenario: Amazon Shopping Cart Validation
  Given User navigates to Amazon website
  When User Searches for "Teddy bear"
  And User Sort results according to the Customer Review
  And  User Selects the Age range between "5 to 7 Years" old
  Then User adds first "2" items in his cart
  And Validate the Shopping Cart with two added items


