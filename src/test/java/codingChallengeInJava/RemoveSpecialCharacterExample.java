package codingChallengeInJava;

public class RemoveSpecialCharacterExample {

	public static void main(String args[])   {  
	String str= "I/o:8%$#7d$098g&()_+h%l@";   
	str = str.replaceAll("[^A-Za-z]","");  
	System.out.println("After remove all the special characters : "+str);
	
	char[] nm = str.toCharArray();
	for (int i = (nm.length) - 1; i >= 0; i--) {
		System.out.print(nm[i]);

	}  
}}   //iodghl
