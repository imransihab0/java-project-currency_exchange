# 💱 Currency Exchange to BDT (Java + MySQL + XAMPP)

A simple Java console app that connects to a MySQL database (via XAMPP) to manage and convert top foreign currencies to BDT 🇧🇩.

> 🎯 Perfect for students or beginners learning JDBC + MySQL + Java projects!

---

## ✨ Features

🔹 View all exchange rates  
🔹 Add new currency & rate 💹  
🔹 Update currency rates 🔧  
🔹 Delete currency ❌  
🔹 Convert any amount of a currency to BDT 💰  
🔹 MySQL database integration via JDBC 🔗  

---

## 🧰 Tech Stack

🧠 **Language**: Java (JDK 8+)  
🗄️ **Database**: MySQL (via XAMPP)  
🔌 **Connector**: JDBC (`mysql-connector-j`)  
🖥️ **Interface**: Console-based UI  

---

## 🛠️ Getting Started

### ✅ Prerequisites

- Java installed (`java -version`)
- XAMPP installed and running (MySQL)
- MySQL JDBC Connector (`mysql-connector-j-9.2.0.jar`) included in the project

---

## 🗃️ Database Setup

1. 🔥 Start **XAMPP** → Start **MySQL**
2. 🌐 Go to `http://localhost/phpmyadmin`
3. 📥 Import `currencydb.sql`
4. ✅ Done! Your DB and table are ready.

---

## 🏗️ Project Structure

``` CurrencyExchangeJavaProject/ ├── Main.java // 💻 App entry point ├── DBConnection.java // 🔌 MySQL connection handler ├── CurrencyService.java // 📦 Logic for all features ├── currencydb.sql // 🗃️ Database + table + sample data ├── mysql-connector-j-9.2.0.jar // 🧪 JDBC Driver └── README.md // 📖 You are here ```

---

## ⚙️ Setup Instructions

1. Start **Apache** and **MySQL** from **XAMPP**.
2. Import `currency_db.sql` using **phpMyAdmin** or MySQL CLI.
3. Open `DatabaseConnector.java` and update database credentials if needed.
4. Compile and run the application:

```bash
javac Main.java
java Main


