package PayrollSystem;

/** HourlyEmployee class derived from Employee. */
public class HourlyEmployee extends Employee {
	
	/** Wage per hour. */
	private double wage;
	
	/** Hours worked for week. */
	private double hours;

	/** Add a hourly employee with ten arguments.
	 * @param first			The string first name.
	 * @param last			The string last name.
	 * @param ssn			The string social security number.
	 * @param birthMonth	The integer birth month.
	 * @param birthDay		The integer birth day.
	 * @param birthYear		The integer birth year.
	 * @param startMonth	The integer start month.
	 * @param startDay		The integer start day.
	 * @param startYear		The integer start year.
	 * @param hourlyWage	The double type data hourly wage.
	 * @param hoursWorked	The double type data hours worked. */
	public HourlyEmployee(String first, String last, String ssn,
			int birthMonth, int birthDay, int birthYear,
			int startMonth, int startDay, int startYear, 
			double hourlyWage, double hoursWorked) {
		super(first, last, ssn, birthMonth, birthDay, birthYear, startMonth, startDay, startYear); 
		setWage(hourlyWage);
		setHours(hoursWorked);
	} // end constructor

	/** Set wage.
	 * @param hourlyWage	The double type data hourly wage. */
	public void setWage(double hourlyWage) {
		wage = hourlyWage < 0.0 ? 0.0 : hourlyWage;
	} // end method setWage

	/** Return wage.
	 * @return	wage */
	public double getWage() {
		return wage;
	} // end method getWage

	/** Set hours worked.
	 * @param hoursWorked	The double type data hours worked. */
	public void setHours(double hoursWorked) {
		hours = ((hoursWorked >= 0.0) && (hoursWorked <= 168.0)) ? hoursWorked : 0.0;
	} // end method setHours

	/** Return hours worked.
	 * @return	hours */
	public double getHours() {
		return hours;
	} // end method getHours

	/** Calculate earnings.
	 *  Override abstract method earnings in Employee. 
	 * @return wage * hours if no overtime, or increased earnings if it is. */
	@Override
	public double earnings() {
		if (getHours() <= 40) // no overtime
			return getWage() * getHours();
		else
			return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
	} // end method earnings
	
	/** Return String representation of HourlyEmployee object.
	 * @return A string representation of HourlyEmployee object. */
	@Override
	public String toString() {
		return String.format("hourly employee: %s\n%s: ₩%,.2f; %s: %,.2f", 
				super.toString(), "hourly wage", getWage(), 
				"hours worked", getHours());
	} // end method toString
	
} // end class HourlyEmployee
