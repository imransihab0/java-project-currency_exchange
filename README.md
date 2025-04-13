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

##  📂 Folder Structure

CurrencyExchangeJavaProject/
├── Main.java                  <!-- 💻 App entry point --> <br>
├── DBConnection.java          <!-- 🔌 MySQL connection handler --> <br>
├── CurrencyService.java       <!-- 📦 Logic for all features --> <br>
├── currencydb.sql             <!-- 🗃️ Database + table + sample data --> <br>
├── mysql-connector-j-9.2.0.jar <!-- 🧪 JDBC Driver --> <br>
└── README.md                  <!-- 📖 You are here --> <br>

---

## ⚙️ How to Compile & Run

### 🪟 On Windows CMD:

```bash
javac -cp ".;mysql-connector-j-9.2.0.jar" *.java
java -cp ".;mysql-connector-j-9.2.0.jar" Main
```

### 🍎 On Mac/Linux:

```bat
javac -cp ".:mysql-connector-j-9.2.0.jar" *.java
java -cp ".:mysql-connector-j-9.2.0.jar" Main
```
