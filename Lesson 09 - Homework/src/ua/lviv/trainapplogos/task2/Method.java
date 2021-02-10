package ua.lviv.trainapplogos.task2;

public class Method {
	private double arg1 = 0;
	private double arg2 = 0;

	public void setArguments(double arg1, double arg2) throws IllegalAccessException, MyException  {
		if ((arg1 < 0) && (arg2 < 0)) {
			throw new IllegalArgumentException();
		} else if ((arg1 == 0) && (arg2 != 0) || (arg1 != 0) && (arg2 == 0)) {
			throw new ArithmeticException();
		} else if ((arg1 == 0) && (arg2 == 0)) {
			throw new IllegalAccessException();
		} else if ((arg1 > 0) && (arg2 > 0)) {
			throw new MyException("<MyException>");
		}; 
		
		this.arg1 = arg1;
		this.arg2 = arg2;
	}

	public double add(){
		return arg1 + arg2;
	}
	
	public double minus() {
		return arg1 - arg2;
	}
	
	public double multiply() {
		return arg1 * arg2;
	}
	
	public double divide() {
		return arg1 / arg2;
	}
	
	public double GetArg1() {
		return this.arg1;
	}
	
	public double GetArg2() {
		return this.arg2;
	}
}
