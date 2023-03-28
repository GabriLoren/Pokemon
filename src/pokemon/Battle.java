package pokemon;

import java.util.LinkedList;

public class Battle {

	private boolean winner;
	private Trainer player;
	private Trainer rival;
	private Turn turn;
	private int pokemonPlayer;
	private int pokemonRival;
	private LinkedList<Turn> turns;

	public Battle(boolean winner, Trainer player, Trainer rival, Turn turn, int pokemonPlayer, int pokemonRival,
			LinkedList<Turn> turns) {
		super();
		this.winner = winner;
		this.player = player;
		this.rival = rival;
		this.turn = turn;
		this.pokemonPlayer = pokemonPlayer;
		this.pokemonRival = pokemonRival;
		this.turns = turns;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public Trainer getPlayer() {
		return player;
	}

	public void setPlayer(Trainer player) {
		this.player = player;
	}

	public Trainer getRival() {
		return rival;
	}

	public void setRival(Trainer rival) {
		this.rival = rival;
	}

	public Turn getTurn() {
		return turn;
	}

	public void setTurn(Turn turn) {
		this.turn = turn;
	}

	public int getPokemonPlayer() {
		return pokemonPlayer;
	}

	public void setPokemonPlayer(int pokemonPlayer) {
		this.pokemonPlayer = pokemonPlayer;
	}

	public int getPokemonRival() {
		return pokemonRival;
	}

	public void setPokemonRival(int pokemonRival) {
		this.pokemonRival = pokemonRival;
	}

	public LinkedList<Turn> getTurns() {
		return turns;
	}

	public void setTurns(LinkedList<Turn> turns) {
		this.turns = turns;
	}

}
