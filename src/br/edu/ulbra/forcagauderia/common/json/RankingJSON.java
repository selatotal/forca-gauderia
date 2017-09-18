package br.edu.ulbra.forcagauderia.common.json;

import java.util.ArrayList;

import br.edu.ulbra.forcagauderia.common.model.UsuarioRanking;

public class RankingJSON {

	private ArrayList<UsuarioRankingJSON> ranking;

	public RankingJSON() {
	}

	public RankingJSON(ArrayList<UsuarioRankingJSON> ranking) {
		this.ranking = ranking;
	}

	public ArrayList<UsuarioRankingJSON> getRanking() {
		return ranking;
	}

	public void setRanking(ArrayList<UsuarioRankingJSON> ranking) {
		this.ranking = ranking;
	}

}
