package br.edu.ulbra.forcagauderia.common.model;

import br.edu.ulbra.forcagauderia.common.json.BuscarPalavraJSON;

public class Palavra {

	private String palavra;
	private String dica;

	public Palavra() {
	}

	public Palavra(String palavra, String dica) {
		this.palavra = palavra;
		this.dica = dica;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public String getDica() {
		return dica;
	}

	public void setDica(String dica) {
		this.dica = dica;
	}

	public static Palavra fromBuscarPalavraJSON(BuscarPalavraJSON buscarPalavraJSON){
		return new Palavra(buscarPalavraJSON.getPalavra(), buscarPalavraJSON.getDica());
	}
}

