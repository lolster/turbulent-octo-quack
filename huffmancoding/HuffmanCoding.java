package huffmancoding;

import huffmancoding.HuffmanTree;
import huffmancoding.BinOut;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.nio.charset.StandardCharsets;

import java.lang.String;
import java.lang.Integer;

import java.util.Arrays;
import java.util.ArrayList;

public class HuffmanCoding {
	private HuffmanCoding() {} //do not instantiate

	public static File compress(File inputFile) throws Exception {
		//BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8));
		String temp = "";
		String inputRaw = "";
		
		while( (temp = reader.readLine()) != null) {
			inputRaw += temp + "\n";
		}

		System.out.println(inputRaw);
		
		inputRaw = inputRaw.substring(0, inputRaw.length() - 1); //Strip the extra '\n' at the end of the string
		
		HuffmanTree tree = new HuffmanTree(inputRaw); //Create huffman tree
		
		//write to <UserFileName>.ar
		File outputFile = new File(inputFile.getName() + ".ar");
		//FileWriter writer = new FileWriter(outputFile);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.UTF_8));

		//'\0' is used as the delimiter
		temp = getString(tree.getCharacters());
		System.out.println(temp);
		writer.write(temp + "\0");
		
		temp = getString(tree.getCodes());
		System.out.println(temp);
		writer.write(temp + "\0");
		
		//Convert the coded message to UTF8 encoding
		//store the padded amount in file, after the dictionary
		temp = tree.getEncodedMessage();
		System.out.println(temp + "    LENGTH: " + temp.length());
		int paddingAmount = 8 - temp.length() % 8;
		temp = toUTF8Characters(temp);
		System.out.println(temp + "    " + paddingAmount);
		writer.write(paddingAmount + "\0" + temp + "\0");
		
		reader.close();
		writer.close();
		
		return outputFile;
	}

	public static File decompress(File inputFile, String outputFile) throws Exception {
		//FileReader reader = new FileReader(inputFile);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8));

		String[] uniqueCharacters = split(readLine(reader));
		String[] codes = readLine(reader).split(" ");
		int paddedAmount = Integer.parseInt(readLine(reader)); //number of extra 0s padded
		//String codedMessage = readLine(reader); //UTF8 characters
		String codedMessage = readRest(reader); //UTF8 characters

		//Testing purposes
		System.out.println(Arrays.toString(uniqueCharacters) + "\n" + Arrays.toString(codes) + "\n" + codedMessage);
		
		//Takes care of padded 0s
		codedMessage = toBinaryString(codedMessage, paddedAmount);
		System.out.println(codedMessage);

		//Decode the message, returns string of characters
		String decodedMessage = HuffmanTree.decode(codedMessage, codes, uniqueCharacters);

		//Create the file specified by the user (String outputFile) and write to it.
		File file = new File(outputFile);
		//FileWriter writer = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));

		//Testing purposes
		System.out.println(decodedMessage);

		//Write
		writer.write(decodedMessage, 0, decodedMessage.length());
		
		//Close resources
		writer.close();
		reader.close();
		
		//return user-specified file
		return file;
	}

	/*To read a 'line' (terminated by '\0')*/
	private static String readLine(BufferedReader reader) throws Exception {
		String temp ="";
		char current;

		//read until '\0'
		while((current = (char)reader.read()) != '\0') {
			temp += current;
		}

		return temp;
	}

	/*To read the rest of the characters*/
	private static String readRest(BufferedReader reader) throws Exception {
		String temp = "";
		int current;

		while((current = reader.read()) != -1) {
			temp += (char)current;
		}

		return temp.substring(0, temp.length() - 1); //strip the ending '\0'
	}

	/*To convert the UTF8 characters into binary string*/
	private static String toBinaryString(String input, int paddedAmount) {
		String binaryString = "";
		System.out.println(input.length());
		for(int i = 0; i < input.length(); i++) {
			String temp = Integer.toString((int)input.charAt(i), 2);
			//System.out.println(temp + "    " + (int)input.charAt(i));
			while(temp.length() % 8 != 0) {
				temp = "0" + temp;
			}
			binaryString += temp;
		}
		return binaryString.substring(0, binaryString.length() - paddedAmount); //remove extra 0s
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

	/*To convert the binary stuff into UTF8 encoding*/
	private static String toUTF8Characters(String code) {
		//pad the coded string with 0s to make it fit into bytes
		while(code.length() % 8 != 0) {
			code += "0";
		}
		System.out.println(code);
		//Convert
		String codeBytes = "";
		while(code.length() != 0) {
			String temp = code.substring(0, 8);
			System.out.println(temp);
			//convert from string to int, then char
			codeBytes += (char)Integer.parseInt(temp, 2);
			code = code.substring(8);
		}
		return codeBytes;
	}

	/*To convert from binary string to an int value*/
	/*private static int toInt(String code) {
		return Integer.parseInt()
	}*/

	/*To split the input string from the compresses file into a String[]*/
	private static String[] split(String input) {
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i < input.length(); i+=2) {
			list.add("" + input.charAt(i));
		}
		return list.toArray(new String[list.size()]);
	}
}