package com.techelevator;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SalaryCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your employee Id: ");
        int employeeId = input.nextInt();

        System.out.print("Enter hourly rate: ");
        double hourlyRate = input.nextDouble();

        System.out.print("Enter hours worked in a week: ");
        int hoursWorkedPerWeek = input.nextInt();

        System.out.print("Enter weeks worked in a month: ");
        int weeksWorkedPerMonth = input.nextInt();

        System.out.print("Enter promotion amount (if none, enter 0): ");
        double promotionAmount = input.nextDouble();

        double grossSalary = (hourlyRate * hoursWorkedPerWeek * weeksWorkedPerMonth) + promotionAmount;
        double taxDeduction = 0.2 * grossSalary;
        double pensionDeduction = 0.1 * grossSalary;

        double netSalary = grossSalary - taxDeduction - pensionDeduction;

        System.out.println("Employee Id: " + employeeId);
        System.out.printf("Gross salary: $%.2f\n", grossSalary);
        System.out.printf("Tax deduction: $%.2f\n", taxDeduction);
        System.out.printf("Pension deduction: $%.2f\n", pensionDeduction);
        System.out.printf("Net salary: $%.2f", netSalary);

        input.close();
    }
}
