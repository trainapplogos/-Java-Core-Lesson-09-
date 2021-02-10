
package ua.lviv.trainapplogos.task2;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) throws IllegalAccessException, MyException {
		Method calc = new Method();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("Enter a: ");
			double arg1 = sc.nextDouble();
			System.out.println("Enter b: ");
			double arg2 = sc.nextDouble();
			
			try {
				calc.setArguments(arg1, arg2);
				printRes(calc);
				/*
				//a>0 ³ b>0 (*MyException)
				calc.setArguments(5, 2);
				printRes(calc);
				
				calc.setArguments(4, -2);
				printRes(calc);
				
				calc.setArguments(-5, 6);
				printRes(calc);
				
				// a<0 ³ b<0 (*IllegalArgumentException)
				calc.setArguments(-9, -12);
				printRes(calc);
				
				//a=0 ³ b!=0 (*ArithmeticException)
				calc.setArguments(0, -18);
				printRes(calc);
				
				//a!=0 ³ b=0 (*ArithmeticException)
				calc.setArguments(3, 0);
				printRes(calc);
				
				//a=0 ³ b=0 (IllegalAccessException)
				calc.setArguments(0, 0);
				printRes(calc);
				*/
				
			} catch (IllegalArgumentException e) {
				System.out.println("Yo have used (a < 0) and (b < 0) \n" + e);
			} catch (ArithmeticException e) {
				System.out.println("Yo have used ((a = 0) and (b != 0)) or ((a != 0) and (b = 0))  \n" + e);
			} catch (IllegalAccessException e) {
				System.out.println("Yo have used (a = 0) and (b = 0) \n" + e);
			} catch (MyException e) {
				System.out.println("Yo have used (a > 0) and (b > 0) \n" + e);
			} 
		}
	}
	
	static void printRes(Method calc) {
		System.out.println(calc.GetArg1() + " + " + calc.GetArg2() + " = " + calc.add()); 
		System.out.println(calc.GetArg1() + " - " + calc.GetArg2() + " = " + calc.minus()); 
		System.out.println(calc.GetArg1() + " * " + calc.GetArg2() + " = " + calc.multiply()); 
		System.out.println(calc.GetArg1() + " / " + calc.GetArg2() + " = " + calc.divide()); 	
		System.out.println("<------------------------------------------------------------>\n");
	}
	

}
