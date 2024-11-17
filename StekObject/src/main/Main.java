package main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrStek<String> stack = new ArrStek<>();;

		stack.push("Hello");
		stack.push("Java");
		stack.push("OOP");
		
		  System.out.println();
	        for (String value : stack) {
	            System.out.println(value);
	        }

	        System.out.println();
	        System.out.println(stack);

	        System.out.println();
	        while (stack.peek() != null) {
	            System.out.println(stack.pop());
	        }
		}
	}

	


