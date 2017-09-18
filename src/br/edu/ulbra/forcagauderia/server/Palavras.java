package br.edu.ulbra.forcagauderia.server;

import java.util.ArrayList;
import java.util.Random;

import br.edu.ulbra.forcagauderia.common.model.Palavra;

public class Palavras {

	private ArrayList<Palavra> palavras = new ArrayList<>();
	
	public void adicionaPalavra(Palavra palavra){
		this.palavras.add(palavra);
	}
	
	public Palavra sorteia(){
		Random rand = new Random();
		int posicao = rand.nextInt(palavras.size());
		return palavras.get(posicao);
	}
	
}
