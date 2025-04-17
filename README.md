# 🧑‍💼 Projeto de Gerenciamento de Vendedores (JDBC + MySQL)

Este projeto Java é um sistema simples de gerenciamento de vendedores e departamentos, utilizando JDBC para conexão com o banco de dados MySQL. Foi desenvolvido com fins educacionais para praticar a integração Java + MySQL + DAO.

---

## 🧠 Funcionalidades

- Listar, inserir, atualizar e deletar vendedores
- Listar, inserir, atualizar e deletar departamentos
- Buscar vendedores por departamento
- Integração com banco de dados via JDBC
- Padrão DAO (Data Access Object)

---

## 🛠️ Tecnologias e Ferramentas

- Java 17+ (ou compatível)
- JDBC
- MySQL
- IntelliJ IDEA (ou Eclipse/VSCode)
- Maven (opcional)

---

## 📁 Estrutura do Projeto

```
/src
│
├── db.properties                # Arquivo de configuração (não incluso no Git)
├── db.properties.example        # Modelo do arquivo de configuração
├── application/
│   ├── Program.java             # Classe principal
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
└── db/
    └── DB.java, DBException.java, DBIntegrityException.java
```

---

## 🧩 Configuração do Banco de Dados

Você precisa de um banco de dados MySQL com as seguintes tabelas:

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

## ⚙️ Configurando o projeto

1. **Clone o repositório:**

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

2. **Configure o banco de dados:**

- Crie as tabelas no seu MySQL local
- Insira dados de teste se quiser

3. **Configure o arquivo `db.properties`:**

- Copie o arquivo de exemplo:

```bash
cp db.properties.example db.properties
```

- Edite com suas credenciais locais:

```properties
user=seu_usuario
password=sua_senha
dburl=jdbc:mysql://localhost:3306/seu_banco
useSSL=false
```

---

## 🚀 Como executar

1. Compile o projeto com sua IDE ou com `javac`
2. Execute a classe `Program.java`
3. Interaja com o menu de testes no console

---

## 🔐 Segurança

⚠️ O arquivo `db.properties` está no `.gitignore` e **não é enviado para o repositório**, para evitar vazamento de credenciais.

---

## 📌 Autor

Desenvolvido por [Seu Nome Aqui].

Se tiver dúvidas ou quiser contribuir, sinta-se à vontade para abrir uma *issue* ou *pull request*.

---

## 📜 Licença

Este projeto está sob a licença MIT.
