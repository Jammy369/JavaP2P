package client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	private String saddress;
	private int numport;
	
	public Client() {
		
		this.saddress = "localhost";
		this.numport = 2222;
		
	}
	
	public Client(String ad, int por) {
		
		this.saddress = ad;
		this.numport = por;
		
	}
	
	public void envoyer(Socket sk, String texte) {
		
		try {
			
			OutputStreamWriter out = new OutputStreamWriter(sk.getOutputStream());
			
			out.write(texte);
			out.flush();
			
		} catch (IOException e) {
			
			System.out.println("Erreur lors d el'envoi du message");
			
		}					
		
	}
	
	public String recevoir(Socket sk) {
		
		String mess = new String();
		
		try {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			mess = in.readLine();
			
		} catch (IOException e) {
			
		}
		return mess;
		
	}
	
}
