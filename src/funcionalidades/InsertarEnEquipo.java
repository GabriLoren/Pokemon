package funcionalidades;

import java.io.IOException;

import modelo.Pokemon;
import modelo.Trainer;

public class InsertarEnEquipo {

	/**introducimos el mote para identificar el pokemon que queremos añadir al equipo
	 * @param entrenador
	 * @param mote del pokemon que queremos añadir
	 * @return 0 si no hay más pokemon para añadir, 1 si el pokemon no existe, 2 si el equipo está completo y 3 si el Pokemon ha sido añadido satisfactoriamente
	 */
	public static int insertarEnEquipo(Trainer entrenador, String mote) {

		
		int posicion = -1;

		if(entrenador.getTodosLosPokemon().size() < 1)return 0;//no hay más pokemon para añadir
		
	 if (entrenador.getEquipoPokemon().size() < 6) {

			for (int i = 0; i < entrenador.getTodosLosPokemon().size(); i++) {

				if (entrenador.getTodosLosPokemon().get(i).getNickname().equalsIgnoreCase(mote))
					posicion = i;

			}
			// si existe el mote, la variable posicion coge el valor de la posición de ese pokemon en la
			// linkedlist, si no sigue en -1
			if (posicion != -1) {
				Pokemon insertar = entrenador.getTodosLosPokemon().get(posicion);

				entrenador.getEquipoPokemon().add(insertar);

				entrenador.getTodosLosPokemon().remove(insertar);
				return 3;//El Pokemon ha sido añadido satisfactoriamente
				
			}else {
				return 1;//Ese pokemon no existe
			}

		}
		
		else
			return 2;//Equipo completo, saca un Pokemon primero
	
		
	}
}
