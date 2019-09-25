package MorseTranslator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Translator {
	
	protected Type type;
	protected String text;
	protected Map<String, String> dictionary ;

	
	public Translator(Type type, String text) {
		this.type = type;
		this.text = text;
	}
	
	public String getTranslation() {
		
		this.initDictionary();
		if(type.equals(Type.MORSE)) {
			return this.getAbcFromMorse();
		}
		
		return this.getMorseFromAbc();
	}
	
	private void initDictionary() {
		
		List<String> keys;
		List<String> values;
		
		if(type.equals(Type.ABC)) {
			keys = abc;
			values = morse;
		}else {
			keys = morse;
			values = abc;
		}
		
		dictionary = new HashMap<>();
		   
		int idx = 0;
		for(String item : keys) {
			dictionary.put(item, values.get(idx));
			idx++;
		}
		
	}
	
	private String getMorseFromAbc() {

		String translation  = "";
		for(char character : text.toCharArray()) {
			
			String key = "" + character;
			key = key.toUpperCase();
			
			translation += dictionary.get(key) + " ";
		}
		
		return translation;
	}
	
	
	private String getAbcFromMorse() {
		
		String translation  = "";
		String key = "";
		for(char character : text.toCharArray()) {
			
			if(character == ' ') {
				translation += dictionary.get(key);
				key = "";
			}else {
				key += character;
			}

		}
		
		return translation;
	}
	
	protected List<String> abc = Arrays.asList(
			"A",
			"B",
			"C",
			"D",
			"E",
			"F",
			"G",
			"H",
			"I",
			"J",
			"K",
			"L",
			"M",
			"N",
			"O",
			"P",
			"Q",
			"R",
			"S",
			"T",
			"U",
			"V",
			"W",
			"X",
			"Y",
			"Z",
			"0",
			"1",
			"2",
			"3",
			"4",
			"5",
			"6",
			"7",
			"8",
			"9",
			" "
);
	
	protected List<String> morse = Arrays.asList(
			".-",
			"-...",
			"-.-.",
			"-..",
			".",
			"..-.",
			"--.",
			"....",
			"..",
			".---",
			"-.-",
			".-..",
			"--",
			"-.",
			"---",
			".--.",
			"--.-",
			".-.",
			"...",
			"-",
			"..-",
			"...-",
			".--",
			"-..-",
			"-.--",
			"--..",
			"-----",
			".----",
			"..---",
			"...--",
			"....-",
			".....",
			"-....",
			"--...",
			"---..",
			"----.",
			"/"
	);

	
	
}
