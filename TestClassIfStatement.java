package fr.inria.gforge.spoon;

public class TestClassIfStatement {
	
	public String testMethodIfStatement(int a, int b) {
		if (a >= b) {
			return "a is greater than b";
		} else if (a <= b) {
			return ("a is less than b");
		} else if (a == b) {
			return ("a is equal to b");
		} else if (a != b) {
			return ("a is not equal to b");
		}
		
		System.out.println("my name is this ");
		
		if (a <= b || a >= b) {
			return ("Locical OR");
		} else if (a >= b && a<=b){
			return ("Logical And");
		}
		else if (!(a < b) ||  (a > b)){
			return ("Logical NOT");
		}
		return null;
	}
}
