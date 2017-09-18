package br.edu.ulbra.forcagauderia.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.google.gson.Gson;

import br.edu.ulbra.forcagauderia.common.json.BuscarPalavraJSON;
import br.edu.ulbra.forcagauderia.common.json.EncerrarJogoJSON;
import br.edu.ulbra.forcagauderia.common.json.RankingJSON;
import br.edu.ulbra.forcagauderia.common.model.Palavra;
import br.edu.ulbra.forcagauderia.common.model.UsuarioRanking;

public class RequestController extends Thread {

	private Scanner inputStream;
	private PrintWriter outputStream;
	private Palavras palavras;
	private Gson gson = new Gson();
	
	
	public RequestController(Socket socket, Palavras palavras) throws IOException{
		this.inputStream = new Scanner(socket.getInputStream());
		this.outputStream = new PrintWriter(socket.getOutputStream());
		this.palavras = palavras;
	}
	
	// Tratamento principal da Thread
	public void run(){
		
		// Busca comando enviado
		String comando = inputStream.nextLine();
		
		if (comando.equals("BUSCARPALAVRA")){
			Palavra palavra = palavras.sorteia();
			String retorno = gson.toJson(new BuscarPalavraJSON(palavra.getPalavra(), palavra.getDica()));
			outputStream.println(retorno);
			outputStream.flush();
		} else if (comando.startsWith("ENCERRARJOGO")){
			String[] parsed = comando.split(" ");
			Ranking ranking = new Ranking();
			UsuarioRanking usuario = ranking.updateRanking(parsed[1], parsed[2], Integer.parseInt(parsed[3]), Integer.parseInt(parsed[4]));
			String retorno = gson.toJson(EncerrarJogoJSON.fromUsuarioRanking(usuario));
			outputStream.println(retorno);
			outputStream.flush();
		} else if (comando.equals("BUSCARRANKING")){
			RankingJSON ranking = RankingJSON.fromRanking(new Ranking());
			String retorno = gson.toJson(ranking);
			outputStream.println(retorno);
			outputStream.flush();
		}
		
	}
	
}
