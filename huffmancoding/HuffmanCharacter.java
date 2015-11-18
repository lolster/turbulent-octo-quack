package huffmancoding;

public class HuffmanCharacter {
	private String string;
	private int frequency;
	
	public HuffmanCharacter(String string, int frequency) {
		this.string = string;
		this.frequency = frequency;
	}
	
	public String getString() {
		return string;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public void setString(String string) {
		this.string = string;
	}
	
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
}

//Pretty sure this is not necessary.
