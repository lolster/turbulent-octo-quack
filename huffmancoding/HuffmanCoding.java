package huffmancoding;

import huffmancoding.HuffmanTree;
import huffmancoding.BinOut;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.String;
import java.util.Arrays;
import java.util.ArrayList;

public class HuffmanCoding {
	private HuffmanCoding() {} //do not instantiate

	public static File compress(File inputFile) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String temp = "";
		String inputRaw = "";
		
		while( (temp = reader.readLine()) != null) {
			inputRaw += temp + "\n";
		}

		//System.out.println(inputRaw);
		
		inputRaw = inputRaw.substring(0, inputRaw.length() - 1); //Strip the extra '\n' at the end of the string
		
		HuffmanTree tree = new HuffmanTree(inputRaw); //Create huffman tree
		
		//write to <UserFileName>.ar
		File outputFile = new File(inputFile.getName() + ".ar");
		FileWriter writer = new FileWriter(outputFile);
		
		//'\0' is used as the delimiter
		temp = getString(tree.getCharacters());
		//System.out.println(temp);
		writer.write(temp + "\0");
		
		temp = getString(tree.getCodes());
		//System.out.println(temp);
		writer.write(temp + "\0");
		
		temp = tree.getEncodedMessage();
		//System.out.println(temp);
		writer.write(temp + "\0");
		
		reader.close();
		writer.close();
		
		return outputFile;
	}

	public static File decompress(File inputFile, String outputFile) throws Exception {
		FileReader reader = new FileReader(inputFile);

		//Modify this
		String[] uniqueCharacters = split(readLine(reader));
		String[] codes = readLine(reader).split(" ");
		String codedMessage = readLine(reader);
		
		//HuffmanTree tree = new HuffmanTree(); //Create empty huffman tree.

		//Testing purposes
		//System.out.println(Arrays.toString(uniqueCharacters) + "\n" + Arrays.toString(codes) + "\n" + codedMessage);
		
		//Decode the message, returns string of characters
		String decodedMessage = HuffmanTree.decode(codedMessage, codes, uniqueCharacters);

		//Create the file specified by the user (String outputFile) and write to it.
		File file = new File(outputFile);
		FileWriter writer = new FileWriter(file);

		//Testing purposes
		//System.out.println(decodedMessage);

		//Write
		writer.write(decodedMessage);
		
		//Close resources
		writer.close();
		reader.close();
		
		//return user-specified file
		return file;
	}

	/*To read a 'line' (terminated by '\0')*/
	private static String readLine(FileReader reader) throws Exception {
		String temp ="";
		char current;

		//read until '\0'
		while((current = (char)reader.read()) != '\0') {
			temp += current;
		}

		return temp;
	}


	/*Miscallaneous Functions*/
	private static String getString(char[] array) {
		String res = "";
		//System.out.println(Arrays.toString(array));
		for(char object : array) {
			res += object + " ";
			//res += object;
		}
		return res.substring(0, res.length() - 1);
		//return res;
	}

	private static String getString(String[] array) {
		String res = "";
		//System.out.println(Arrays.toString(array));
		for(String object : array) {
			res += object + " ";
			//res += object;
		}
		return res.substring(0, res.length() - 1);
		//return res;
	}

	/*To split the input string from the compresses file into a String[]*/
	private static String[] split(String input) {
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i < input.length(); i+=2) {
			list.add("" + input.charAt(i));
		}
		return list.toArray(new String[list.size()]);
	}
}