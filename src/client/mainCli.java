package client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
public class mainCli {
	
	public static void main(String[] args) {
		
		Client cli = new Client();
		
		System.out.println("Saisir un message");
		
		Scanner sc = new Scanner(System.in);
		
		String message = sc.nextLine();
		message += "\r\n";
				
		try {
			
			Socket socketEmission = new Socket("localhost", 2222);
			cli.envoyer(socketEmission, message);
			String list = cli.recevoir(socketEmission);
			System.out.println(list);

			socketEmission.close();
			
					
		} catch (IOException e) {			
			
			System.out.println("Erreur lors d el'ouverture de la socket !");
			
		}	
			
		
	}

}
