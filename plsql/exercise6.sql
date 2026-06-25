-- senario 1
DECLARE
CURSOR GenerateMonthlyStatements IS
SELECT *
FROM Transactions
WHERE EXTRACT(MONTH FROM TransactionDate)=EXTRACT(MONTH FROM SYSDATE);

v_rec Transactions%ROWTYPE;
BEGIN
OPEN GenerateMonthlyStatements;

LOOP
FETCH GenerateMonthlyStatements INTO v_rec;
EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

DBMS_OUTPUT.PUT_LINE(
'Account: '||v_rec.AccountID||
' Amount: '||v_rec.Amount||
' Type: '||v_rec.TransactionType);

END LOOP;

CLOSE GenerateMonthlyStatements;
END;
/

-- senario 2
DECLARE
CURSOR ApplyAnnualFee IS
SELECT AccountID
FROM Accounts;

v_acc NUMBER;
BEGIN

OPEN ApplyAnnualFee;

LOOP
FETCH ApplyAnnualFee INTO v_acc;
EXIT WHEN ApplyAnnualFee%NOTFOUND;

UPDATE Accounts
SET Balance=Balance-500
WHERE AccountID=v_acc;

END LOOP;

COMMIT;
CLOSE ApplyAnnualFee;

END;
/

-- senario 3
DECLARE
CURSOR UpdateLoanInterestRates IS
SELECT LoanID
FROM Loans;

v_id NUMBER;

BEGIN

OPEN UpdateLoanInterestRates;

LOOP

FETCH UpdateLoanInterestRates INTO v_id;
EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

UPDATE Loans
SET InterestRate=InterestRate+0.5
WHERE LoanID=v_id;

END LOOP;

COMMIT;
CLOSE UpdateLoanInterestRates;

END;
/