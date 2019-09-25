package MorseTranslator;

import java.util.Scanner;
import java.util.regex.*;  

public class MorseTranslator {
	
	protected static Type type;
	protected static String input;
	protected static String translation;
		
	public static void main(String[] args) {
		
		getInput();
		
		translate();
		
		viewTranslation();
		
	}
	
	private static void getInput() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Tell me what to translate!");
		String text = scanner.nextLine();
		getType(text);
		
		input = text;
		
		scanner.close();
	}
	
	private static void getType(String text) {
				
		TypeCheckerService service = new TypeCheckerService(text);
		type = service.getType();
	}
	
	
	private static void translate() {
		
		Translator translator = new Translator(type, input);
		
		translation = translator.getTranslation();
	}
	
	private static void viewTranslation() {
		System.out.println(translation);
	}
	
	
	
	
}
