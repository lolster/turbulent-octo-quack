import java.io.*;
import java.util.*;

public class HuffmanCoding() {
	private HuffmanCoding() {} //do not instantiate

	public static String compressTextFile(File textFile) {
		String result = null;
		HashMap<String, Integer> words = new HashMap<>(); //maps the words with the frequency
		try(BufferedReader reader = new BufferedReader(new FileReader(textFile))) { //open the file to read
			String inputLine = reader.readLine();
			//build the hash table to map string with frequency
			while(inputLine != null) {
				String[] inputLineSplit = inputLine.split("");
				for(int i = 0; i < inputLineSplit.length; i++) {
					if(!words.contains(inputLineSplit[i])) {
						//if word is not present in hash map
						//put it in with the initial frequency
						words.put(inputLineSplit[i], 1);
					}
					else {
						//map contains the word
						//increment the associate frequency by one
						words.put(inputLineSplit[i], words.get(inputLineSplit[i]) + 1);
					}
				}
			}
			//do your stuff;
			//initialise the priority queue with the HuffmanTreeNodes
			//use the while loop method to build tree
			//pass the root node to create a new HuffmanTree object
			//get the coding table by tree traversal
			//store the coding table in a new HashMap<String, String>
			//store in a file
		}
		catch(IOException e) {
			result = "Compression Failed! Could not find or open text file.";
		}
		catch(Exception e) {
			result = "Failed! Something unexpected happened.";
		}
		return result;
	}

}