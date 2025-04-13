# 💱 Java Currency Exchange App (MySQL + XAMPP)

A simple Java-based currency exchange application that uses a MySQL database to store and retrieve exchange rates. This project demonstrates basic Java + JDBC + MySQL integration and runs on a local server using XAMPP.

---

## 🚀 Features

- 🔁 Convert one currency to another using stored exchange rates
- 📊 View all available conversion rates
- ✏️ Add or update rates directly in the MySQL database
- 🧠 Clean, beginner-friendly code with CLI interface

---

## 🛠 Technologies Used

- Java (Core + JDBC)
- MySQL (via XAMPP)
- Command-line interface

---

## 🧩 Database Schema

**Table: `currency_rates`**

| Column         | Type        | Description               |
|----------------|-------------|---------------------------|
| id             | INT (PK)    | Unique identifier         |
| from_currency  | VARCHAR     | Source currency (e.g., USD) |
| to_currency    | VARCHAR     | Target currency (e.g., EUR) |
| rate           | DOUBLE      | Conversion rate           |

---

## 📂 Folder Structure

CurrencyExchangeApp/ ├── src/ │ ├── Main.java │ ├── DatabaseConnector.java │ └── CurrencyConverter.java ├── currency_db.sql ├── .gitignore └── README.md


---

## ⚙️ Setup Instructions

1. Start **Apache** and **MySQL** from **XAMPP**.
2. Import `currency_db.sql` using **phpMyAdmin** or MySQL CLI.
3. Open `DatabaseConnector.java` and update database credentials if needed.
4. Compile and run the application:

```bash
javac Main.java
java Main


