package ar.cobol.game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import ar.com.cobol.manager.Manager;
import ar.com.cobol.snake.Salamandra;

public class GameServer extends Thread {

	private static Manager manager;
	private ServerSocket socketServidor;
	private Socket socketAlCliente;
	private static Integer puerto = 8080;
	private ObjectInputStream inStream;


	public void comunicarse() {
		
		try {
			socketServidor = new ServerSocket(puerto); //CONFIGURAR EL PUERTO 
			socketAlCliente = socketServidor.accept();
			System.out.println("Conectado.");
			inStream = new ObjectInputStream(socketAlCliente.getInputStream());

			Salamandra salamandra = (Salamandra) inStream.readObject();
			System.out.println("Snake recibida.");
			socketAlCliente.close();

			}catch (SocketException se) {
				System.exit(0);
			} catch (IOException e) {
			e.printStackTrace();
			} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
			}	
	}
	
	public static void main(String[] args) {
		GameServer server = new GameServer();
		server.comunicarse();
	}
}