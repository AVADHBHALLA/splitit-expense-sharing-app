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

<img width="1920" height="1080" alt="balance" src="https://github.com/user-attachments/assets/08776a1d-bb6d-4cf2-9ed4-78e145ba2695" />
<img width="1920" height="1080" alt="expense" src="https://github.com/user-attachments/assets/c577264e-7c7f-4e62-b996-ce19ce520050" />
<img width="1920" height="1080" alt="user" src="https://github.com/user-attachments/assets/bc93a5bf-bdc7-4d59-825c-1c8f7fbfb6cf" />
<img width="1920" height="1080" alt="h2" src="https://github.com/user-attachments/assets/cc063578-aa50-4bfb-802c-ceeafd81487b" />




