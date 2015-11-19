package huffmancoding;

import huffmancoding.HuffmanTreeNode;
import huffmancoding.HuffmanPriorityQueue;
import huffmancoding.HuffmanCharacter;

import java.util.Arrays;

public class HuffmanTree {
	private HuffmanTreeNode root;
	private char[] input;
	private char[] inputUnique;
	private int[] frequency;
	private String[] codes;
	private String encodedMessage;
	
	public HuffmanTree() {} //This is *that* kind of class...

	public HuffmanTree(String string)  {
		input = string.toCharArray();
		inputUnique = unique(input);
		frequency = frequency(inputUnique, input);
		
		HuffmanPriorityQueue queue = new HuffmanPriorityQueue();
		
		for(int i = 0; i < inputUnique.length; i++) {
			queue.queue(new HuffmanTreeNode(new HuffmanCharacter(Character.toString(inputUnique[i]), frequency[i]), null, null));
		}
		
		HuffmanTreeNode one = null;
		HuffmanTreeNode two = null;
		
		while(queue.getSize() != 1) {
			one = queue.dequeue();
			two = queue.dequeue();
			queue.queue(new HuffmanTreeNode(new HuffmanCharacter(one.getCharacter().getString() + two.getCharacter().getString(), 
																 one.getCharacter().getFrequency() + two.getCharacter().getFrequency()), 
						                                         one, two));
		}
		root = queue.dequeue();
		codes = new String[inputUnique.length];
		calculateCodes();
		encodedMessage = encode(input, codes);
	}
	
	private String encode(char[] input, String[] codes) {
		String message = "";
		for(int i = 0; i < input.length; i++) {
			message += codes[indexOf(inputUnique, input[i])];
		}
		return message;
	}
	
	public String decode(String inputCoded) {
		String message = "";
		String temp = null;
		int count = 1;
		int index = 0;
		while(inputCoded.length() != 0) {
			temp = inputCoded.substring(0, count);
			index = indexOf(codes, temp);
			if(index != -1) {
				inputCoded = inputCoded.substring(count);
				message += inputUnique[index];
				count = 1;
				index = 0;
			}
			else {
				count++;
			}
		}
		return message;
	}

	/*new*///Can we take this out? Put it another class? BETTER! PUT IN HuffmanCoding.class! But I'm too lazy.
	public static String decode(String inputCoded, String[] codes, String[] inputUnique) {
		String message = "";
		String temp = null;
		int count = 1;
		int index = 0;
		while(inputCoded.length() != 0) {
			temp = inputCoded.substring(0, count);
			index = indexOf(codes, temp);
			if(index != -1) {
				inputCoded = inputCoded.substring(count);
				//if(inputUnique[index] == "\0") { //Why? Not needed, NUL characters are stripped in input.
				//	break;
				//}
				message += inputUnique[index];
				//System.out.println(message);
				//System.out.println(inputCoded);
				count = 1;
				index = 0;
			}
			else {
				count++;
			}
		}
		return message;
	}
	
	public void printCodes() {
		printCodes(root, "");
	}
	
	private void printCodes(HuffmanTreeNode node, String code) {
		if(node.getLeft() == null && node.getRight() == null) {
			HuffmanCharacter tmp = node.getCharacter();
			System.out.println(tmp.getString() + "\t" + tmp.getFrequency() + "\t" + code);
		}
		else {
			//go left
			printCodes(node.getLeft(), code + "0");
			//go right
			printCodes(node.getRight(), code + "1");
		}
	}
	
	private void calculateCodes() {
		calculateCodes(root, "");
	}
	
	private void calculateCodes(HuffmanTreeNode node, String code) {
		if(node.getLeft() == null && node.getRight() == null) {
			HuffmanCharacter tmp = node.getCharacter();
			int index = indexOf(inputUnique, tmp.getString().toCharArray()[0]);
			codes[index] = code;
		}
		else {
			//go left
			calculateCodes(node.getLeft(), code + "0");
			//go right
			calculateCodes(node.getRight(), code + "1");
		}
	}
	
	private static char[] unique(char[] input) {
		char[] inputUnique = new char[input.length];
		int count = 0;
		boolean unique = true;
		
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < count; j++) {
				if(input[i] == inputUnique[j]) {
					unique = false;
					break;
				}
				unique = true;
			}
			if(unique) {
				inputUnique[count++] = input[i];
			}
			unique = true;
		}
		
		return Arrays.copyOfRange(inputUnique, 0, count);
	}
	
	private static int[] frequency(char[] inputUnique, char[] input) {
		int[] frequency = new int[inputUnique.length];
		int count = 0;
		for(int i = 0; i < frequency.length; i++) {
			for(int j = 0; j < input.length; j++) {
				if(inputUnique[i] == input[j]) {
					count++;
				}
			}
			frequency[i] = count;
			count = 0;
		}
		return frequency;
	}

	private static int indexOf(char[] input, char key) {
		int index = -1;
		for(int i = 0; i < input.length; i++) {
			if(input[i] == key) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	private static int indexOf(String[] string, String key) {
		int index = -1;
		for(int i = 0; i < string.length; i++) {
			if(string[i].equals(key)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public String[] getCodes() {
		return codes;
	}
	
	public char[] getCharacters() {
		return inputUnique;
	}

	public String getEncodedMessage() {
		return encodedMessage;
	}
}
