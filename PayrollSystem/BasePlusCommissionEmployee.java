package PayrollSystem;

/** BasePlusCommissionEmployee class derived from CommissionEmployee. */
public class BasePlusCommissionEmployee extends CommissionEmployee {
	
	/** Base salary per week. */
	private double baseSalary;

	/** Add a commission base plus employee with twelve arguments.
	 * @param first			The string first name.
	 * @param last			The string last name.
	 * @param ssn			The string social security number.
	 * @param birthMonth	The integer birth month.
	 * @param birthDay		The integer birth day.
	 * @param birthYear		The integer birth year.
	 * @param startMonth	The integer start month.
	 * @param startDay		The integer start day.
	 * @param startYear		The integer start year.
	 * @param sales			The double type data sales.
	 * @param rate			The double type data rate.
	 * @param salary		The double type data salary. */
	public BasePlusCommissionEmployee(String first, String last, String ssn,
			int birthMonth, int birthDay, int birthYear,
			int startMonth, int startDay, int startYear,
			double sales, double rate, double salary) {
		super(first, last, ssn, birthMonth, birthDay, birthYear, startMonth, startDay, startYear, sales, rate);
		setBaseSalary(salary);
	} // end constructor

	/** Set base salary.
	 * @param salary	The double type data salary. */
	public void setBaseSalary(double salary) {
		baseSalary = salary < 0.0 ? 0.0 : salary;
	} // end method setBaseSalary

	/** Return base salary.
	 * @return	baseSalary */
	public double getBaseSalary() {
		return baseSalary;
	} // end method getBaseSalary

	/** Calculate earnings.
	 * 	Override method earnings in CommissionEmployee.
	 * @return Calculated earnings. */
	@Override
	public double earnings() {
		return getBaseSalary() + super.earnings();
	} // end method earnings

	/** Return String representation of BasePlusCommissionEmployee object.
	 * @return A string representation of BasePlusCommissionEmployee object. */
	@Override
	public String toString() {
		return String.format("%s %s; %s: ₩%,.2f", 
				"base-salaried", super.toString(), 
				"base salary", getBaseSalary());
	} // end method toString
	
} // end class BasePlusCommissionEmployee
