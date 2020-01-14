package serveur;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class mainServ {

	public static void main(String[] args) {
		
		Serveur serv = new Serveur();
		
		String liste  = serv.getListFiles();
			
		Socket socket = null;
		
		while(true) {			
			
			try {
				
				socket = serv.getServSock().accept();
				
			} catch (IOException e) {

				System.out.println("Erreur lors de l'accept de la socket client");
				
			}
			
			String mess = serv.recevoir(socket);
			
			System.out.println(mess);
			
			serv.envoyer(socket, liste);
					
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("Erreur lors de la fermeture de la socket");
			}		
		
		}
	
	}
	
}
