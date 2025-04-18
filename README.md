# 🧑‍💼 Seller Management Project (JDBC + MySQL)

This Java project is a simple system for managing sellers and departments using JDBC for MySQL database integration. It was developed for educational purposes to practice Java + MySQL + DAO integration.

---

## 🧠 Features

- List, insert, update, and delete sellers
- List, insert, update, and delete departments
- Search sellers by department
- Database integration using JDBC
- DAO Pattern (Data Access Object)

---

## 🛠️ Technologies and Tools

- Java 17+ (or compatible)
- JDBC
- MySQL
- IntelliJ IDEA (or Eclipse/VSCode)

---

## 📁 Estrutura do Projeto

```
/src
│
├── db.properties                # Configuration file (not included in Git)
├── db.properties.example        # Example config file
│
├── application/
│   ├── Main.java                # Main class
│   ├── menu/
│   │   ├── MainMenu.java
│   │   ├── DepartmentMenu.java
│   │   ├── SellerMenu.java
│   │   ├── Menu.java
│   │   └── MenuException.java
│
├── model/
│   ├── entities/
│   │   ├── Seller.java
│   │   └── Department.java
│   └── dao/
│       ├── SellerDao.java
│       └── DepartmentDao.java
│
├── model/dao/impl/
│   ├── SellerDaoJDBC.java
│   └── DepartmentDaoJDBC.java
│
└── database/
    ├── DbConnection.java
    ├── DbException.java
    └── DbIntegrityException.java
```

---

## 🧩 Database Setup

You need a MySQL database with the following tables:

```sql
CREATE TABLE department (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(60) NOT NULL
);

CREATE TABLE seller (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    Email VARCHAR(100),
    BirthDate DATE,
    BaseSalary DOUBLE,
    DepartmentId INT,
    FOREIGN KEY (DepartmentId) REFERENCES department(Id)
);
```

---

## ⚙️ Project Setup

1. **Clone the repository:**

```bash
git clone https://github.com/your-username/your-repo.git
cd your-repo
```

2. **Set up the database:**

- Create the tables in your local MySQL instance
- Insert test data if desired

3. **Configure the `db.properties` file:**

- Copy the example file:

```bash
cp db.properties.example db.properties
```

- Edit it with your local credentials:

```properties
user=your_user
password=your_password
dburl=jdbc:mysql://localhost:3306/your_database
useSSL=false
```

---

## 🚀 How to Run

1. Compile the project using your IDE or javac
2. Run the Main.java class
3. Interact with the console menu system

---

## 🔐 Security

⚠️ The `db.properties` file is included in `.gitignore` and **will not be pushed to the repository**, to prevent credential leaks.

---

## 📌 Author

Developed by [Yan Pedro Façanha Brasileiro].

If you have any questions or would like to contribute, feel free to open an *issue* or *pull request*.

---

## 📜 License

This project is licensed under the MIT License.
