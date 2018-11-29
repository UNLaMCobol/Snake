package ar.cobol.game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import ar.com.cobol.figura.Punto;
import ar.com.cobol.snake.Salamandra;

public class ClientGame {
	
	private Socket socketCliente = null;
	private ObjectInputStream inputStream = null;
	private ObjectOutputStream outputStream = null;
	
	
	public ClientGame() {
		// TODO Auto-generated constructor stub
	}
	
	public void comunicarse() {
		
		
		try {
			socketCliente = new Socket("localHost", 8080); //ESTO NO SE COMO SE CONFIGURA 
			System.out.println("Conectado.");
			outputStream = new ObjectOutputStream(socketCliente.getOutputStream());
			Salamandra snake = null; //CREACION DEL OBJETO A ENVIAR
			System.out.println("SNAKE CREADA PARA ENVIAR AL SERVIDOR.");
			outputStream.writeObject(snake);
			} catch (SocketException se) {
				se.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		ClientGame client = new ClientGame();
		client.comunicarse();
		}
}