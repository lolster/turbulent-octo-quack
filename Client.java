import huffmancoding.HuffmanCoding;

import java.util.*;
import java.io.*;

public class Client {
	public static void main(String[] args) {
		
		/*Test 2
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the message: ");
		String input = scan.nextLine();
		scan.close();*/
		
		/*HuffmanTree tree = new HuffmanTree(input);*/
		
		/*
		System.out.println("Encoded Message: " + tree.getEncodedMessage());
		System.out.println("Decoded Message: " + tree.decode(tree.getEncodedMessage()));
		System.out.print("Compression Percentage: ");
		System.out.println(((input.length()*8.0) - tree.getEncodedMessage().length())/(input.length()*8.0) * 100 + "%");
		tree.printCodes();
		*/
		
		//File IP Test 3
		try {
			File output = HuffmanCoding.compress(new File("file.txt"));
			//output.createNewFile();
			//File output = new File("file.txt.ar");
			File decode = HuffmanCoding.decompress(output, "new.txt");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		/*Test 1
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("file.txt.ar")));
			String[] temp = split(reader.readLine());
			System.out.println(Arrays.toString(temp));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
	}

	/*Test 1
	private static String[] split(String input) {
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i < input.length(); i+=2) {
			list.add("" + input.charAt(i));
		}
		return list.toArray(new String[list.size()]);
	}*/
}
