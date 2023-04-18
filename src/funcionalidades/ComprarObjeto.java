package funcionalidades;

import modelo.Obj;
import modelo.Trainer;

public class ComprarObjeto {
	
	public static void comprarObjeto(Trainer entrenador, Obj objeto) {
		System.out.println("antes de comprar"+entrenador.getPokeDollar());
		
		if(objeto.getName().equalsIgnoreCase("lanza"))entrenador.setPokeDollar(entrenador.getPokeDollar()-20);
		
		ActualizarPokedollarEntrenador.actualizarPokedollarEntrenador(entrenador);
		
		AddObject.insertarEnBbDdElObjetoComprado(objeto, entrenador.getId());
		
		System.out.println("depues de comprar"+entrenador.getPokeDollar());
		
	}

}
