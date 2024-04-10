package PayrollSystem;

import java.util.Scanner;

/** System for management of employee's pay. */
public class PayrollSystem {
	public static void main(String[] args) {
		// create five-element Employee array
		Employee[] employees = new Employee[5];
		
		// initialize array with Employees
		employees[0] = new SalariedEmployee("John", "Smith", "111-11-1111", 6, 15, 1944, 6, 15, 1974, 800000.00);
		employees[1] = new HourlyEmployee("Karen", "Price", "222-22-2222", 12, 29, 1960, 12, 29, 1990, 16750, 40);
		employees[2] = new CommissionEmployee("Sue", "Jones", "333-33-3333", 9, 8, 1954, 9, 8, 1984, 10000000, .06);
		employees[3] = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 3, 2, 1965, 3, 2, 1995, 5000000, .04, 300000);
		employees[4] = new SalariedEmployee("Dongyeon", "Kim", "555-55-5555", 7, 16, 1945, 7, 16, 1975, 900000.00);
		
		Scanner input = new Scanner(System.in);	// to get current date
		Date date;
		int month, day, year;
		
		// get and validate current date
		do {
			System.out.print("Enter the current month(1-12): ");
			month = input.nextInt();
			System.out.print("Enter the current day(1-31 based on month): ");
			day = input.nextInt();
			System.out.print("Enter the current year: ");
			year = input.nextInt();
			
			date = new Date(month, day, year);
		} while (date.getMonth() != month || date.getDay() != day);
		System.out.println();
		
		for (Employee currentEmployee : employees) {
			System.out.println(currentEmployee); // invokes toString
			
			// determine whether element is a BasePlusCommissionEmployee
			if (currentEmployee instanceof BasePlusCommissionEmployee) {
				// downcast Employee reference to BasePlusCommissionEmployee reference
				BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
				
				double oldBaseSalary = employee.getBaseSalary();
				employee.setBaseSalary(1.10 * oldBaseSalary);
				System.out.printf("new base salary with 10%% increase is: ₩%,.2f\n", employee.getBaseSalary());
			} // end if
			
			// basic pay of employee
			System.out.printf("earned ₩%,.2f\n", currentEmployee.earnings());
			
			// if month of employee's birthday, add ₩100,000
			if (date.getMonth() == currentEmployee.getBirthDate().getMonth())
				System.out.println("plus ₩100,000 birthday bonus");
			
			// if employee worked for more than 10 years, add 10% of employee's pay
			if ((date.getYear() >= currentEmployee.getStartDate().getYear() + 11) ||
					((date.getYear() >= currentEmployee.getStartDate().getYear() + 10) &&
					(date.getMonth() >= currentEmployee.getStartDate().getMonth()) &&
					(date.getDay() >= currentEmployee.getStartDate().getDay())))
				System.out.printf("plus ₩%,.2f for long-term employee\n", currentEmployee.earnings() * 0.10);
			
			System.out.println();
		} // end for
	} // end main
} // end PayrollSystem
