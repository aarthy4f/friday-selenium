friday-selenium Framework
---

---
 The friday-selenium framework based on Page Object Model, Selenium, TestNG using Java.

The framework uses:

1. Java
2. Selenium
3. TestNG
4. ExtentReport
5. Log4j
6. circleCI Integration

**Execution**
•	Clone the repository.
•	Open command prompt and go to project directory.
•	Run mvn clean install -Dbrowser=chrome
•	By default tests are run using Google Chrome.
Browser	Example
Chrome	-Dbrowser=chrome
Firefox	-Dbrowser=firefox
Edge	- Dbrowser=edge


**Architecture Diagram:**
![image](https://user-images.githubusercontent.com/56670845/159425660-b14028dc-a06f-4814-80b8-ff51e83398f0.png)






Reporting
---
The framework gives report in two ways,

1. Log - In file `logfile.log`.
2. A html report - Which is generated using extent reports, under the folder `ExtentReports`.

**Screenshot**
![image](https://user-images.githubusercontent.com/56670845/159425834-d9f68733-2c61-4497-82ae-7798f558138b.png)

Execution steps
![image](https://user-images.githubusercontent.com/56670845/159425868-aa583803-55be-4091-bc2f-a4aea1555a32.png)


---
**CircleCI Integration**
https://app.circleci.com/pipelines/github/aarthy4f/friday-selenium/45/workflows/b0cd9930-1f53-4e24-9f59-b4b53b5a4645/jobs/46/artifacts

