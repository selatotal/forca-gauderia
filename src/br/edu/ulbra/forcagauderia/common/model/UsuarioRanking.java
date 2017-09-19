package br.edu.ulbra.forcagauderia.common.model;

import java.io.Serializable;

public class UsuarioRanking implements Serializable{

	private static final long serialVersionUID = 6668431430798464665L;
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
