package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
	
	public static void main(String[] args) {
		

		try {
			ServerSocket socketEcoute = new ServerSocket(2222);
			
			while(true) {
				
				Socket socket = socketEcoute.accept();
				
				BufferedReader entreeSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintStream sortieSocket = new PrintStream(socket.getOutputStream());
				
				String mess = entreeSocket.readLine();
							
				System.out.println("J'ai reçu : " + mess);
				
				socket.close();
				
			}
					
		} catch (IOException e) {
			
		}
		
		
		
	}

}
