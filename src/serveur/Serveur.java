package serveur;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
	
	private int numport;
	private String path;
	private ServerSocket ssk;
	
	
	public Serveur() {
		
		this.numport = 2222;
		this.path = "C:\\Users\\Jammy\\Desktop\\Cours\\Java\\Projet\\P2P\\FichierServeur";	
		try {
			
			this.ssk = new ServerSocket(2222);
			
		} catch (IOException e) {
			
			System.out.println("Erreur lors de l'ouverture du serveur");
			
		}
		
	}
	
	public void envoyer(Socket sk, String texte) {
		
		try {
			
			PrintStream sortieSocket = new PrintStream(sk.getOutputStream());
			sortieSocket.print(texte);
			sortieSocket.flush();
			
		} catch (Exception e) {
			
			System.out.println("Erreur lors de l'envoi du serveur");
			
		}
		
	}
	
	public String recevoir(Socket sk) {
		
		String mess = new String();
		try {
			BufferedReader entreeSocket = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			mess = entreeSocket.readLine();
						
			System.out.println("J'ai reçu : " + mess);
		} catch (IOException e) {

			System.out.println("Erreur lors de la reception");
		}
		
		return mess;
		
	}
	
	public String getListFiles() {
		
		String listfichier = new String(); 
		File dir = new File(path);
		File[] filesList = dir.listFiles();
		for (File file : filesList) {
		    if (file.isFile()) {
		    	listfichier += file.getName();
		    	listfichier += "  ";
		    }
		}
		
		return listfichier;
		
	}
	
	public ServerSocket getServSock() {
		
		return ssk;
		
	}
	
}
