import java.util.*;
import java.lang.*;
import java.io.*;

public class Text {
	public static void main(String[] args) {
		String message = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
			message = reader.readLine();
			reader.close();
		}
		catch (Exception e){

		}
		String res = toBinaryString(message, 2);
		System.out.println(res + "    " + res.length());
	}

	private static String toBinaryString(String input, int paddedAmount) {
		String binaryString = "";
		System.out.println(input.length());
		for(int i = 0; i < input.length(); i++) {
			String temp = Integer.toString((int)input.charAt(i), 2);
			System.out.println(temp + "    " + (int)input.charAt(i));
			while(temp.length() % 8 != 0) {
				temp = "0" + temp;
			}
			binaryString += temp;
		}
		return binaryString.substring(0, binaryString.length() - paddedAmount); //remove extra 0s
	}
}