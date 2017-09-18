package br.edu.ulbra.forcagauderia.common.model;

public class UsuarioRanking {

	private String usuario;
	private String chave;
	private int vitorias;
	private int derrotas;

	public UsuarioRanking() {
	}

	public UsuarioRanking(String usuario, String chave, int vitorias, int derrotas) {
		this.usuario = usuario;
		this.vitorias = vitorias;
		this.derrotas = derrotas;
		this.chave = chave;
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

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

}
