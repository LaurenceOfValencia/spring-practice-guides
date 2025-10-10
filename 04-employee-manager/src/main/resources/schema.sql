DROP TABLE IF EXISTS employees CASCADE;
DROP TABLE IF EXISTS payroll_periods CASCADE;
DROP TABLE IF EXISTS payroll_records CASCADE;
DROP TABLE deductions IF EXISTS;
DROP TABLE allowances IF EXISTS;

CREATE TABLE employees (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    date_hired DATE NOT NULL,
    position VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE payroll_periods (
    id INT NOT NULL AUTO_INCREMENT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    status ENUM('OPEN', 'CLOSED'),
    PRIMARY KEY (id)
);

CREATE TABLE payroll_records (
    id INT NOT NULL AUTO_INCREMENT,
    period_id INT NOT NULL,
    employee_id INT NOT NULL,
    gross_pay DECIMAL(10, 2) NOT NULL,
    net_pay DECIMAL(10,2) NOT NULL,
    payment_date DATE NOT NULL,
    notes VARCHAR(255) NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (period_id) REFERENCES payroll_periods(id),
    FOREIGN KEY (employee_id) REFERENCES employees(id)
);

CREATE TABLE deductions (
    id INT NOT NULL AUTO_INCREMENT,
    record_id INT NOT NULL,
    type VARCHAR(255) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (record_id) REFERENCES payroll_records(id)
);

CREATE TABLE allowances (
    id INT NOT NULL AUTO_INCREMENT,
    record_id INT NOT NULL,
    type VARCHAR(255) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (record_id) REFERENCES payroll_records(id)
);

