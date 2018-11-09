package ar.com.cobol.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cli.Cliente;

public class Servidor extends Thread {

	private ArrayList<Socket> clientes;
	private int puerto;
	private static Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	private static SessionFactory factory = cfg.buildSessionFactory();
	private static Session session = factory.openSession();

	public Servidor(int puerto) {
		this.clientes = new ArrayList<Socket>();
		this.puerto = puerto;
		this.start();
	}

	public void run() {
		int i = 0;
		ServerSocket servidor = null;
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Skynet online...");
			while (i < 999) {
				Socket cliente = servidor.accept();
				
				clientes.add(cliente);
				new ServidorHilo(cliente, clientes).start();
				i++;
			}
		} catch (Exception e) {
			System.err.println("Skynet isn't ready for the human's annihilation");
		} finally {
			try {
				servidor.close();
				System.out.println("Skynet offline.");
			} catch (IOException e) {
				e.printStackTrace();
			}
			;
			factory.close();
			session.close();

		}
	}
	

	public static void main(String[] args) {
		new Servidor(10000);
	}

}
