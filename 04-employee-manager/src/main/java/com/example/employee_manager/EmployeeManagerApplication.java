package com.example.employee_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagerApplication.class, args);
	}

}


/**
 * Consult GPT for best practices
 * [x] TODO 1: DTO for allowance, deduction, periods and records
 * 		- how do I want my data to be represented?
 *
 * 		Class name: EmployeePayrollDto
 * 		Payroll Records Per employee
 * 			-employee id
 * 			-name
 * 			-List of all payroll records dto: EmployeePayrollRecordDto
 *
 * 		Class name: PeriodPayrollDto
 * 		Payroll Records per payroll period
 * 			- payroll record id
 * 			- payroll period start - end dates
 * 			- List of all payroll periods dto: PeriodPayrollRecordDto
 * 				- employee name
 * 				- payment date
 * 				- gross pay
 * 				- allowance sum
 * 				- deductions sum
 * 				- net pay
 * 				- notes
 *	Q: What about objects that have dependencies like Payroll Periods for Payroll Records?
 *    - it will be set in the service layer I guess.
 *
 * [x] TODO 2: mappers
 * [x] TODO 3: PayrollRecordService Class
 *
 *  Problem : App is not displaying the correct deductions and allowances for the corresponding record					__SOLVED__
 *  Problem : App is returning null records when collecting records by payroll periods									__SOLVED__
 * GET /api/payroll-summary/period?startDate=2025-08-01&endDate=2025-08-15
 *
 * 	Problem : Must return a list, the current implementation is returning the first one it can find
 *
 *
 */