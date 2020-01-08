import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

	public static void main(String[] args) {
		
		ServerSocket sockEcoute = null;
		
		try {
			
			sockEcoute = new ServerSocket(2222);
			
		} catch (IOException e) {
			
			System.out.println("Erreur lors de la création de la socket d'écoute");
			
		}
		
		Socket socket;
		
		while(true) {
			
			try {
				socket = sockEcoute.accept();
			} catch (IOException e) {

				System.out.println("Erreur lors de l'acceptation de la socket");
				break;
			}
			
			try {
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
				String req = reader.readLine();
				
				System.out.println(req);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
}
