package PayrollSystem;

/** SalariedEmployee class derived from Employee. */
public class SalariedEmployee extends Employee {
	private double weeklySalary;

	/** Add a salaried employee with ten arguments.
	 * @param first			The string first name.
	 * @param last			The string last name.
	 * @param ssn			The string social security number.
	 * @param birthMonth	The integer birth month.
	 * @param birthDay		The integer birth day.
	 * @param birthYear		The integer birth year.
	 * @param startMonth	The integer start month.
	 * @param startDay		The integer start day.
	 * @param startYear		The integer start year.
	 * @param salary		The double type data salary. */
	public SalariedEmployee(String first, String last, String ssn,
			int birthMonth, int birthDay, int birthYear,
			int startMonth, int startDay, int startYear, 
			double salary) {
		super(first, last, ssn, birthMonth, birthDay, birthYear, startMonth, startDay, startYear); 
		setWeeklySalary(salary);
	} // end constructor
	
	/** Set salary.
	 * @param salary	The integer salary. */
	public void setWeeklySalary(double salary) {
		weeklySalary = salary < 0.0 ? 0.0 : salary;
	} // end method setWeeklySalary

	/** Return salary.
	 * @return	A double type data salary. */
	public double getWeeklySalary() {
		return weeklySalary;
	} // end method getWeeklySalary

	/** Calculate earnings.
	 *  Override abstract method earnings in Employee.
	 * @return	A double type data earnings. */
	@Override
	public double earnings() {
		return getWeeklySalary();
	} // end method earnings

	/** Return String representation of SalariedEmployee object
	 * @return A string representation of SalariedEmployee object. */
	@Override
	public String toString() {
		return String.format("salaried employee: %s\n%s: ₩%,.2f",
				super.toString(), "weekly salary", getWeeklySalary());
	} // end method toString  
	
} // end class SalariedEmployee
