Feature: Online Shop Store Order
	In order to shop from convenience of home
	As an online customer
	I want to be able to add 2 items to the cart and place an order

	@SmokeTest
	Scenario: Existing customer to order two Summer Dresses from online store
		Given I open a browser and launch the application
		And I am on Home Page
		And I sign in using username and password
		And I choose Dresses menu
		And I choose Summer Dresses subcategory
		And I am on SUMMER DRESSES screen
		When I add first dress to cart
		And I choose to Continue Shopping
		And I add second dress to cart
		And I choose to Proceed to checkout to cart summary
		And I am on SHOPPING-CART SUMMARY screen
		And I choose to Proceed to checkout to cart address
		And I am on ADDRESS screen
		And I choose to Proceed to checkout to cart shipping
		And I am on SHIPPING screen
		And I choose to Proceed to checkout to cart payment
		And I am on PAYMENT screen
		And I choose to Bankwire payment
		And I am on ORDER SUMMARY screen
		And I confirm order
		Then I am on ORDER CONFIRMATION screen
