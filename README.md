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

Architecture Diagram:
![image](https://user-images.githubusercontent.com/56670845/159148023-b4d1970e-92db-47ec-8d87-818fcbb01746.png)





Reporting
---
The framework gives report in three ways,

1. Log - In file `logfile.log`.
2. A html report - Which is generated using extent reports, under the folder `ExtentReports`.
3. A mail report - For which the toggle `mail.sendmail` in `test.properties` should be set `true`. And all the properties such as `smtp host, port, proxy details, etc.,` should be provided correctly.

---


