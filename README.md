# WEB Automation - Java - Webdriver - Cucumber

[![Build Status](https://travis-ci.com/jkbhatnagar/wx-web-automation-bdd.svg?branch=develop)](https://travis-ci.com/jkbhatnagar/wx-web-automation-bdd)

## USAGE

### Travis CI Builds

    https://travis-ci.com/jkbhatnagar/wx-web-automation-bdd/builds

### Run Locally:
 - Pre-requisites: java version 1.9, jdk version 1.9, maven (optional), internet access, 
 - Download or clone the 'develop' branch locally.
 - Run Smoke TC : Running without local maven : 
 
     ```./mvnw clean test -Dcucumber.filter.tags="@SmokeTest" -Dbrowser=chrome -Dexemode=local -Dosname=mac```
 - Run Smoke TC : Running from local maven : 
 
    ```mvn clean test -Dcucumber.filter.tags="@SmokeTest" -Dbrowser=chrome -Dexemode=local -Dosname=mac```

### Reports:
 - Cucumber report is generated and report url is printed at end of the run
 - Report provides detailed scenarios and step execution summary, with passed - failed - skipped results

### Maintenance:
- Don't change RunCucumberTest, cucumber.properties
- Add global constants to src/test/java/utils/UtilConstants.
- Add new Cucumber feature files to src/test/features.
- Add new Step Definition files to src/test/stepdefs.
- Add new Page Object files to src/test/java/pages.

## TASK LIST

### Assumtions
- [x] I chose any first two available summer dresses to order.
- [x] I supported only Chrome browser - version 86. I didn't test on Windows as I use Mac.
- [x] I registered an account in advance and used it for login and placing order.
- [x] I choose any first 2 summer dresses. Did not add criteria to choose dresses - like color, title, size.
- [x] As currently only single scenario, I kept all step definitions in 1 file.
- [x] I did not check contents of each screen in detail. Did not add verification of Order total or Order Item details.
- [x] For some reason functionality to scroll to a WebElement did not work. So I used to alternatively use scrollByPixels. Will fix the issue later. 
- [x] All Pages are in WebDriver Page Object format and self explainatory. All class names are PascalCase, method and variable names follow camelCase and are verbose. 
- [x] I did not add comments as the code itself is well organised and simple.
- [x] I used Cucumber Reports which are generated and uploaded to Cucumber portal - for quick work. A report link is printed in run logs.

### Completed
- [x] Add Cucumber support
- [x] Add Cucumber Outline support
- [x] Add Selenium WebDriver support
- [x] Add Cucumber Report support
- [x] Use Cucumber @Tags to categorize Test Scenarios into @SmokeTest and @RegressionTest
- [x] Read constants and globals from Constants.java or a .properties file

### Pending
- [ ] Add descriptive comments.
- [ ] Export json and cucumber reports to S3 buckets.
- [ ] Use cucumber-picocontainer to add Dependency Injection to share in-flight test objects between test cases
- [ ] Split Step definition and feature for different services to separate files
- [ ] Create model POJO classes for Success and Failure responses and extract response in the for advanced assertions, path assertions, and sharing objects between in-flight test cases
- [ ] Use ThreadLocal to allow parallel execution of test scenarios
- [ ] Add support for more browsers like Firefox and Windows Edge
- [ ] Page content - add more checks for page contents like order items, price total, delivery address etc
- [ ] Add support for local reports using EXTENT REPORTS or ALLURE REPORTS frameworks.
- [ ] Add support for screenshots and videos
- [ ] Add test scenario for different address for delivery
- [ ] Add test scenario for account registration
- [ ] Add test scenario to choose dresses based on different criteria
- [ ] Add test scenario to choose selective dresses and specify color and size
- [ ] Add test scenario to check order history
- [ ] Data drive the test scenario using Scenario Outline data table
- [ ] Add XPATH and CSS Selectors in an external file (NOT A BIG FAN of that approach)
- [ ] Move common tasks and assertions to utility class

## RESOURCE REFERENCES
- Cucumber base

        https://github.com/cucumber/cucumber-java-skeleton

- Samples

        https://github.com/angiejones/restassured-with-cucumber-demo
        
- Technical Articles

        https://github.com/jaganduraisamy/RestAssured-BDD-Java/blob/master/src/test/java/utilities/Utils.java
        https://www.coveros.com/using-dependency-injectors-simplify-code-cucumber/
        http://www.thinkcode.se/blog/2017/04/01/sharing-state-between-steps-in-cucumberjvm-using-picocontainer
        https://devhints.io/xpath
        https://codoid.com/new-methods-in-webdriver-expectedconditions-class/
        https://www.guru99.com/scroll-up-down-selenium-webdriver.html
        https://www.seleniumeasy.com/selenium-tutorials/how-to-perform-mouseover-action-in-selenium-webdriver
        
        
