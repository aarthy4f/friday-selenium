selenium-testng-framework
---

---
A sample framework based on Page Object Model, Selenium, TestNG using Java.

This framework is based in **Page Object Model (POM).**

The framework uses:

1. Java
2. Selenium
3. TestNG
4. ExtentReport
5. Log4j




Reporting
---
The framework gives report in three ways,

1. Log - In file `logfile.log`.
2. A html report - Which is generated using extent reports, under the folder `ExtentReports`.
3. A mail report - For which the toggle `mail.sendmail` in `test.properties` should be set `true`. And all the properties such as `smtp host, port, proxy details, etc.,` should be provided correctly.

---

Key Points:
---

1. The class `WebDriverContext` is responsible for maintaining the same WebDriver instance throughout the test. So whenever you require a webdriver instance which has been using for current test (In current thread) always call `WebDriverContext.getDriver()`.
2. Always use `PageinstancesFactory.getInstance(type)` to get the instance of particular Page Object. (Of course you can use `new` but it's better use a single approach across the framework.

---

>For any query or suggestions please do comment or mail @ diggavibharathish@gmail.com 
