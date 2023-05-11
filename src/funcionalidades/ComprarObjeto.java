package funcionalidades;

import java.util.LinkedList;

import crud.AddObject;
import modelo.Obj;
import modelo.Trainer;

public class ComprarObjeto {

	// inserta el objeto comprado en la BbDD y actualiza el dinero del entrenador
	// depués de la compra del objeto
	public static void comprarObjeto(Trainer entrenador, Obj objeto) {

		entrenador.setPokeDollar(entrenador.getPokeDollar() - objeto.getPrecio());

		ActualizarPokedollarEntrenador.actualizarPokedollarEntrenador(entrenador);

//		comprobarSiTieneObjetoComprado(entrenador, objeto);

//		entrenador.comprobarSiTieneObjetoComprado(objeto);

		AddObject.insertarEnBbDdElObjetoComprado(objeto, entrenador);

	}

//	// comprueba si el objeto insertado en el textField existe y si es así lo
//	// devuelve true si no false
//	public static boolean objetoSeleccionado(LinkedList<Obj> objetosTienda, String objetoComprado, Trainer entrenador) {
//
////		boolean objetoSelecconado = false;
//
//		for (int i = 0; i < objetosTienda.size(); i++) {
//
//			Obj objetoElegido = objetosTienda.get(i);
//
//			System.out.println(objetosTienda.get(i).getName());
//
//			if (objetoComprado.equalsIgnoreCase(objetoElegido.getName())) {
//
//				System.out.println("ha entrado");
//
//				if (comprobarSaldoEntrenador(entrenador, objetoElegido))
//					return true;
//				else {
//					System.out.println("no hay suficiente dinero");
//					return false;
//				}
//
//			}
//
//		}
//		System.out.println("ha entrado en false");
//		return false;
//	}

	public static boolean comprobarSaldoEntrenador(Trainer entrenador, Obj objetoElegido) {

		if (entrenador.getPokeDollar() >= objetoElegido.getPrecio()) {

			comprobarSiTieneObjetoComprado(entrenador, objetoElegido);

			comprarObjeto(entrenador, objetoElegido);

			return true;

		} else
			return false;
	}

	public static void comprobarSiTieneObjetoComprado(Trainer entrenador, Obj objetoComprado) {

		boolean objetoRepetido = false;

		for (int i = 0; i < entrenador.getObjetos().size(); i++) {

			System.out.println();

			if (entrenador.getObjetos().get(i).getName().equalsIgnoreCase(objetoComprado.getName())) {

				entrenador.getObjetos().get(i).setCantidad(entrenador.getObjetos().get(i).getCantidad() + 1);

				System.out.println("cantidad de objetos " + entrenador.getObjetos().get(i).getCantidad());

				// si entra el objeto lo tiene repetido y por tanto solo
				// hay que actualizar el número de objetos del mismo tipo
				objetoRepetido = true;
				break;

			}
			
		}
		//si no lo tiene repetido lo inserta por primera vez en la lista de objetos
		//del entrenador(mochila)
		if(objetoRepetido==false) {
			
			objetoComprado.setCantidad(1);
			entrenador.getObjetos().add(objetoComprado);
		}
	}
	public static void comprobarSiTieneObjetoCompradoYrestar(Trainer entrenador, Obj objetoComprado) {

		boolean objetoRepetido = false;

		for (int i = 0; i < entrenador.getObjetos().size(); i++) {

			System.out.println();

			if (entrenador.getObjetos().get(i).getName().equalsIgnoreCase(objetoComprado.getName())) {

				entrenador.getObjetos().get(i).setCantidad(entrenador.getObjetos().get(i).getCantidad() - 1);

				System.out.println("cantidad de objetos " + entrenador.getObjetos().get(i).getCantidad());

				// si entra el objeto lo tiene repetido y por tanto solo
				// hay que actualizar el número de objetos del mismo tipo
				objetoRepetido = true;
				break;

			}
			
		}
		//si no lo tiene repetido lo inserta por primera vez en la lista de objetos
		//del entrenador(mochila)
		if(objetoRepetido==false) {
			
			objetoComprado.setCantidad(1);
			entrenador.getObjetos().remove(objetoComprado);
		}
	}

}
