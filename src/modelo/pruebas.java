package modelo;

import java.util.LinkedList;

import cargar.CargarTodosLosEntrenadores;
import cargar.CargarTodosPokemons;
import funcionalidades.Criar;


public class pruebas {
	
	public static void main(String[] args) {
		

		CargarTodosLosEntrenadores.cargarTodosLosEntrenadores();
		Trainer yo= CargarTodosLosEntrenadores.getTodosLosEntrenadores().get(0);
		
		Pokemon p1= yo.getEquipoPokemon().get(0);
		Pokemon p2= yo.getEquipoPokemon().get(1);
		
		p1.getMoves().add(new Move("patada"));
		p1.getMoves().add(new Move("torta"));
		p1.getMoves().add(new Move("hostia"));
		p1.getMoves().add(new Move("escupitajo"));
		p2.getMoves().add(new Move("torta"));
		p2.getMoves().add(new Move("cabezazo"));
		p2.getMoves().add(new Move("mareo"));
		
		System.out.println(p1.toString());
		System.out.println();
		System.out.println(p2.toString());
		System.out.println();
		
//		System.out.println(p1.getMoves()+"  "+p2.getName());
		
//		System.out.println("todos los pokemon "+yo.getTodosLosPokemon().toString());
		
		Criar.Criar(p1, p2, yo);
		
		
		
		System.out.println(yo.getTodosLosPokemon().getLast().toString());
		

	
		
		
	}

}
