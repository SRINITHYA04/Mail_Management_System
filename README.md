# 📧 Mail Management System – Project Specification

A **console-based Mail Management System** implemented in Java that allows users to manage emails in a secure and user-friendly way. This project covers key concepts such as authentication, data isolation, email operations, and session handling. Each feature is implemented as a separate module.

---

## ✅ Modules and Implementation Conditions

### 1️⃣ **Authentication Module**
#### Features:
- SignUp
- Login
- Logout

#### Conditions:
- **SignUp**
  - Users provide email and password.
  - Passwords are hashed before storing.
  - Email must be unique.
  - A mailbox is created for each new user.
  
- **Login**
  - Users provide email and password.
  - Password is verified against stored hash.
  - Only valid users can log in.
  - Login sets session status to authenticated.

- **Logout**
  - Logs out the currently logged-in user.
  - Ends session but retains mailbox data.

---

### 2️⃣ **Mailbox Module (Per User)**
Each user has a separate `MailManagementSystem`. The mailbox stores emails and allows various operations.

#### Conditions:
- Mailbox must be initialized when the user signs up.
- Only the authenticated user can access their mailbox.

---

### 3️⃣ **Store Email**
#### Features:
- Allows users to store emails by entering sender, receiver, subject, and content.
- Checks for spam keywords (`lottery`, `offer`, `winner`, etc.).
- Emails flagged as spam should be marked accordingly.

#### Conditions:
- Email details are provided by the user.
- Spam detection is performed before storing the email.

---

### 4️⃣ **Delete Email**
#### Features:
- Deletes an email by index from the user's mailbox.

#### Conditions:
- Index must be valid.
- The email list is updated upon deletion.

---

### 5️⃣ **Show MailBox**
#### Features:
- Displays all emails in the user's mailbox.

#### Conditions:
- If no emails exist, show an appropriate message.

---

### 6️⃣ **Add Tags**
#### Features:
- Allows adding a tag to a specific email.

#### Conditions:
- Email index must be valid.
- Tag is stored as metadata associated with the email.

---

### 7️⃣ **Show Statistics**
#### Features:
- Displays total number of emails.
- Allows viewing the most recent `n` emails.

#### Conditions:
- Users specify how many recent emails they want to see.

---

### 8️⃣ **Search Emails**
#### Features:
- Search for emails by keyword in sender, receiver, subject, content, or tags.

#### Conditions:
- Case-insensitive search.
- Display matching emails or a message if none are found.

---

### 9️⃣ **Wildcard Search**
#### Features:
- Allows users to search using patterns (wildcards like `*`).

#### Conditions:
- Wildcard `*` matches any sequence of characters.
- Searches sender, receiver, subject, content, and tags.

---

## ✅ Additional Notes

✔ Each user's mailbox is isolated and stored separately.  
✔ Session management ensures that users can log in, perform operations, and log out without affecting other users.  
✔ The program uses basic hashing (`hashCode`) for demonstration purposes—secure algorithms should be used in production.  
✔ Input validation and error handling are implemented for robustness.

---

## 📂 Suggested Folder Structure
<img width="494" height="335" alt="image" src="https://github.com/user-attachments/assets/ea40156d-c522-4669-8993-4c1e902ab8d6" />


---

### 📦 **models/** – Data Representations
This package contains classes representing core data structures.

#### Files:
- **User.java**  
  Represents a user with email, hashed password, and session state.

- **Mail.java**  
  Represents an email with sender, receiver, subject, content, tags, and spam flag.

---

### 📦 **dao/** – Data Access and Authentication Logic
This package handles interactions related to user management and session tracking.

#### Files:
- **AuthService.java**  
  Manages signup, login, logout, user verification, and mailbox access.

---

### 📦 **system/** – Application Logic and User Interface
This package contains the main application logic and user interactions.

#### Files:
- **MailManagementSystem.java**  
  Implements mailbox operations like storing, deleting, searching emails, adding tags, and showing statistics.

- **MailManager.java**  
  The entry point of the application, handles menus, session management, and user input.






