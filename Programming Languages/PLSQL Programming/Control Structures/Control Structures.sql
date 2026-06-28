-- ==========================================
-- EXERCISE 1 : CONTROL STRUCTURES
-- ==========================================

-- ==========================================
-- TABLE CREATION
-- ==========================================

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID)
    REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID)
    REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID)
    REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

-- ==========================================
-- ALTER TABLE FOR SCENARIO 2
-- ==========================================

ALTER TABLE Customers
ADD IsVIP VARCHAR2(10);

-- ==========================================
-- SAMPLE DATA INSERTION
-- ==========================================

INSERT INTO Customers
VALUES (
1,
'John Doe',
TO_DATE('1985-05-15','YYYY-MM-DD'),
1000,
SYSDATE
);

INSERT INTO Customers
VALUES (
2,
'Jane Smith',
TO_DATE('1990-07-20','YYYY-MM-DD'),
1500,
SYSDATE
);

INSERT INTO Accounts
VALUES (
1,
1,
'Savings',
1000,
SYSDATE
);

INSERT INTO Accounts
VALUES (
2,
2,
'Checking',
1500,
SYSDATE
);

INSERT INTO Transactions
VALUES (
1,
1,
SYSDATE,
200,
'Deposit'
);

INSERT INTO Transactions
VALUES (
2,
2,
SYSDATE,
300,
'Withdrawal'
);

INSERT INTO Loans
VALUES (
1,
1,
5000,
5,
SYSDATE,
ADD_MONTHS(SYSDATE,60)
);

INSERT INTO Employees
VALUES (
1,
'Alice Johnson',
'Manager',
70000,
'HR',
TO_DATE('2015-06-15','YYYY-MM-DD')
);

INSERT INTO Employees
VALUES (
2,
'Bob Brown',
'Developer',
60000,
'IT',
TO_DATE('2017-03-20','YYYY-MM-DD')
);

COMMIT;

-- ==========================================
-- SCENARIO 1
-- ==========================================


SET SERVEROUTPUT ON;

BEGIN

FOR rec IN (
    SELECT c.CustomerID,
           l.LoanID,
           TRUNC(
               MONTHS_BETWEEN(
                   SYSDATE,
                   c.DOB
               ) / 12
           ) AS Age
    FROM Customers c
    JOIN Loans l
    ON c.CustomerID = l.CustomerID
)
LOOP

    IF rec.Age > 60 THEN

        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = rec.LoanID;

        DBMS_OUTPUT.PUT_LINE(
            'Discount Applied To Customer ID : '
            || rec.CustomerID
        );

    END IF;

END LOOP;

COMMIT;

END;
/
-- No customer satisfies Age > 60

-- ADD TEST DATA
INSERT INTO Customers
VALUES (
3,
'Robert Wilson',
TO_DATE('1950-01-01','YYYY-MM-DD'),
12000,
SYSDATE
);

INSERT INTO Loans
VALUES (
2,
3,
10000,
8,
SYSDATE,
ADD_MONTHS(SYSDATE,24)
);

COMMIT;
-- Run The PL/SQL Block Again


-- =====================================================
-- SCENARIO 2
-- =====================================================

--ADD NEW COLUMN
ALTER TABLE Customers
ADD IsVIP VARCHAR2(10);

-- PL/SQL BLOCK
SET SERVEROUTPUT ON;

BEGIN

FOR rec IN (
    SELECT CustomerID,
           Balance
    FROM Customers
)
LOOP

    IF rec.Balance > 10000 THEN

        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = rec.CustomerID;

        DBMS_OUTPUT.PUT_LINE(
            'Customer '
            || rec.CustomerID ||
            ' Promoted To VIP'
        );

    END IF;

END LOOP;

COMMIT;

END;
/

-- No customer has balance greater than 10000.

-- UPDATE EXISTING CUSTOMER FOR TESTING


UPDATE Customers
SET Balance = 15000
WHERE CustomerID = 1;

COMMIT;

--Run the PL/SQL Block Again

-- =====================================================
-- SCENARIO 3
-- =====================================================

-- PL/SQL BLOCK

SET SERVEROUTPUT ON;

BEGIN

FOR rec IN (
    SELECT c.CustomerID,
           c.Name,
           l.LoanID,
           l.LoanAmount,
           l.EndDate
    FROM Customers c
    JOIN Loans l
    ON c.CustomerID = l.CustomerID
    WHERE l.EndDate BETWEEN
          SYSDATE
          AND
          SYSDATE + 30
)
LOOP

    DBMS_OUTPUT.PUT_LINE(
        'REMINDER: Dear '
        || rec.Name ||
        ' (Customer ID: '
        || rec.CustomerID ||
        '), your loan (Loan ID: '
        || rec.LoanID ||
        ') of amount '
        || rec.LoanAmount ||
        ' is due on '
        || TO_CHAR(
            rec.EndDate,
            'DD-MON-YYYY'
           ) ||
        '. Please repay on time.'
    );

END LOOP;

END;
/
-- No loan is due within the next 30 days.

-- UPDATE EXISTING LOAN FOR TESTING

UPDATE Loans
SET EndDate = SYSDATE + 20
WHERE LoanID = 1;

--Run the PL/SQL Again
