-- senario 1
BEGIN
    FOR c IN (
        SELECT c.CustomerID, c.DOB
        FROM Customers c
    ) LOOP
        IF FLOOR(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = c.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/

-- senario 2
ALTER TABLE Customers ADD IsVIP CHAR(1);

BEGIN
    FOR c IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF c.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP='Y'
            WHERE CustomerID=c.CustomerID;
        ELSE
            UPDATE Customers
            SET IsVIP='N'
            WHERE CustomerID=c.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/

-- senario 3
BEGIN
    FOR l IN (
        SELECT CustomerID, LoanID, EndDate
        FROM Loans
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE+30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
        'Reminder: Customer '||l.CustomerID||
        ' Loan '||l.LoanID||
        ' is due on '||l.EndDate);
    END LOOP;
END;
/