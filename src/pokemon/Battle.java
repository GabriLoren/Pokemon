package pokemon;

import java.util.LinkedList;

public class Battle {

	private boolean winner;
	private Trainer player;
	private Trainer rival;
	private Turn turn;
	private int playerKOs;
	private int rivalKOs;
	private LinkedList<Turn> turns;
	private Pokemon playerActivePokemon;
	private Pokemon rivalActivePokemon;

	public Battle(boolean winner, Trainer player, Trainer rival, Turn turn, int pokemonPlayer, int pokemonRival,
			LinkedList<Turn> turns, Pokemon playerActivePokemon, Pokemon rivalActivePokemon) {
		super();
		this.winner = winner;
		this.player = player;
		this.rival = rival;
		this.turn = turn;
		this.playerKOs = pokemonPlayer;
		this.rivalKOs = pokemonRival;
		this.turns = turns;
		this.playerActivePokemon = playerActivePokemon;
		this.rivalActivePokemon = rivalActivePokemon;
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

	public int getPlayerKOs() {
		return playerKOs;
	}

	public void setPlayerKOs(int playerKOs) {
		this.playerKOs = playerKOs;
	}

	public int getRivalKOs() {
		return rivalKOs;
	}

	public void setRivalKOs(int rivalKOs) {
		this.rivalKOs = rivalKOs;
	}

	public LinkedList<Turn> getTurns() {
		return turns;
	}

	public void setTurns(LinkedList<Turn> turns) {
		this.turns = turns;
	}

	public Pokemon getPlayerActivePokemon() {
		return playerActivePokemon;
	}

	public void setPlayerActivePokemon(Pokemon playerActivePokemon) {
		this.playerActivePokemon = playerActivePokemon;
	}

	public Pokemon getRivalActivePokemon() {
		return rivalActivePokemon;
	}

	public void setRivalActivePokemon(Pokemon rivalActivePokemon) {
		this.rivalActivePokemon = rivalActivePokemon;
	}

	// If the player won the battle the player gets 1/3 of the rival's money
	// otherwise the rival gets 1/3 of the player's money
	public void victoryMoney() {
		if (this.winner == true) {
			int money = this.rival.getPokedollar() / 3;
			this.player.setPokedollar(this.player.getPokedollar() + money);
			this.rival.setPokedollar(this.rival.getPokedollar() - money);
		} else {
			int money = this.player.getPokedollar() / 3;
			this.rival.setPokedollar(this.rival.getPokedollar() + money);
			this.player.setPokedollar(this.player.getPokedollar() - money);
		}
	}

	// Active pokemon gets experience after defeating a pokemon based on the
	// following formula ([POKEMON_LEVEL] + [RIVAL_POKEMON_LEVEL] * 10) / 4, then if
	// the exp value of the pokemon exceeds or equals its level times 10 it levels
	// up
	public void giveExp() {
		playerActivePokemon.setExp(
				playerActivePokemon.getExp() + ((playerActivePokemon.getLvl() + rivalActivePokemon.getLvl() * 10) / 4));
		while (playerActivePokemon.getExp() >= (playerActivePokemon.getLvl() * 10)) {
			playerActivePokemon.levelUp();
		}
	}
}
