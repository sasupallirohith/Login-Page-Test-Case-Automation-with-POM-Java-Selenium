# Janitri Login Page Automation

## 📋 Project Overview
Automated UI test cases for the Login Page of the Janitri Dashboard using Java, Selenium WebDriver, and TestNG.

## 🧰 Tools & Tech
- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)

## 🗂 Project Structure
```
src
├── main
│   └── java
│       └── pages
│           └── LoginPage.java
├── test
│   └── java
│       └── tests
│           ├── BaseTest.java
│           └── LoginTests.java
pom.xml
```

## ⚙️ How to Run
1. Clone or download the project
2. Import into your Java IDE (e.g., IntelliJ, Eclipse)
3. Run `mvn clean install`
4. Right-click `LoginTests.java` → Run with TestNG

## ✅ Test Scenarios Covered
- Verify login button is disabled when fields are empty
- Invalid login attempts show error message
- Password masking and unmasking toggle
- Presence of input fields, login button, eye icon

---

👨‍💻 Author: Rohith