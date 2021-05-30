# Expleo Technical Test
XE currency Convertor

## Tools & Technologies
* Selenium with Java
* Maven (Dependency management)
* Cucumber (Project framework: BDD)
* Junit (Test execution)
* Extent Report (Reporting tool)

## Setup the Solution
Import maven project from Github using IDE import. Build the solution with the IDE so maven will automatically download the required project dependencies. (install Maven and Cucumber plugin in IDE if not installed)

## Project Structure
Following Maven Project structure hence Generic classes, PageObject classes, feature file, configs, runner clases are separted and placed under the respective folders.

![Project Structure](https://github.com/avnishpatel26/Expleo/blob/main/Images/ProjectStructure.JPG)

## Test
Feature file [XE_Currency_Converter.feature](https://github.com/avnishpatel26/Expleo/blob/main/src/test/resources/features/XE_Currency_Converter.feature) has been provided tag **@xeConvertCurrency** to run the test. 

![FeatureFile](https://github.com/avnishpatel26/Expleo/blob/main/Images/FeatureFile.JPG)

To execute the test, go to [WebTestRunner.java](https://github.com/avnishpatel26/Expleo/blob/main/src/test/java/runner/WebTestRunner.java) class under '/src/test/java/runner/WebTestRunner.java' and provide the tag under tags field and run the class as Jnuit Test.

![RunnerClass](https://github.com/avnishpatel26/Expleo/blob/main/Images/RunnerTestClass.JPG)


## Report
Once the test run is completed, inside the project folder go to '/target/cucumber-reports/report.html' where **Extent** will be generated. Sample Extent Report is already placed in the '/target/cucumber-report' folder in solution. Report is fed with Gherkin steps and description  about what is tested under the steps.

![Extent Report](https://github.com/avnishpatel26/Expleo/blob/main/Images/ExtentReport.JPG)
