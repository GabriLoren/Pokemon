package funcionalidades;

import java.util.LinkedList;

import modelo.Obj;
import modelo.Trainer;

public class ComprarObjeto {

	// inserta el objeto comprado en la BbDD y actualiza el dinero del entrenador
	// depués de la compra del objeto
	public static void comprarObjeto(Trainer entrenador, Obj objeto) {
		System.out.println("antes de comprar" + entrenador.getPokeDollar());
		
		

//		if (objeto.getName().equalsIgnoreCase("lanza"))
			entrenador.setPokeDollar(entrenador.getPokeDollar() - 20);

		ActualizarPokedollarEntrenador.actualizarPokedollarEntrenador(entrenador);

		AddObject.insertarEnBbDdElObjetoComprado(objeto, entrenador.getId());

		System.out.println("depues de comprar" + entrenador.getPokeDollar());

	}

	// comprueba si el objeto insertado en el textField existe y si es así lo
	// devuelve true si no false
	public static boolean objetoSeleccionado(LinkedList<Obj> objetosTienda, String objetoComprado, Trainer entrenador) {

//		boolean objetoSelecconado = false;

		for (int i = 0; i < objetosTienda.size(); i++) {

			Obj objetoElegido = objetosTienda.get(i);

			System.out.println(objetosTienda.get(i).getName());

			if (objetoComprado.equalsIgnoreCase(objetoElegido.getName())) {

				System.out.println("ha entrado");
				
				if(comprobarSaldoEntrenador(entrenador, objetoElegido))
				return true;
				else {
					System.out.println("no hay suficiente dinero");
					return false;
				}

			}

		}
		System.out.println("ha entrado en false");
		return false;
	}
	
	
	
	public static boolean comprobarSaldoEntrenador(Trainer entrenador, Obj objetoElegido) {
		
		if(entrenador.getPokeDollar()>=20) {
			entrenador.getObjetos().add(objetoElegido);
			
			comprarObjeto(entrenador, objetoElegido);
			
			return true;
			
		}
		else return false;
	}

}
