package vn.thuylazy.message;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		final String serverHost = "localhost";

		Socket socketOfClient = null;
		BufferedWriter os = null;
		BufferedReader is = null;

		try {
			socketOfClient = new Socket(serverHost, 7777);
			os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
			is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));

		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + serverHost);
			return;
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " + serverHost);
			return;
		}

		try {
			Scanner scanner = new Scanner(System.in);
			String str = scanner.nextLine();
			os.write(str);
			os.newLine();
			os.flush();

			String responseLine;
			while ((responseLine = is.readLine()) != null) {
				System.out.println("Server: " + responseLine);
				if (responseLine.indexOf("OK") != -1) {
					break;
				}
			}

			os.close();
			is.close();
			scanner.close();
			socketOfClient.close();
		} catch (UnknownHostException e) {
			System.err.println("Trying to connect to unknown host: " + e);
		} catch (IOException e) {
			System.err.println("IOException:  " + e);
		}
	}

}
