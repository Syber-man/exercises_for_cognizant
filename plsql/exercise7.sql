-- senario 1
CREATE OR REPLACE PACKAGE CustomerManagement AS

PROCEDURE AddCustomer(
id NUMBER,
name VARCHAR2,
dob DATE,
balance NUMBER);

PROCEDURE UpdateCustomer(
id NUMBER,
name VARCHAR2);

FUNCTION GetBalance(
id NUMBER)
RETURN NUMBER;

END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

PROCEDURE AddCustomer(id NUMBER,name VARCHAR2,dob DATE,balance NUMBER)
IS
BEGIN
INSERT INTO Customers
VALUES(id,name,dob,balance,SYSDATE);
END;

PROCEDURE UpdateCustomer(id NUMBER,name VARCHAR2)
IS
BEGIN
UPDATE Customers
SET Name=name
WHERE CustomerID=id;
END;

FUNCTION GetBalance(id NUMBER)
RETURN NUMBER
IS
bal NUMBER;
BEGIN
SELECT Balance INTO bal
FROM Customers
WHERE CustomerID=id;
RETURN bal;
END;

END CustomerManagement;
/

-- senario 2

CREATE OR REPLACE PACKAGE EmployeeManagement AS

PROCEDURE HireEmployee(
id NUMBER,
name VARCHAR2,
position VARCHAR2,
salary NUMBER,
dept VARCHAR2);

PROCEDURE UpdateEmployee(
id NUMBER,
salary NUMBER);

FUNCTION AnnualSalary(
id NUMBER)
RETURN NUMBER;

END;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

PROCEDURE HireEmployee(id NUMBER,name VARCHAR2,position VARCHAR2,salary NUMBER,dept VARCHAR2)
IS
BEGIN
INSERT INTO Employees
VALUES(id,name,position,salary,dept,SYSDATE);
END;

PROCEDURE UpdateEmployee(id NUMBER,salary NUMBER)
IS
BEGIN
UPDATE Employees
SET Salary=salary
WHERE EmployeeID=id;
END;

FUNCTION AnnualSalary(id NUMBER)
RETURN NUMBER
IS
s NUMBER;
BEGIN
SELECT Salary INTO s
FROM Employees
WHERE EmployeeID=id;
RETURN s*12;
END;

END;
/


-- senario 3
CREATE OR REPLACE PACKAGE AccountOperations AS

PROCEDURE OpenAccount(
acc NUMBER,
cust NUMBER,
type VARCHAR2,
bal NUMBER);

PROCEDURE CloseAccount(
acc NUMBER);

FUNCTION TotalBalance(
cust NUMBER)
RETURN NUMBER;

END;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

PROCEDURE OpenAccount(acc NUMBER,cust NUMBER,type VARCHAR2,bal NUMBER)
IS
BEGIN
INSERT INTO Accounts
VALUES(acc,cust,type,bal,SYSDATE);
END;

PROCEDURE CloseAccount(acc NUMBER)
IS
BEGIN
DELETE FROM Accounts
WHERE AccountID=acc;
END;

FUNCTION TotalBalance(cust NUMBER)
RETURN NUMBER
IS
total NUMBER;
BEGIN
SELECT SUM(Balance)
INTO total
FROM Accounts
WHERE CustomerID=cust;

RETURN total;
END;

END;
/