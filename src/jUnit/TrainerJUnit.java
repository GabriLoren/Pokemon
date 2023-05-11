package jUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Obj;
import modelo.Pokemon;
import modelo.Trainer;

class TrainerJUnit {

	@Test
	void testCapturar() {
		Pokemon p = new Pokemon(0, "Gengar", 100);
		Trainer t = new Trainer(0, "Paquito69", 1000);
		p.setEquipo("SI");
		t.capturar(p);
		assertTrue(t.getEquipoPokemon().contains(p));
		
	}

	@Test
	void testInsertarObjetoComprado() {
		Trainer t = new Trainer(0, "Paquito69", 1000);
		Obj o = new Obj();
		t.insertarObjetoComprado(o);
		assertTrue(t.getObjetos().contains(o));
	}

	@Test
	void testMostraTodosLosPokemons() {
		fail("Not yet implemented");
	}

	@Test
	void testMostraTodosLosPokemonsStatic() {
		fail("Not yet implemented");
	}

}
