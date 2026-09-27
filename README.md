# 🏧 ATM Simulation System

A simple **Console-Based ATM Simulation System** developed using **Java**.  
This project demonstrates a basic ATM workflow with separate **Customer** and **Admin** operations through a menu-driven console interface.

---

## 📌 About the Project

The ATM Simulation System is a Java console application created to practice **Core Java** and **Object-Oriented Programming** concepts.

The application provides different options for customers and administrators, allowing users to perform common ATM-related operations such as checking balance, depositing money, withdrawing money, changing PIN, and managing customer details.

---

## ✨ Features

### 👤 Customer Operations
- Customer Login
- Check Account Balance
- Deposit Money
- Withdraw Money
- Change PIN
- Exit Customer Menu

### 👨‍💼 Admin Operations
- Admin Login
- View Customer Details
- Search Customer
- Register New Customer
- Update Customer Details
- Delete Customer Account
- Reset Customer PIN
- Deposit Money
- Withdraw Money
- View Transactions
- Exit Admin Menu

---

## 🛠️ Technologies Used

- **Java**
- **Object-Oriented Programming**
- **Java Scanner**
- **Console-Based User Interface**
- **Console Colors**

---

## 📂 Project Structure

```text
ATMProject/
│
├── Admin.java
├── ATM.java
├── Customer.java
├── ConsoleColors.java
├── .gitignore
└── README.md
```

---

## 🧩 Classes

### `ATM.java`
The main class of the project. It displays the main ATM menu and provides options for Admin Login, Customer Login, and Exit.

### `Admin.java`
Handles the administrative section of the ATM system and provides customer management and administrative operations.

### `Customer.java`
Handles customer-related operations such as balance checking, deposit, withdrawal, and PIN change.

### `ConsoleColors.java`
Contains console color codes used to improve the appearance and readability of terminal output.

---

## 🔄 Application Flow

```text
                    ┌──────────────────┐
                    │    ATM SYSTEM    │
                    └────────┬─────────┘
                             │
                             ▼
                    ┌──────────────────┐
                    │    MAIN MENU     │
                    └────────┬─────────┘
                             │
              ┌──────────────┼──────────────┐
              ▼              ▼              ▼
        Admin Login     Customer Login      Exit
              │              │
              ▼              ▼
        Admin Menu      Customer Menu
              │              │
              ▼              ▼
     Admin Operations  Customer Operations
```

---

## ▶️ How to Run

### 1. Install Java

Make sure Java JDK is installed on your system.

Check the installation:

```bash
java -version
javac -version
```

### 2. Open the Project

Open the `ATMProject` folder in VS Code, IntelliJ IDEA, Eclipse, or another Java-supported IDE.

### 3. Compile the Project

Open the terminal inside the project folder and run:

```bash
javac *.java
```

### 4. Start the ATM

```bash
java ATM
```

---

## 💻 Main Menu

```text
====================================
        WELCOME TO ATM
====================================

1. Admin Login
2. Customer Login
3. Exit

Enter your choice:
```

---

## 🎯 Learning Objectives

This project was created to practice:

- Core Java Programming
- Object-Oriented Programming
- Classes and Objects
- Inheritance
- Constructors
- Methods
- Conditional Statements
- Loops
- User Input Handling
- Menu-Driven Applications
- Basic ATM Workflow

---

## 🚀 Future Improvements

Possible improvements for future versions include:

- Secure authentication
- Stronger PIN validation
- Improved transaction management
- Complete transaction history
- Better exception handling
- Automatic account number generation
- Graphical User Interface (GUI)
- Database integration

---

## 👨‍💻 Author

**Saif Anwar**

Java Developer | Student

---

## 📄 License

This project is created for **educational and learning purposes**.
