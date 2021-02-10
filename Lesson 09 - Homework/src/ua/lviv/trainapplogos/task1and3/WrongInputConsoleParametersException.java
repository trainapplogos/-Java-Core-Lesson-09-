/*
 * Owner's Copyright and so on... (2021)
 * */
package ua.lviv.trainapplogos.task1and3;
/**
 * The {@code WrongInputConsoleParametersException} represents custom exception
 * @author usr
 * @see ua.lviv.trainapplogos.task1and3#WrongInputConsoleParametersException
 * @category Exceptions
 * @version 1.0.0
 * */
public class WrongInputConsoleParametersException extends Exception {
	/* Wrong name of month */
	private String wrongmonth;
	
	/* Constructor */
	public WrongInputConsoleParametersException(String wrongmonth) {
		super("Error: month " + wrongmonth + " doesn't exist"); //Pass error message to Exception class for processing
		this.wrongmonth = wrongmonth;
	}

	/* Getters of wrong name of month*/
	public String getWrongMonth() {
		return wrongmonth;
	}
	
}
