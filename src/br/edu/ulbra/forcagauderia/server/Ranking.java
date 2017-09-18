package br.edu.ulbra.forcagauderia.server;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import br.edu.ulbra.forcagauderia.common.model.UsuarioRanking;

public class Ranking {

	private ArrayList<UsuarioRanking> ranking;
	
	public Ranking(){
		this.loadFile();
	}

	public UsuarioRanking updateRanking(String usuario, String chave, int vitorias, int derrotas){
		boolean achou = false;
		UsuarioRanking atualiza = null;
		for (UsuarioRanking usuarioRanking : ranking){
			if (usuarioRanking.getUsuario().equalsIgnoreCase(usuario) && usuarioRanking.getChave().equals(chave)){
				atualiza = usuarioRanking;
				achou = true;
				break;
			}
		}
		
		if (achou){
			atualiza.setVitorias(atualiza.getVitorias() + vitorias);
			atualiza.setDerrotas(atualiza.getDerrotas() + derrotas);
		} else {
			atualiza = new UsuarioRanking(usuario, chave, vitorias, derrotas);
			this.ranking.add(atualiza);
		}
		
		this.saveFile();
		return atualiza;
	}
	
	@SuppressWarnings("unchecked")
	private void loadFile(){
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(Config.ARQUIVO_RANKING));
			this.ranking = (ArrayList<UsuarioRanking>)input.readObject();
			input.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("ERROR loading ranking file: " + e.getMessage());
		}
	}
	
	private void saveFile(){
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(Config.ARQUIVO_RANKING));
			output.writeObject(this.ranking);
			output.close();
		} catch (IOException e) {
			System.out.println("ERROR saving ranking file: " + e.getMessage());
		}		
	}
	
	public ArrayList<UsuarioRanking> getRanking(){
		return this.ranking;
	}
	
}
