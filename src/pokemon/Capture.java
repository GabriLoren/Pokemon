package pokemon;

import java.util.Random;
import java.util.Scanner;

public class Capture {

	private String[] forbiddenWords;
	private Pokemon poke = new Pokemon();
	private Scanner sc;

	public String[] getForbiddenWords() {
		return forbiddenWords;
	}

	// We need a temporary collection of Pokemon which will be later replaced or
	// filled by the
	// database
	public void randomPokemon() {

	}

	// Sets the captured pokemon nickname to what the user inputed if the
	public void setNickname() {
		System.out.println("Introduce a nickname for the captured Pokemon");
		sc = new Scanner(System.in);
		String nick = sc.nextLine();
		if (nick.equals("")) {
			poke.setNickname(poke.getName());
		} else {
			poke.setNickname(nick);
		}

	}

	// We need to compare the nickname to the nicknames on the database so names
	// don't get repeated
	public void checkNickname() {

	}

	// Every time we call the method there is a 2/3 chance of capturing a pokemon,
	// if we capture it then we call the set nickname method
	public void capture() {
		Random r = new Random();
		int low = 0;
		int high = 2;
		int result = r.nextInt(high - low) + low;
		if (result == 0) {
			System.out.println("Oh no! You missed.");
		} else {
			System.out.println("Yeah! You got it.");
			setNickname();
		}
	}
}
