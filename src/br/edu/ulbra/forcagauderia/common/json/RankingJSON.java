package br.edu.ulbra.forcagauderia.common.json;

import java.util.ArrayList;
import java.util.Collections;

import br.edu.ulbra.forcagauderia.common.model.UsuarioRanking;
import br.edu.ulbra.forcagauderia.server.Ranking;

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

	public static RankingJSON fromRanking(Ranking ranking){
		RankingJSON rankingJSON = new RankingJSON();
		ArrayList<UsuarioRankingJSON> arrayUsuarios = new ArrayList<>();
		for(UsuarioRanking usuarioRanking : ranking.getRanking()){
			arrayUsuarios.add(UsuarioRankingJSON.fromUsuarioRanking(usuarioRanking));
		}
		arrayUsuarios.sort(Collections.reverseOrder());
		rankingJSON.setRanking(arrayUsuarios);
		return rankingJSON;
	}
	
}
