# Project Reflection

## How can I ensure that my code, program, or software is functional and secure?

### I can ensure that my software is functional by developing tests that directly correspond to its requirements and testing both expected and unexpected inputs. In this project, I used JUnit 5 to verify the Contact, Task, and Appointment services, including successful operations, boundary conditions, null values, invalid inputs, and duplicate IDs. Code coverage also helped me identify whether important portions of the application were being exercised by my tests. To improve security, I can validate all inputs, prevent invalid data from entering the application, follow secure coding practices, and incorporate additional techniques such as security testing as the complexity and risk of an application increase.

## How do I interpret user needs and incorporate them into a program?

###I interpret user needs by translating requirements into specific behaviors that the software must provide. For example, the customer specified limits for IDs, names, descriptions, phone numbers, addresses, and appointment dates. I translated each requirement into validation logic within the appropriate class and created unit tests to verify that the requirement was satisfied. Breaking larger customer requirements into smaller, testable conditions helps me ensure that the final implementation reflects what the customer actually requested rather than assumptions about what the software should do.

## How do I approach designing software?

### I approach software design by first understanding the requirements and then separating the application into components with clear responsibilities. For this project, the Contact, Task, and Appointment objects were responsible for maintaining valid data, while their corresponding service classes handled operations such as adding, deleting, and updating objects. I also focused on reducing repeated code, choosing appropriate data structures such as Map for storing objects by unique ID, and writing automated tests alongside the implementation. This approach makes the software easier to understand, test, maintain, and expand as requirements change.
