package PayrollSystem;

/** Employee abstract superclass. */
public abstract class Employee {
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	private Date birthDate;
	private Date startDate;
	
	/** Add an employee with six arguments.
	 * @param first			The string first name.
	 * @param last			The string last name.
	 * @param ssn			The string social security number.
	 * @param birthMonth	The integer birth month.
	 * @param birthDay		The integer birth day.
	 * @param birthYear		The integer birth year.
	 * @param startMonth	The integer start month.
	 * @param startDay		The integer start day.
	 * @param startYear		The integer start year. */
	public Employee(String first, String last, String ssn,
			int birthMonth, int birthDay, int birthYear,
			int startMonth, int startDay, int startYear) {
		firstName = first;
		lastName = last;
		socialSecurityNumber = ssn;
		birthDate = new Date(birthMonth, birthDay, birthYear);
		startDate = new Date(startMonth, startDay, startYear);
	} // end constructor
	
	/** Set first name.
	 * @param first		The string first name. */
	public void setFirstName(String first) {
		firstName = first;
	} // end method setFirstName
	
	/** Return first name.
	 * @return	firstName */
	public String getFirstName() {
		return firstName;
	} // end method getFirstName
	
	/** Set last name.
	 * @param last		The string last name. */
	public void setLastName(String last) {
		lastName = last;
	} // end method setLastName
	
	/** Return last name.
	 * @return	lastName */
	public String getLastName() {
		return lastName;
	} // end method getLastName
	
	/** Set social security number.
	 * @param ssn	The integer social security number. */
	public void setSocialSecurityNumber(String ssn) {
		socialSecurityNumber = ssn;
	} // end method setSocialSecurityNumber

	/** Return social security number.
	 * @return	socialSecurityNumber */
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	} // end method getSocialSecurityNumber
	
	/** Set birth date.
	 * @param month		The integer birth month.
	 * @param day		The integer birth day.
	 * @param year		The integer birth year. */
	public void setBirthDate(int month, int day, int year) {
		birthDate = new Date(month, day, year);
	} // end method setBirthDate

	/** Return birth date.
	 * @return	birthDate */
	public Date getBirthDate() {
		return birthDate;
	} // end method getBirthDate
	
	/** Set start date.
	 * @param month		The integer start month.
	 * @param day		The integer start day.
	 * @param year		The integer start year. */
	public void setStartDate(int month, int day, int year) {
		startDate = new Date(month, day, year);
	} // end method setStartDate

	/** Return start date.
	 * @return	startDate */
	public Date getStartDate() {
		return startDate;
	} // end method getStartDate
	
	/** Return a string representation of Employee object.
	 * @return	A string representation of Employee object. */
	@Override
	public String toString() {
		return String.format("%s %s\n%s: %s\n%s: %s\n%s: %s",
				getFirstName(), getLastName(),
				"social security number", getSocialSecurityNumber(),
				"birth date", getBirthDate(),
				"start date", getStartDate());
	} // end method toString

	/** Abstract method overridden by subclasses.
	 * @return	A double type data earnings. */
	public abstract double earnings();
	// end method earnings
	
} // end class Employee
