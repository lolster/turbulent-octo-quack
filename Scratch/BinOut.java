//package huffmancoding;

import java.io.FileOutputStream;
import java.io.File;

public class BinOut {

	private BinOut(){} //do not instantiate

	//public static void main(String[] args) {
		/*
		String code = "1011011001";
		while(code.length() % 8 != 0) {
			code += "0";
		}
		int buffer = 0;
		int n = 0;
		try {
			FileOutputStream writer = new FileOutputStream("file.txt");
			while(code.length() != 0) {
				char temp = code.charAt(0);
				//System.out.println("Code: " + code + "    " + "temp: " + temp);
				if(temp == '1')
					buffer |= 1;
				n++;
				if(n == 8) {
					//System.out.println("Buffer: " + buffer);
					writer.write(buffer);
					n = 0;
					buffer = 0;
				}
				buffer = buffer << 1;
				code = code.substring(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		/*
		try {
			File file = new File("text.ar");
			write(file, "011101101101010111001000100010");
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
	//}

	public static void write(File inputFile, String code) {
		//String code = "1011011001";
		while(code.length() % 8 != 0) {
			code += "0";
		}
		int buffer = 0;
		int n = 0;
		try {
			FileOutputStream writer = new FileOutputStream(inputFile);
			while(code.length() != 0) {
				char temp = code.charAt(0);
				//System.out.println("Code: " + code + "    " + "temp: " + temp);
				if(temp == '1')
					buffer |= 1;
				n++;
				if(n == 8) {
					//System.out.println("Buffer: " + buffer);
					writer.write(buffer);
					n = 0;
					buffer = 0;
				}
				buffer = buffer << 1;
				code = code.substring(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}