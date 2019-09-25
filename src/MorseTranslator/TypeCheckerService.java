package MorseTranslator;

public class TypeCheckerService {

	protected String text;
	
	public TypeCheckerService(String _text) {
		text = _text;
	}
	
	public Type getType() {
		
		if(text.matches("[\\.\\-\\s/]+")) {
			if(text.matches("[^\\w\\d]+")) {
				return Type.MORSE;
			}
		}
		
		return Type.ABC;
	}
}
