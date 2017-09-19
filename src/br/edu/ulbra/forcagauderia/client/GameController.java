package br.edu.ulbra.forcagauderia.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

import br.edu.ulbra.forcagauderia.common.json.BuscarPalavraJSON;
import br.edu.ulbra.forcagauderia.common.model.Palavra;

public class GameController {

	private Socket socket;
	private Scanner input;
	private PrintWriter output;
	private int numVitorias = 0;
	private int numDerrotas = 0;
	private Gson gson = new Gson();
	
	public GameController(Socket socket) throws IOException{
		this.socket = socket;
		this.input = new Scanner(socket.getInputStream());
		this.output = new PrintWriter(socket.getOutputStream());		
	}
	
	public void jogo(Scanner stdin){
		
		Palavra palavra = this.buscarPalavra();
		int tamanhoPalavra = palavra.getPalavra().length();
		int numeroLetrasDica = tamanhoPalavra / 2;
		int numTentativas = 0;
		ArrayList<Character> letrasDigitadas = new ArrayList<>();
		
		char[] arrayExibicao = new char[tamanhoPalavra];
		for (int i=0; i < tamanhoPalavra; i++){
			arrayExibicao[i] = '_';
		}
		
		// Inicio do loop do jogo
		boolean ganhou = false;
		boolean exibeDica = false;
		do {
			// Exibe a palavra
			if (exibeDica){
				System.out.println("DICA: " + palavra.getDica());
			}
			this.exibePalavra(arrayExibicao);
			
			// Solicita uma letra ao usuario
			System.out.print("Informe uma letra");
			char letraInformada = stdin.nextLine().toUpperCase().charAt(0);
			
			// Verifica se a letra ja foi tentada
			if (letrasDigitadas.contains(letraInformada)){
				System.out.println("LETRA REPETIDA! INFORME NOVAMENTE!");
			} else {
				// Verifica se a palavra contem a letra
				if (palavra.getPalavra().toUpperCase().contains(""+letraInformada)){
					// Contem a letra
					for(int i=0; i<tamanhoPalavra; i++){
						if (palavra.getPalavra().toUpperCase().charAt(i) == letraInformada){
							arrayExibicao[i] = letraInformada;
						}
					}
					
					// Verifica se deve exibir a dica
					if (!exibeDica){
						int letrasOcultas = 0;
						for (char c : arrayExibicao){
							if (c == '_'){
								letrasOcultas++;
							}
						}
						if ((tamanhoPalavra - letrasOcultas) <= numeroLetrasDica){
							exibeDica = true;
						}
					}
				} else {
					System.out.println("LETRA NAO EXISTE NA PALAVRA!");
					numTentativas++;
				}
			}
		} while (!ganhou && numTentativas < Config.NUM_TENTATIVAS);
		
		if (!ganhou){
			this.numDerrotas++;
		}else {
			this.numVitorias++;
		}
	}
	
	private Palavra buscarPalavra(){
		// Envia mensagem para o servidor
		output.println("BUSCARPALAVRA");
		output.flush();
		
		// Recebe resposta
		String resposta = input.nextLine();
		while(input.hasNext()){
			resposta += input.nextLine();
		}
		BuscarPalavraJSON buscarPalavraJSON = gson.fromJson(resposta, BuscarPalavraJSON.class);
		return Palavra.fromBuscarPalavraJSON(buscarPalavraJSON);
	}
	
	private void exibePalavra(char[] palavra){
		for(char c : palavra){
			System.out.print(c + " ");
		}
		System.out.println();
	}
	
}
