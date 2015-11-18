import java.util.*;
import java.io.*;

public class Client {
	public static void main(String[] args) {
		
		/*Scanner scan = new Scanner(System.in);
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
		
		//File IP
		BufferedReader reader = null;
		String message = "";
		try {
			reader = new BufferedReader(new FileReader(new File("C:\\Users\\Sushrith\\Desktop\\file.txt")));
			
			String temp = "";
			while( (temp = reader.readLine()) != null) {
				message += temp + "\n";
			}
			
			HuffmanTree tree = new HuffmanTree(message);
			System.out.println("Encoded Message: " + tree.getEncodedMessage());
			System.out.println("Decoded Message: \n" + tree.decode(tree.getEncodedMessage()));
			reader.close();
		}
		catch(Exception e) {
			
		}
	}
}
