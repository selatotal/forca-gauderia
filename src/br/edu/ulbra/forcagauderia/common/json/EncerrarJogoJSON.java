package br.edu.ulbra.forcagauderia.common.json;

import br.edu.ulbra.forcagauderia.common.model.UsuarioRanking;

public class EncerrarJogoJSON {

	private String usuario;
	private int derrotas;
	private int vitorias;

	public EncerrarJogoJSON() {
	}

	public EncerrarJogoJSON(String usuario, int derrotas, int vitorias) {
		this.usuario = usuario;
		this.derrotas = derrotas;
		this.vitorias = vitorias;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	
	public static EncerrarJogoJSON fromUsuarioRanking(UsuarioRanking usuarioRanking){
		EncerrarJogoJSON encerrarJogoJSON = new EncerrarJogoJSON();
		encerrarJogoJSON.usuario = usuarioRanking.getUsuario();
		encerrarJogoJSON.vitorias = usuarioRanking.getVitorias();
		encerrarJogoJSON.derrotas = usuarioRanking.getDerrotas();
		return encerrarJogoJSON;
	}

}
