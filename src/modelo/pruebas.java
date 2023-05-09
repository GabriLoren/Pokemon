package modelo;

import java.util.LinkedList;

import crud.CargarTodosLosEntrenadores;
import crud.CargarTodosPokemons;
import funcionalidades.Criar;


public class pruebas {
	
	public static void main(String[] args) {
		
		CargarTodosLosEntrenadores.cargarTodosLosEntrenadores();
		
		CargarTodosPokemons.cargarPokemonDesdeBbDd();
		
		Trainer t=new Trainer(0, null, 0);
		
		LinkedList<Pokemon>p=CargarTodosPokemons.getPokemon();
		
		t.setEquipoPokemon(p);
		
		t.getEquipoPokemon().removeLast();
		
				
		for(int i=0;i<p.size();i++) {
			
			System.out.println(p.get(i).getName());
		}
		
	System.out.println();
	
	
	for(int i=0;i<p.size();i++) {
		
		System.out.println(p.get(i).getName());
	}
		
	}

}
