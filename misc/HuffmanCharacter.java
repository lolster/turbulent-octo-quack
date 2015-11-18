/*
	Interface:
		public HuffmanCharacter(String character, int frequency)
		public static HuffmanCharacter joinCharacters(HuffmanCharacter charOne, HuffmanCharacter charTwo)
		public String getCharacter()
		public String getFrequency()
*/

public class HuffmanCharacter {
	private String character; //can be character or an entire word
	private int frequency;

	public HuffmanCharacter(String character, int frequency) {
		this.character = character;
		this.frequecy = frequency;
	}

	public static HuffmanCharacter joinCharacters(HuffmanCharacter charOne, HuffmanCharacter charTwo) {
		return new HuffmanCharacter(charOne.getCharacter() + charTwo.getCharacter(), charOne.getFrequency() + charTwo.getFrequency());
	}

	public String getCharacter() {
		return this.character;
	}

	public String getFrequency() {
		return this.frequency;
	}
}