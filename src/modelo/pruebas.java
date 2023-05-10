package modelo;

import java.util.LinkedList;

import crud.AddObject;
import crud.CargarTodosLosEntrenadores;
import crud.CargarTodosPokemons;
import funcionalidades.Criar;


public class pruebas {
	

	public static void main(String[] args) {
		
		Trainer t=new Trainer(1, null, 0);
		Obj o=new Obj(1, null);
		
		System.out.println(AddObject.objtenerCantidadDeObjetos(t, o)); 
		
		
	}

}
