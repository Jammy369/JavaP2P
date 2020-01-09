package client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		System.out.println("Saisir un message");
		
		Scanner sc = new Scanner(System.in);
		
		String message = sc.nextLine();
		message += "\r\n";
		
		
		
		try {
			
			Socket socketEmission = new Socket("localhost", 2222);
			BufferedReader in = new BufferedReader(new InputStreamReader(socketEmission.getInputStream()));
			OutputStreamWriter out = new OutputStreamWriter(socketEmission.getOutputStream());
			out.write(message);
			out.flush();
			in.readLine();
			
			socketEmission.close();
			
		} catch (UnknownHostException e) {
			
			
			
		} catch (IOException e) {
			
			
		}
		
		
		
		
		
		
	}
	
}
