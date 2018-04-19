package vn.thuylazy.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class File {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WriteValueToFile();
		ReadFile();
	}

	public static void ReadFile() {
		try {
			InputStream is = new FileInputStream("/home/thuylazy/Desktop/thuylazy.txt");
			int i = -1;
			while ((i = is.read()) != -1) {
				System.out.print((char) i + " ");
			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void WriteValueToFile() {
		try {
			OutputStream os = new FileOutputStream("/home/thuylazy/Desktop/thuylazy.txt");
			Scanner scanner = new Scanner(System.in);
			String str = scanner.nextLine();
			byte[] by = str.getBytes();
			for (int i = 0; i < by.length; i++) {
				byte b = by[i];
				os.write(b);
			}
			os.close();
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
