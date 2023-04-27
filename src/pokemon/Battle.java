package pokemon;

import java.util.LinkedList;
import java.util.Random;

public class Battle {

	// Generates a random number and has a 17 / 256 chance of being a critical hit
	private static int critChance() {
		boolean crit = false;
		Random rnd = new Random();
		int low = 0;
		int high = 256;
		int result = rnd.nextInt(high - low) + low;
		for (int i = 0; i < 17; i++) {
			if (result == i) {
				crit = true;
			}
		}
		if (crit) {
			return 2;
		} else {
			return 1;
		}
	}

	// Generates a random number between 217 and 255, then checks if the previous
	// steps of the damage formula equal 1, if it does it returns 1 otherwise it
	// returns the generated number divided by 255
	private static int dmgRnd(Pokemon p, Pokemon r, Move m) {
		Random rnd = new Random();
		int low = 217;
		int high = 255;
		int result = rnd.nextInt(high - low) + low;
		if (m.getDmgType().equals(DmgTypes.PHYSICAL)) {
			if ((int) ((((((2 * p.getLvl() * (critChance())) / 5) + 2) * m.getPower() * (p.getAtk() / r.getDef())) / 50 + 2)
					* stab(p, m) * TypeChart.getAdvantageValue(r.getType1(), m.getType())
					* TypeChart.getAdvantageValue(r.getType2(), m.getType())) == 1) {
				return 1;
			} else {
				return result / 255;
			}
		} else {
			if ((int) ((((((2 * p.getLvl() * (critChance())) / 5) + 2) * m.getPower() * (p.getSatk() / r.getSdef())) / 50
					+ 2) * stab(p, m) * TypeChart.getAdvantageValue(r.getType1(), m.getType())
					* TypeChart.getAdvantageValue(r.getType2(), m.getType())) == 1) {
				return 1;
			} else {
				return result / 255;
			}
		}
	}

	// Checks if a pokemon's move shares type with any of the pokemon types and if
	// it does it returns 1.5 otherwise it returns 1
	private static double stab(Pokemon p, Move m) {
		if (p.getType1().equals(m.getType()) || p.getType2().equals(m.getType())) {
			return 1.5;
		} else {
			return 1;
		}
	}

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

	// This is the official way of calculating the damage of attack moves on
	// generation
	// 1 pokemon. Formula:
	// https://bulbapedia.bulbagarden.net/wiki/Damage#Generation_I
	public int dmg(Pokemon p, Pokemon r, Move m) {
		int dmg = 0;
		if (m.getDmgType().equals(DmgTypes.PHYSICAL)) {
			dmg = (int) ((((((2 * p.getLvl() * (critChance())) / 5) + 2) * m.getPower() * (p.getAtk() / r.getDef())) / 50
					+ 2) * stab(p, m) * TypeChart.getAdvantageValue(r.getType1(), m.getType())
					* TypeChart.getAdvantageValue(r.getType2(), m.getType()) * dmgRnd(p, r, m));
		} else {
			dmg = (int) ((((((2 * p.getLvl() * (critChance())) / 5) + 2) * m.getPower() * (p.getSatk() / r.getSdef())) / 50
					+ 2) * stab(p, m) * TypeChart.getAdvantageValue(r.getType1(), m.getType())
					* TypeChart.getAdvantageValue(r.getType2(), m.getType()) * dmgRnd(p, r, m));
		}
		return dmg;
	}
}
