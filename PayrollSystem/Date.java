package PayrollSystem;

/** Date class declaration with get methods added. */
public class Date {
	private int month;
	private int day;
	private int year;
	
	/** Calls checkMonth to confirm proper value for month. 
	 *  Calls checkDay to confirm proper value for day.
	 * @param theMonth	The integer month value.
	 * @param theDay	The integer day value.
	 * @param theYear	The integer year value. */
	public Date(int theMonth, int theDay, int theYear) {
		month = checkMonth(theMonth);
		year = theYear;
		day = checkDay(theDay);
	} // end constructor
	
	/** Utility method to confirm proper month value.
	 * @param testMonth		The integer month value tested. 
	 * @return	testMonth if testMonth is valid, or 1 if not. */
	private int checkMonth(int testMonth) {
		if (testMonth > 0 && testMonth <= 12)
			return testMonth;
		else {
			System.out.printf("Invalid month (%d) set to 1.\n", testMonth);
			return 1;
		}
	} // end method checkMonth

	/** Utility method to confirm proper day value based on month and year. 
	 * @param testDay	The integer day value tested.
	 * @return	testDay if testDay is valid, or 1 if not. */
	private int checkDay(int testDay) {
		int[] daysPerMonth =
			{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if (testDay > 0 && testDay <= daysPerMonth[month])
			return testDay;
		
		if (month == 2 && testDay == 29 && (year % 400 == 0 ||
				(year % 4 == 0 && year % 100 != 0)))
			   return testDay;
			   
		System.out.printf("Invalid day (%d) set to 1.\n", testDay);
		return 1;
	} // end method checkDay
	
	/** Return day. 
	 * @return	day */
	public int getDay() {
		return day;
	} // end method getDay
	
	/** Return month. 
	 * @return	month */
	public int getMonth() {
		return month;
	} // end method getMonth

	/** Return year. 
	 * @return	year */
	public int getYear() {
		return year;
	} // end method getYear
	
	/** Return a String of the form month/day/year.
	 * @return	A string of the form month/day/year. */
	@Override
	public String toString() {
		return String.format("%d/%d/%d", month, day, year);
	} // end method toString
	
} // end class Date
