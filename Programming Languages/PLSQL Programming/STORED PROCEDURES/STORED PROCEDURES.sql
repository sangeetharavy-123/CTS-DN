-- =====================================================
-- SCENARIO 1
-- =====================================================

-- STORED PROCEDURE

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN

    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

END;
/

--Execute Procedure

EXEC ProcessMonthlyInterest;

--Verify Result

SELECT AccountID,
       CustomerID,
       AccountType,
       Balance
FROM Accounts;

-- =====================================================
-- SCENARIO 2
-- =====================================================

--Stored Procedure 

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percent IN NUMBER
)
AS
BEGIN

    UPDATE Employees
    SET Salary = Salary +
                 (Salary * p_bonus_percent / 100)
    WHERE Department = p_department;

    COMMIT;

END;
/

--Execute Procedure

EXEC UpdateEmployeeBonus('IT',10);

--Verify Result

SELECT EmployeeID,
       Name,
       Department,
       Salary
FROM Employees;

-- =====================================================
-- SCENARIO 3
-- =====================================================

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_source_account IN NUMBER,
    p_target_account IN NUMBER,
    p_amount IN NUMBER
)
AS

    v_balance NUMBER;

BEGIN

    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_source_account;

    IF v_balance >= p_amount THEN

        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_source_account;

        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_target_account;

        DBMS_OUTPUT.PUT_LINE(
            'Transfer Successful'
        );

        COMMIT;

    ELSE

        DBMS_OUTPUT.PUT_LINE(
            'Insufficient Balance'
        );

    END IF;

END;
/

--Execute Procedure
SET SERVEROUTPUT ON;

EXEC TransferFunds(1,2,500);

--Verify Result
SELECT AccountID,
       Balance
FROM Accounts;

--Test Insufficient Balance
EXEC TransferFunds(1,2,5000);