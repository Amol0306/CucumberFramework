Feature: Search and place the order for products

@OffersPage
Scenario: Search Experiance for product search in both home and offers page

Given User is on GreenCart landing page
When User serched with short name <Name> and extracted actual name of product
Then User searched for <Name> same short name in offers page if product exist
And Validate product namein offers matches with landing page

Examples:
| Name |
| Tom |
| Beet |