package br.edu.ulbra.forcagauderia.common.json;

import br.edu.ulbra.forcagauderia.common.model.UsuarioRanking;

public class UsuarioRankingJSON {

	private String usuario;
	private int vitorias;
	private int derrotas;
	private double percentual;

	public UsuarioRankingJSON() {
	}

	public UsuarioRankingJSON(String usuario, int vitorias, int derrotas, double percentual) {
		this.usuario = usuario;
		this.vitorias = vitorias;
		this.derrotas = derrotas;
		this.percentual = percentual;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public double getPercentual() {
		return percentual;
	}

	public void setPercentual(double percentual) {
		this.percentual = percentual;
	}

	public UsuarioRankingJSON fromUsuarioRanking(UsuarioRanking usuarioRanking){
		UsuarioRankingJSON usuarioRankingJSON = new UsuarioRankingJSON();
		usuarioRankingJSON.usuario = usuarioRanking.getUsuario();
		usuarioRankingJSON.vitorias = usuarioRanking.getVitorias();
		usuarioRankingJSON.derrotas = usuarioRanking.getDerrotas();
		usuarioRankingJSON.percentual = (this.vitorias / this.derrotas) * 100.0;
		return usuarioRankingJSON;
	}
	
}
