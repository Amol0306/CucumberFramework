Feature: Search and place the order for products

@PlaceOrder
Scenario: Search Experiance for product search in both home and offers page

Given User is on GreenCart landing page
When User serched with short name <Name> and extracted actual name of product
And Added "3" items of the selected product to the cart
Then User proceed to checkout and validate the <Name> items in check out page
And verify user has ability to enter promo code and place the order

Examples:
| Name |
| Tom |