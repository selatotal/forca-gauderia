package br.edu.ulbra.forcagauderia.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		
		// Entrada de dados
		System.out.print("Informe o IP do servidor: ");
		String serverAddress = stdin.nextLine();
		System.out.print("Informe a porta do servidor: ");
		String serverPort = stdin.nextLine();
		System.out.print("Informe o usuario: ");
		String usuario = stdin.nextLine();
		System.out.print("Informe a chave: ");
		String chave = stdin.nextLine();
		
		try {
			// Realiza a conexao
			Socket client = new Socket(serverAddress, Integer.parseInt(serverPort));
			GameController game = new GameController(client);

			// Inicia o loop de jogo
			boolean continua = true;
			do {
				game.jogo(stdin);
				
				System.out.print("DIGITE S para continuar: ");
				char letra = stdin.nextLine().toUpperCase().charAt(0);
				if (letra != 'S'){
					continua = false;
				}
			} while (continua);
			
			// TODO: Atualizar o ranking do usuario
			
			// TODO: Exibir o ranking geral
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
