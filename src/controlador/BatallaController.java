package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.Move;
import modelo.Pokemon;
import modelo.Trainer;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import cargar.CargarEntrenador;
import cargar.CargarTodosLosEntrenadores;
import funcionalidades.Batalla;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class BatallaController implements Initializable {

	@FXML
	private Button elegirMovimiento;
	@FXML
	private static Label muestraTurno;

	@FXML
	private Button seleccionar;
	@FXML
	private TableView tabla;
	@FXML
	private TableColumn mote;
	@FXML
	private TableColumn nombre;
	@FXML
	private TableColumn ataque;
	@FXML
	private TableColumn defensa;
	@FXML
	private TableColumn ataqueSp;
	@FXML
	private TableColumn defensaSp;
	@FXML
	private TableColumn velocidad;
	@FXML
	private TableColumn estamina;
	@FXML
	private TableColumn nivel;
	@FXML
	private TableColumn vitalidad;
	@FXML
	private TableColumn tipo1;
	@FXML
	private TableColumn tipo2;
	@FXML
	private Button atacar;
	private static int contadorJugador = 0;

	private static int contadorMaquina = 0;

	// todos los entrenadores que hay en la base de datos
	private static LinkedList<Trainer> todosLosEntrenadores = CargarTodosLosEntrenadores.getTodosLosEntrenadores();

	private static Trainer entrenadorJugador = CargarEntrenador.getEntrenador();

	private static Trainer entrenadorAleatorio = CargarEntrenador.obtenerEntrenadorAleatorio(todosLosEntrenadores);

	private static LinkedList<Pokemon> equipoMaquina = Batalla
			.copiaEquipoPokemon(entrenadorAleatorio.getEquipoPokemon());

	private static LinkedList<Pokemon> equipoJugador = Batalla.copiaEquipoPokemon(entrenadorJugador.getEquipoPokemon());

	private static Pokemon pokemonElegidoJugador = equipoJugador.get(contadorJugador);

	private static Pokemon pokemonElegidoMaquina = equipoMaquina.get(contadorMaquina);


	public static LinkedList<Pokemon> getEquipoJugador() {
		return equipoJugador;
	}

	public void setEquipoJugador(LinkedList<Pokemon> equipoJugador) {
		this.equipoJugador = equipoJugador;
	}

	private static int pokemonElegido = 0;

	public static Pokemon getPokemonElegidoJugador() {
		return pokemonElegidoJugador;
	}

	public static void setPokemonElegidoJugador(Pokemon pokemonElegidoObjeto) {
		BatallaController.pokemonElegidoJugador = pokemonElegidoObjeto;
	}

	// probamos con un movimiento que creamos
	private static Move movimietoJugador = null;
	private Move movimietoMaquina = null;

	public static Move getMovimietoJugador() {
		return movimietoJugador;
	}

	public static void setMovimietoJugador(Move movimietoJugador) {
		BatallaController.movimietoJugador = movimietoJugador;
	}

	@FXML
	private Button cambiarPokemon;

	// Event Listener on Button[#cambiarPokemon].onAction
	@FXML
	public void cambiarPokemon(ActionEvent event) throws IOException {
		// TODO Autogenerated
		// se abre la ventana con los pokemon del jugador para que seleccione otro
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ElegirPokemonBatalla.fxml"));

		Parent root = loader.load();

		Scene scene = new Scene(root);

		Stage stage = new Stage();
//				stage.initModality(Modality.APPLICATION_MODAL); (hace que la ventana sea modal)

		stage.setScene(scene);
		stage.show();

	}

	// Event Listener on Button[#elegirMovimiento].onAction
	@FXML
	public void elegirMovimiento(ActionEvent event) throws IOException {
		// TODO Autogenerated
		// se abre la ventana con los pokemon del jugador para que seleccione otro
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ElegirMovimientos.fxml"));

		Parent root = loader.load();

		Scene scene = new Scene(root);

		Stage stage = new Stage();
//				stage.initModality(Modality.APPLICATION_MODAL); (hace que la ventana sea modal)

		stage.setScene(scene);
		stage.show();

	}

	// Event Listener on Button[#atacar].onAction
	@FXML
	public void atacar(ActionEvent event) throws IOException {
		// TODO Autogenerated

//		System.out.println("La máquina a elegido a " + pokemonElegidoMaquina.getName() + "\n"
//				+ "Tú has elegido a " + pokemonElegidoJugador.getName());

//		System.out.println("vida del pokemonMaquina ANTES DEL ATAQUE" + pokemonElegidoMaquina.getVit());
//
//		System.out.println("has elegido el movimiento " + movimietoJugador.getName());




		if (Batalla.atacar(pokemonElegidoJugador, pokemonElegidoMaquina, movimietoJugador)) {

			if (Batalla.vidaPokemonAtacado(pokemonElegidoMaquina)) {
				System.out.println("valor del contadorMaquina " + contadorMaquina);

				contadorMaquina++;

//				System.out.println("La máquina a elegido a " + pokemonElegidoMaquina.getName() + "\n"
//						+ "Tú has elegido a " + pokemonElegidoJugador.getName());

				if (contadorMaquina < equipoMaquina.size())
					pokemonElegidoMaquina = equipoMaquina.get(contadorMaquina);
			}

		}

//		System.out.println("vida del pokemonMaquina DEPUES DEL ATAQUE" + pokemonElegidoMaquina.getVit());
//		System.out.println();
		
		// para hacer pruebas, cuando los pokemon tengan sus movimientos no será
		// necesario

		

	
		//para hacer pruebas
		movimietoMaquina=pokemonElegidoMaquina.getMoves().getFirst();
		
		System.out.println("EL ESTADO DEL PONKEMON ES "+pokemonElegidoMaquina.getStatus());

//		System.out.println("vida del pokemonJugador ANTES DEL ATAQUE " + pokemonElegidoJugador.getVit());
		
//		System.out.println("la máquina ha elegido el movimiento " + movimietoMaquina.getName());

		if (Batalla.atacar(pokemonElegidoMaquina, pokemonElegidoJugador, movimietoMaquina)) {

			if (Batalla.vidaPokemonAtacado(pokemonElegidoJugador)) {

				contadorJugador++;

				equipoJugador.remove(pokemonElegidoJugador);

				if (equipoJugador.size() > 0) {
					// elimina el pokemon que ha muerto de la lista de los pokemon disponible para
					// luchar

					// se abre la ventana con los pokemon del jugador para que seleccione otro
					FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/vista/ElegirPokemonBatalla.fxml"));

					Parent root2 = loader2.load();

					Scene scene2 = new Scene(root2);

					Stage stage2 = new Stage();
//							stage.initModality(Modality.APPLICATION_MODAL); (hace que la ventana sea modal)

					stage2.setScene(scene2);
					stage2.show();
				}

			}

		}
//
		System.out.println("vida del pokemonJugador DESPUES DEL ATAQUE " + pokemonElegidoJugador.getVit());
		System.out.println();

		if (contadorMaquina == entrenadorAleatorio.getEquipoPokemon().size()) {

			System.out.println("has ganado el combate");

			// se cierra la ventana actual
			Stage stage2 = (Stage) this.atacar.getScene().getWindow();
			stage2.close();

		}

		else if (contadorJugador == entrenadorJugador.getEquipoPokemon().size()) {

			System.out.println("has perdido el combate");
			// se cierra la ventana actual
			Stage stage2 = (Stage) this.atacar.getScene().getWindow();
			stage2.close();
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
