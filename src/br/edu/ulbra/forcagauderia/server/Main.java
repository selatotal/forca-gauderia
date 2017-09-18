package br.edu.ulbra.forcagauderia.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import br.edu.ulbra.forcagauderia.common.model.Palavra;

public class Main {

	public static void carregaArquivoPalavras(Palavras palavras) throws FileNotFoundException{
		Scanner arquivoEntrada = new Scanner(new File(Config.ARQUIVO_PALAVRAS)); 
		
		while(arquivoEntrada.hasNextLine()){
			String linha = arquivoEntrada.nextLine();
			if (linha.contains("|")){
				String[] arrLinha = linha.split("|", 2);
				Palavra palavra = new Palavra(arrLinha[0], arrLinha[1]);
				palavras.adicionaPalavra(palavra);
			}
		}
		arquivoEntrada.close();
	}
	
	public static void main(String[] args){
		
		Palavras palavras = new Palavras();
		
		// Carrega o arquivo de Palavras
		try {
			Main.carregaArquivoPalavras(palavras);
		} catch (FileNotFoundException e){
			System.out.println("Erro ao carregar arquivo de palavras: " + e.getMessage());
			System.exit(1);
		}
		
		try {
			// Cria o ServerSocket e aguarda conexoes
			ServerSocket server = new ServerSocket(Config.SERVER_PORT);
			
			while(true){
				// Aguarda a conexao
				Socket client = server.accept();
				// Executa a thread de conexao
				new RequestController(client, palavras).start();;
			}
						
		} catch (IOException e) {
			System.out.println("Erro de I/O: " + e.getMessage());
		}
		
	}
	
}
