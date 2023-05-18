package jUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Obj;
import modelo.Pokemon;

class PokemonJUnit {

	@Test
	void testComprobarMote() {
		assertTrue(Pokemon.comprobarMote("Paquito23"));
		assertFalse(Pokemon.comprobarMote("mierda"));
	}

	@Test
	void testRecuperarEstamina() {
		Pokemon p = new Pokemon(0, "Gengar", 100);
		Obj o = new Obj();
		p.setObject(o);
		assertEquals(0, p.getStamina());
		p.recuperarEstamina();
		assertEquals(20, p.getStamina());
	}

	@Test
	void testLevelUp() {
		Pokemon p = new Pokemon(0, "Gengar", 100);
		assertEquals(0, p.getLevel());
		p.levelUp();
		assertEquals(1, p.getLevel());
		assertTrue(p.getVit() <= 105);
		assertTrue(p.getAtk() <= 5);
		assertTrue(p.getDef() <= 5);
		assertTrue(p.getSpAtk() <= 5);
		assertTrue(p.getSpDef() <= 5);
		assertTrue(p.getSpeed() <= 5);
	}

	@Test
	void testGiveExp() {
		Pokemon p = new Pokemon(0, "Gengar", 100);
		Pokemon pr = new Pokemon(0, "Pikachu", 100);
		p.setLevel(1);
		assertEquals(1, p.getLevel());
		pr.setLevel(4);
		p.giveExp(pr);
		assertEquals(2, p.getLevel());
	}

	@Test
	void testAplicarObjeto() {
		Pokemon p = new Pokemon(0, "Gengar", 100);
		Obj o = new Obj();
		o.setId(3);
		o.setAtk(1.5);
		p.setAtk(10);
		p.setDef(10);
		p.setSpAtk(10);
		p.setSpDef(10);
		p.setSpeed(10);
		p.setStamina(100);
		p.setObject(o);
		p.aplicarObjeto();
		assertEquals(15, p.getAtk());
	}
	
	@Test
	void testQuitarObjeto() {
		Pokemon p = new Pokemon(0, "Gengar", 100);
		Obj o = new Obj();
		o.setId(3);
		o.setAtk(1.5);
		p.setAtk(10);
		p.setDef(10);
		p.setSpAtk(10);
		p.setSpDef(10);
		p.setSpeed(10);
		p.setStamina(100);
		p.setObject(o);
		p.aplicarObjeto();
		p.quitarObjeto();
		assertEquals(10, p.getAtk());
	}
	

}
