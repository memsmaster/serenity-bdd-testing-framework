# Serenity-BDD-Testing-Framework

UI/API Test Automation example using Serenity BDD, Cucumber and the Page Object Model.



* [Application under the Test] (#Application under the Test)
* [Example Scenarios to Automate] (#Example Scenarios to Automate)
* [Project Structure]([## Project Structure]())
* [Running the Rests with Maven]([## Running the Tests with Maven]())
* [Viewing the test reports]([## Viewing the Test Reports]())
* [Adding Tests]([## Adding Tests]())
* [Resources]([## Resources]())


<!--te-->

## Application under the Test

We will be testing the following website: https://automationexercise.com

## Example Scenarios to Automate

UI- user registration, navigation
API-Get (product list) and POST (searched product)

## Project Structure
```
src/main/resources/features 
    └── ApiTest.feature 
    └── UiTest.feature # **Features:** Directory for Cucumber feature files, each containing scenarios written in Gherkin
```

```
src/main/java/com
├── serenitybdd.actions # Action classes for UI/API interactions
├── serenitybdd.config # config file for setup and constants
├── serenitybdd.pages # Page Object classes including page elements
└── serenitybdd.stepdefinitionss # Step definition classes for scenarios
```
```

src/test/java/com.serenitybdd.test
└── CucumberTestSuite # Uses Serenity BDD features to run tests and generate detailed reports
└── TestRunner # runs both UI and API
```
```

Pom.xml
```

## Running the Tests with Maven

To run the tests with Maven, open the terminal and run (on Mac):

```
mvn clean verify

```

## Viewing the Test Reports

After running the tests, Serenity BDD reports are generated in HTML format and can be found in the target/site/serenity directory. Open index.html in a web browser to view detailed test reports including test results, screenshots.

## Adding Tests

To expand the tests in the future:


1. **Add Scenarios in Feature Files:**
   - Create or update `.feature` files under `features/` with new scenarios using Gherkin syntax.

2. **Create Steps in Respective Step Definition Classes:**
   - For UI tests, create or update step definitions in `stepdefinions/UIStepDefs.java`.
   - For API tests, create or update step definitions in `stepdefinions/APIStepDefs.java`.

3. **Add Page Elements in Respective Page Classes:**
   - Update or create new Page Object classes in `pages/` to represent new UI components or pages.

4. **Add Actions in Respective Action Classes:**
   - Update or create new actions/methods in `actions/` to define actions that can be performed on pages.

## Resources
https://github.com/serenity-bdd

https://serenity-bdd.github.io/docs/tutorials/first_test

https://serenity-bdd.github.io/docs/tutorials/rest

https://www.youtube.com/watch?v=Us1b191D6pQ

