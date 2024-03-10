# UI Test Automation with Selenium

This project automates UI tests for the Sauce Demo website (https://www.saucedemo.com/) using Selenium WebDriver.

![img.png](img.png)

## Test Cases

1. **Login**: Verify login functionality with valid credentials.
2. **Add Items to Cart**: Add items to the cart and verify they are added successfully.
3. **Enter Shipping Details**: Enter shipping details and proceed to checkout.
4. **Verify Checkout Overview Page**: Verify the details displayed on the Checkout Overview page.
5. **Complete the Purchase**: Complete the purchase process and verify the confirmation message.

**Note: All the test cases are implemented in the SauceDemoTests class.**

## Prerequisites

Before running the tests, make sure you have the following installed:

* Java Development Kit (JDK)
* IntelliJ IDEA or any Java IDE of your choice
* WebDriver for Chrome (chromedriver)
* TestNG
* Maven

### How to Run the Project

1. Clone or download the project from the repository.
2. Open the project in IntelliJ IDEA or your preferred IDE.
3. Ensure that the required dependencies are resolved by Maven.
4. Open the SauceDemoTests class.
5. Right-click on the class and select "Run" to execute all the test cases.

### Configuration

- If needed, update the path to the chromedriver executable in the setUp() method of the SauceDemoTests class.
- You can customize the test data or add more test cases as per your requirements.

## Further Development Plans

#### 1. Page Object Model (POM)

   Implement the Page Object Model pattern to improve test maintenance and readability. Define separate page classes for different pages of the application to encapsulate the page elements and related actions.

#### 2. Reporting with Extent Reports

   Integrate Extent Reports to generate comprehensive and interactive HTML reports for test execution results. Extent Reports provide detailed information about test cases, including pass/fail status, screenshots, and logs.

#### 3. Data-Driven Testing with Excel

   Implement data-driven testing using Excel files to parameterize test cases with different sets of test data. Read test data from Excel sheets and use it to drive test execution, enabling efficient testing with multiple input combinations.

