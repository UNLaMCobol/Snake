package ar.cobol.game;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import ar.com.cobol.manager.Manager;

public class GameServer extends Thread {

	private static Manager manager;
	private static Integer puerto = 8080;
	
	public static void main(String[] args) throws IOException {
		
		manager = new Manager();
		ServerSocket servidor = new ServerSocket(puerto);
		
		while(true) {
			
			Socket cliente = servidor.accept();
			
			InputStream input = cliente.getInputStream();
			
		}
		
	}
}
