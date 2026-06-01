vwf-coyk-nan

Nitin Jhamnani
1:04 PM
Problem Statement: "SplitIt" (Minimal Expense Sharing App)
Objective: Build a minimal REST API backend using Spring Boot for a simplified expense-sharing application (like Splitwise). The application allows users to log expenses and automatically calculates equal debts among participants.

Nitin Jhamnani
1:16 PM
### Problem Statement: "SplitIt" (Minimal Expense Sharing App)

**Objective:** Build a minimal REST API backend using Spring Boot for a simplified expense-sharing application (like Splitwise). The application allows users to log expenses and automatically calculates equal debts among participants.

---

### What You Need to Develop

1. **Database Models & Relationships:**
* **User:** `id`, `name`, `email`.
* **Expense:** `id`, `description`, `totalAmount`, `payer` (User), and a list of `participants` (Users).


2. **Core Business Logic:**
* When an expense is created, the system must automatically split the total amount **equally** among the payer and all participants to track who owes whom.


3. **REST Endpoints:**
* `POST /api/users` – To create a new user.
* `POST /api/expenses` – To record an expense (takes `payerId`, `amount`, `description`, and a list of `participantIds`).
* `GET /api/users/{id}/balances` – To view how much money this user owes others or is owed by others.


4. **Technical Stack:**
* Spring Boot (Java), Spring Data JPA, and an In-Memory H2 Database.

<img width="1600" height="900" alt="h2" src="https://github.com/user-attachments/assets/78d8839c-9790-41e1-b834-be41ec6dd286" />
<img width="1600" height="900" alt="user" src="https://github.com/user-attachments/assets/75503e9a-e268-4fb5-9c1a-aa5d7cd36c44" />
<img width="1600" height="900" alt="expense" src="https://github.com/user-attachments/assets/0f0781d0-cfd8-44c2-9486-25ac9bdc272c" />
<img width="1600" height="900" alt="balance" src="https://github.com/user-attachments/assets/52970046-1512-4fcb-93ff-35c8e6d20713" />








