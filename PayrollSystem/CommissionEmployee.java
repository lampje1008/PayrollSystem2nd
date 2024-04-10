package PayrollSystem;

/** CommissionEmployee class derived from Employee. */
public class CommissionEmployee extends Employee {
	private double grossSales;
	private double commissionRate;

	/** Add a commission employee with eleven arguments.
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
	 * @param rate			The double type data rate. */
	public CommissionEmployee(String first, String last, String ssn,
			int birthMonth, int birthDay, int birthYear,
			int startMonth, int startDay, int startYear,
			double sales, double rate) {
		super(first, last, ssn, birthMonth, birthDay, birthYear, startMonth, startDay, startYear);
		setGrossSales(sales);
		setCommissionRate(rate);
	} // end constructor

	/** Set commission rate.
	 * @param rate	A double type data rate. */
	public void setCommissionRate(double rate) {
		commissionRate = (rate > 0.0 && rate < 1.0) ? rate : 0.0;
	} // end method setCommissionRate

	/** Return commission rate.
	 * @return	commissionRate */
	public double getCommissionRate() {
		return commissionRate;
	} // end method getCommissionRate

	/** Set gross sales amount.
	 * @param sales		The double type data sales. */
	public void setGrossSales(double sales) {
		grossSales = sales < 0.0 ? 0.0 : sales;
	} // end method setGrossSales

	/** Return gross sales amount.
	 * @return	grossSales */
	public double getGrossSales() {
		return grossSales;
	} // end method getGrossSales

	/** Calculate earnings.
	 *  Override abstract method earnings in Employee.
	 * @return	A double type data earnings. */
	@Override
	public double earnings() {
		return getCommissionRate() * getGrossSales();
	} // end method earnings

	/** Return String representation of CommissionEmployee object.
	 * @return	A string representation of CommissionEmployee object. */
	@Override
	public String toString() {
		return String.format("%s: %s\n%s: ₩%,.2f; %s: %.2f", 
				"commission employee", super.toString(), 
				"gross sales", getGrossSales(), 
				"commission rate", getCommissionRate());
	} // end method toString   
	
} // end class CommissionEmployee
