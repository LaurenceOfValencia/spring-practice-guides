INSERT INTO employees(name, date_hired, position, active) VALUES ('Arvin Soria', '2008-11-11', 'partsman', true );
INSERT INTO employees(name, date_hired, position, active) VALUES ('Maribelle Dupalco', '2007-11-12', 'secretary', true );

INSERT INTO payroll_periods(start_date, end_date, status) VALUES ('2025-08-01', '2025-08-15', 'CLOSED');
INSERT INTO payroll_periods(start_date, end_date, status) VALUES ('2025-08-16', '2025-08-31', 'CLOSED');
INSERT INTO payroll_periods(start_date, end_date, status) VALUES ('2025-09-01', '2025-09-15', 'CLOSED');
INSERT INTO payroll_periods(start_date, end_date, status) VALUES ('2025-09-16', '2025-09-30', 'CLOSED');
INSERT INTO payroll_periods(start_date, end_date, status) VALUES ('2025-10-01', '2025-10-15', 'OPEN');
INSERT INTO payroll_periods(start_date, end_date, status) VALUES ('2025-10-16', '2025-10-31', 'OPEN');
INSERT INTO payroll_periods(start_date, end_date, status) VALUES ('2025-11-01', '2025-11-15', 'OPEN');
INSERT INTO payroll_periods(start_date, end_date, status) VALUES ('2025-11-16', '2025-11-30', 'OPEN');
INSERT INTO payroll_periods(start_date, end_date, status) VALUES ('2025-12-01', '2025-12-15', 'OPEN');
INSERT INTO payroll_periods(start_date, end_date, status) VALUES ('2025-12-16', '2025-12-31', 'OPEN');


INSERT INTO payroll_records(period_id, employee_id, gross_pay, net_pay, payment_date) VALUES (1, 1, 8020.23, 7555.32, '2025-08-15');
INSERT INTO payroll_records(period_id, employee_id, gross_pay, net_pay, payment_date) VALUES (2, 1, 9320.23, 5436.23, '2025-08-30');
INSERT INTO payroll_records(period_id, employee_id, gross_pay, net_pay, payment_date) VALUES (1, 2, 7024.45, 6532.34, '2025-08-15');
INSERT INTO payroll_records(period_id, employee_id, gross_pay, net_pay, payment_date) VALUES (2, 2, 6001.25, 420, '2025-08-30');

-- Arvin deduction
INSERT INTO deductions(record_id, type, amount) VALUES (1, 'SSS', 850);
INSERT INTO deductions(record_id, type, amount) VALUES (1, 'PAGIBIG loan', 1999.99);
INSERT INTO deductions(record_id, type, amount) VALUES (2, 'Cash Advance', 200);
-- Maribelle deduction
INSERT INTO deductions(record_id, type, amount) VALUES (3, 'SSS', 550);
INSERT INTO deductions(record_id, type, amount) VALUES (3, 'Cash Advance', 5000);

-- Arvin allowance
INSERT INTO allowances(record_id, type, amount) VALUES (1, 'COLA', 500);
-- Maribelle allowance
INSERT INTO allowances(record_id, type, amount) VALUES (3, 'COLA', 500);
