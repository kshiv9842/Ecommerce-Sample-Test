**🛒eCommerce Website Automation with Selenium in Java**


**📖 Project Overview**

This automation project simulates an Amazon-like eCommerce website. It includes end-to-end tests that cover basic user flows such as login, product search, adding items to the cart, and managing delivery addresses. Selenium WebDriver is used for interacting with the UI, while TestNG is used for organizing and executing test cases. The project also integrates Allure for detailed and visually appealing reports.


**🔧 Prerequisites**

Before you begin, ensure you have met the following requirements:

**☕ Java Development Kit (JDK):** Version 8 or later.

**🐱 Maven:** For managing dependencies and running tests.

**📊 Allure:** Installed for generating reports (brew install allure or download from Allure website).

**🌐 Browser WebDriver:** ChromeDriver, GeckoDriver, or another relevant WebDriver for your browser.

**💻 IDE:** Any Java-supported IDE (IntelliJ IDEA, Eclipse, etc.).


**📝 Test Cases Automated**

The following test cases have been automated:


**🔑 Login:** Verifies the user login functionality.

**🏠 Homepage Navigation:** Validates navigation on the homepage and checks elements like banners and categories.

**🔍 Product Search and Listing:** Tests searching for products and verifying the product listing page.

**📄 Product Details:** Opens a product's details page and verifies the content.

**🛒 Add to Cart:** Adds products to the shopping cart and verifies the cart functionality.

**📦 Choose Address:** Select an address from the available saved addresses during checkout.


**📂 Key Packages**

**org.Shiv.Pom:** Contains Page Object Model classes for interacting with UI elements. 

**org.Shiv.actions:** Contains action classes that handle the logic for performing user actions on the web pages. 

**org.Shiv.data:** Contains test data and data-driven logic. 

**org.Shiv.driver:** Manages WebDriver initialization and other driver-related actions. 

**org.Shiv.tests:** Test classes written using TestNG. 


