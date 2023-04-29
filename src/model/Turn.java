package model;

public class Turn {

	private int turn;
	private String playerMove;
	private String rivalMove;

	public Turn(int turn, String playerMove, String rivalMove) {
		super();
		this.turn = turn;
		this.playerMove = playerMove;
		this.rivalMove = rivalMove;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public String getPlayerMove() {
		return playerMove;
	}

	public void setPlayerMove(String playerMove) {
		this.playerMove = playerMove;
	}

	public String getRivalMove() {
		return rivalMove;
	}

	public void setRivalMove(String rivalMove) {
		this.rivalMove = rivalMove;
	}

	@Override
	public String toString() {
		return "Turn [turn=" + turn + ", playerMove=" + playerMove + ", rivalMove=" + rivalMove + "]";
	}

}
