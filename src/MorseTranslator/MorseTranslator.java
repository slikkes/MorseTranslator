package MorseTranslator;

import java.util.Scanner;
import java.util.regex.*;  

public class MorseTranslator {
	
	protected static String input;
	protected static String translation;
	protected static TypeCheckerService typeChecker;
		
	public static void main(String[] args) {
		
		getInput();
		
		translate();
		
		viewTranslation();
		
	}
	
	private static void getInput() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Tell me what to translate!");
		
		input = scanner.nextLine();
		typeChecker = new TypeCheckerService(input);
		
		scanner.close();
	}
	
	
	private static void translate() {
		
		Translator translator = new Translator(typeChecker.getType(), input);
		
		translation = translator.getTranslation();
	}
	
	private static void viewTranslation() {
		System.out.println(translation);
	}
	
	
	
	
}
