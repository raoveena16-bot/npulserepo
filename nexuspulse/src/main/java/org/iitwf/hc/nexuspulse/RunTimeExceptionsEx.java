package org.iitwf.hc.nexuspulse;

public class RunTimeExceptionsEx {

	static String s;
	public static void main(String[] args) {

		/*try {
			System.out.println(s.length());
		}catch(NullPointerException e)
		{
			System.out.println("object is null" + e.getMessage());
		}
		System.out.println("Execution Continuessssss");*/

		/*try {
			int a=1;
			int b=0;
			int c = a/b;
		}
		catch(ArithmeticException e)
		{
			System.out.println("1/0 is not valid" + e.getMessage());
		}
		System.out.println("Execution Continuessssss");*/
		
		/*double d = Double.parseDouble("23.59$");
		System.out.println(d);*/
		
		String s[] = {"A","B"};
		
		System.out.println(s[2]);
		
		
		
	}
}
