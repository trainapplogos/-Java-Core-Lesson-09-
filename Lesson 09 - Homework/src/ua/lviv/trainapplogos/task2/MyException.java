package ua.lviv.trainapplogos.task2;

public class MyException extends Exception {
	private String message;
	
	public MyException(String message) {
		super(message + " - Hello from class MyException");
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
