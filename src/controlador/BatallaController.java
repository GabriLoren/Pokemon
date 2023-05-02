package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import cargar.CargarEntrenador;
import cargar.CargarTodosLosEntrenadores;
import funcionalidades.ActualizarPokedollarEntrenador;
import funcionalidades.Batalla;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Move;
import modelo.Pokemon;
import modelo.Trainer;

public class BatallaController implements Initializable {
	@FXML
	private Button atacar;

	@FXML
	private Button cambiar;
	@FXML
	private Label muestraTurno;
	@FXML
	private ImageView imagenJugador;
	@FXML
	private ProgressBar barraMaquina;
	@FXML
	private ProgressBar barraEstaminaMaquina;
	@FXML
	private ProgressBar barraEstaminaJugador;

	@FXML
	private ImageView imagenOponente;
	@FXML
	private Button descansar;
	@FXML
	private Button elegirMovimiento;
	@FXML
	private ProgressBar barra;

	double vidaJugador;

	double vidaMaquina;

	Pokemon pokemonElegido;

	Image imagenAtaqueJugador;
//--------------------------------------------------------------------------------------

	private static int contadorJugador = 0;

	private static int contadorMaquina = 0;

	// todos los entrenadores que hay en la base de datos
	private static LinkedList<Trainer> todosLosEntrenadores = CargarTodosLosEntrenadores.getTodosLosEntrenadores();

	private static Trainer entrenadorJugador = CargarEntrenador.getEntrenador();

	private static Trainer entrenadorAleatorio;

	// hacemos una copia para no eliminarlos del equipo permanentemente
	static LinkedList<Pokemon> equipoJugador;

	private static LinkedList<Pokemon> equipoMaquina;

	private static Pokemon pokemonElegidoJugador;

	private static Pokemon pokemonElegidoMaquina;

	static LinkedList<Move> movimientosPokemonEnCombate;

	private static Move movimietoJugador;

	private static Move movimietoMaquina;

	private String turnoJugador;

	private String turnoOponente;

//--------------------------------------------------------------------------------------------

//	Image imagenAtaqueJugador = new Image(getClass().getResourceAsStream("p2.jpg"));

	public static Pokemon getPokemonElegidoJugador() {
		return pokemonElegidoJugador;
	}

	// Event Listener on Button[#descansar].onAction
	@FXML
	public void descansar(ActionEvent event) throws IOException {
		// TODO Autogenerated

		pokemonElegidoJugador.recuperarEstamina();

		// ATACA LA MAQUINA

		movimietoMaquina = Batalla.movimientoAleatorioMaquina(pokemonElegidoMaquina);

		if (Batalla.comprobraEstamina(pokemonElegidoMaquina, movimietoMaquina)) {

			if (Batalla.atacar(pokemonElegidoMaquina, pokemonElegidoJugador, movimietoMaquina)) {

				if (Batalla.vidaPokemonAtacado(pokemonElegidoJugador)) {

					contadorJugador++;

					equipoJugador.remove(pokemonElegidoJugador);

					if (equipoJugador.size() > 0) {

						// se abre la ventana con los pokemon del jugador para que seleccione otro
						FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/vista/ElegirPokemonBatalla.fxml"));

						Parent root2 = loader2.load();

						Scene scene2 = new Scene(root2);

						Stage stage2 = new Stage();

//						stage.initModality(Modality.APPLICATION_MODAL); //(hace que la ventana sea modal)

						stage2.setScene(scene2);
						stage2.showAndWait();

						pokemonElegidoJugador = ElegirPokemonBatallaController.pokemonElegido;

						imagenAtaqueJugador = new Image(
								getClass().getResourceAsStream(pokemonElegidoJugador.getImagen()));

						imagenJugador.setImage(imagenAtaqueJugador);

					}

				}

			}
			turnoOponente = "la máquina ha elegido " + movimietoMaquina.getName();

		} else {

			turnoOponente = "La maquina descansa, no tiene suficiente estamina";

			pokemonElegidoMaquina.recuperarEstamina();
		}

		vidaJugador = pokemonElegidoJugador.getVit();

		double vidaJugadorDouble = vidaJugador / 100;
		System.out.println("vida jugador" + vidaJugadorDouble);

		barra.setProgress(vidaJugadorDouble);

		if (contadorJugador == entrenadorJugador.getEquipoPokemon().size()) {

			contadorJugador = 0;

			contadorMaquina = 0;

			Batalla.restablecerVidaYEstamina(entrenadorJugador.getEquipoPokemon());

			Batalla.restablecerVidaYEstamina(entrenadorAleatorio.getEquipoPokemon());

			// se cierra la ventana actual
			Stage stage2 = (Stage) this.atacar.getScene().getWindow();
			stage2.close();

		}

		turnoJugador = "HAS DESCANSADO";

		muestraTurno.setText(turnoJugador + "\n" + "\n" + turnoOponente);

		barraEstaminaJugador.setProgress((double) pokemonElegidoJugador.getStamina() / (double) 100);

		barraEstaminaMaquina.setProgress((double) pokemonElegidoMaquina.getStamina() / (double) 100);

	}

	// Event Listener on Button[#atacar].onMousePressed
	@FXML
	public void pressedAtacar(MouseEvent event) {
		// TODO Autogenerated

//		Image imagenAtaqueJugador2 = new Image(getClass().getResourceAsStream(pokemonElegidoMaquina.getImagen()));
//
//		imagenJugador.setImage(imagenAtaqueJugador2);
	}

	// Event Listener on Button[#atacar].onMouseReleased
	@FXML
	public void releasedAtacar(MouseEvent event) {
		// TODO Autogenerated

//		imagenJugador.setImage(imagenAtaqueJugador);

	}

	// Event Listener on Button[#salir].onAction
	@FXML
	public void elegirMovimiento(ActionEvent event) throws IOException {
		// TODO Autogenerated

		// abre la ventana Elegirmovimiento
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ElegirMovimientos.fxml"));

		Parent root = loader.load();

		ElegirMovimientosController controlador = loader.getController();

		controlador.setMovimientosPokemonEnCombate(movimientosPokemonEnCombate);

		Scene scene = new Scene(root);

		Stage stage = new Stage();
//						stage.initModality(Modality.APPLICATION_MODAL); (hace que la ventana sea modal)
		stage.setScene(scene);

		// espera hasta que se cierre ElegirMovimientos para seguir ejecutando códifo
		stage.showAndWait();

		movimietoJugador = controlador.getMovimietoSeleccionado();

		turnoJugador = "Has elegido " + movimietoJugador.getName();

		turnoOponente = "";

		muestraTurno.setText(turnoJugador + "\n" + "\n" + turnoOponente);
	}

	// Event Listener on Button[#cambiar].onAction
	@FXML
	public void cambiar(ActionEvent event) throws IOException {
		// TODO Autogenerated
//		// abre la ventana Captura
		// se abre la ventana con los pokemon del jugador para que seleccione otro
		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/vista/ElegirPokemonBatalla.fxml"));

		Parent root2 = loader2.load();

		Scene scene2 = new Scene(root2);

		Stage stage2 = new Stage();

//		stage.initModality(Modality.APPLICATION_MODAL); //(hace que la ventana sea modal)

		stage2.setScene(scene2);
		stage2.showAndWait();

		pokemonElegidoJugador = ElegirPokemonBatallaController.pokemonElegido;

		imagenAtaqueJugador = new Image(getClass().getResourceAsStream(pokemonElegidoJugador.getImagen()));

		imagenJugador.setImage(imagenAtaqueJugador);

		barra.setProgress((double) pokemonElegidoJugador.getVit() / (double) 100);

		barraEstaminaJugador.setProgress((double) pokemonElegidoJugador.getStamina() / (double) 100);

		movimietoJugador = null;

		turnoJugador = "";

		turnoOponente = "";

		muestraTurno.setText(turnoJugador + "\n" + "\n" + turnoOponente);

	}

	// Event Listener on Button[#atacar].onAction
	@FXML
	public void atacar(ActionEvent event) throws IOException {
		// TODO Autogenerated

		// si no ha elegido un movimiento aún
		if (movimietoJugador == null) {
			// abre la ventana Elegirmovimiento
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ElegirMovimientos.fxml"));

			Parent root = loader.load();

			ElegirMovimientosController controlador = loader.getController();

			controlador.setMovimientosPokemonEnCombate(movimientosPokemonEnCombate);

			Scene scene = new Scene(root);

			Stage stage = new Stage();
//							stage.initModality(Modality.APPLICATION_MODAL); (hace que la ventana sea modal)
			stage.setScene(scene);

			// espera hasta que se cierre ElegirMovimientos para seguir ejecutando códifo
			stage.showAndWait();

			movimietoJugador = controlador.getMovimietoSeleccionado();

			turnoJugador = "Has elegido " + movimietoJugador.getName();

			if (movimietoMaquina == null)
				turnoOponente = "";
		}

		else if (Batalla.comprobraEstamina(pokemonElegidoJugador, movimietoJugador)) {

			if (Batalla.atacar(pokemonElegidoJugador, pokemonElegidoMaquina, movimietoJugador)) {
				
				turnoJugador = "has elegido " + movimietoJugador.getName();

				if (Batalla.vidaPokemonAtacado(pokemonElegidoMaquina)) {
					System.out.println("valor del contadorMaquina " + contadorMaquina);

					contadorMaquina++;

					if (contadorMaquina < equipoMaquina.size())
						pokemonElegidoMaquina = equipoMaquina.get(contadorMaquina);

					Image imagenMaquina = new Image(getClass().getResourceAsStream(pokemonElegidoMaquina.getImagen()));

					imagenOponente.setImage(imagenMaquina);

//					
				}

			} else
				turnoJugador = "Estas " + pokemonElegidoJugador.getStatus();

			// ATACA LA MAQUINA

			movimietoMaquina = Batalla.movimientoAleatorioMaquina(pokemonElegidoMaquina);

			if (Batalla.comprobraEstamina(pokemonElegidoMaquina, movimietoMaquina)) {

				// si no tiene ningun estado que le impide atacar
				if (Batalla.atacar(pokemonElegidoMaquina, pokemonElegidoJugador, movimietoMaquina)) {

					turnoOponente = "la máquina ha elegido " + movimietoMaquina.getName();

					if (Batalla.vidaPokemonAtacado(pokemonElegidoJugador)) {

						contadorJugador++;

						equipoJugador.remove(pokemonElegidoJugador);

						if (equipoJugador.size() > 0) {

							// se abre la ventana con los pokemon del jugador para que seleccione otro
							FXMLLoader loader2 = new FXMLLoader(
									getClass().getResource("/vista/ElegirPokemonBatalla.fxml"));

							Parent root2 = loader2.load();

							Scene scene2 = new Scene(root2);

							Stage stage2 = new Stage();

//							stage.initModality(Modality.APPLICATION_MODAL); //(hace que la ventana sea modal)

							stage2.setScene(scene2);
							stage2.showAndWait();

							pokemonElegidoJugador = ElegirPokemonBatallaController.pokemonElegido;

							imagenAtaqueJugador = new Image(
									getClass().getResourceAsStream(pokemonElegidoJugador.getImagen()));

							imagenJugador.setImage(imagenAtaqueJugador);

							movimietoJugador = null;

						}

					}

				} else
					turnoOponente = "La máquina está " + pokemonElegidoMaquina.getStatus();

			} else {

				turnoOponente = "La maquina descansa, no tiene suficiente estamina";

				pokemonElegidoMaquina.recuperarEstamina();
			}

			

			vidaJugador = pokemonElegidoJugador.getVit();

			double vidaJugadorDouble = vidaJugador / 100;
			System.out.println("vida jugador" + vidaJugadorDouble);

			barra.setProgress(vidaJugadorDouble);

			vidaMaquina = pokemonElegidoMaquina.getVit();

			double vidaMaquinaDouble = vidaMaquina / 100;

			barraMaquina.setProgress(vidaMaquinaDouble);

			barraEstaminaJugador.setProgress((double) pokemonElegidoJugador.getStamina() / (double) 100);

			barraEstaminaMaquina.setProgress((double) pokemonElegidoMaquina.getStamina() / (double) 100);

//			imagenJugador.setImage(new Image(getClass().getResourceAsStream(pokemonElegidoJugador.getImagen())));

			// pierde la máquina
			if (contadorMaquina == entrenadorAleatorio.getEquipoPokemon().size()) {

				muestraTurno.setText("has ganado el combate");

				contadorJugador = 0;

				contadorMaquina = 0;

				Batalla.restablecerVidaYEstamina(entrenadorJugador.getEquipoPokemon());

				Batalla.restablecerVidaYEstamina(entrenadorAleatorio.getEquipoPokemon());

				Batalla.premioGanadorBatalla(entrenadorJugador, entrenadorAleatorio);

				// se cierra la ventana actual
				Stage stage2 = (Stage) this.atacar.getScene().getWindow();
				stage2.close();

			}

			// pierde el jugador
			else if (contadorJugador == entrenadorJugador.getEquipoPokemon().size()) {

				contadorJugador = 0;

				contadorMaquina = 0;

				Batalla.restablecerVidaYEstamina(entrenadorJugador.getEquipoPokemon());

				Batalla.restablecerVidaYEstamina(entrenadorAleatorio.getEquipoPokemon());

				Batalla.premioGanadorBatalla(entrenadorAleatorio, entrenadorJugador);

//				 se cierra la ventana actual
				Stage stage2 = (Stage) this.atacar.getScene().getWindow();
				stage2.close();

			}

		} else
			turnoJugador = "NO TIENES ESTAMINA SUFICIENTE";

//-----------------------------------------------------------------------------------

		muestraTurno.setText(turnoJugador + "\n" + "\n" + turnoOponente);

	}

	// Event Listener on Button[#salir].onAction
	@FXML
	public void salir(ActionEvent event) {
		// TODO Autogenerated
		contadorJugador = 0;

		contadorMaquina = 0;

		Batalla.restablecerVidaYEstamina(entrenadorJugador.getEquipoPokemon());

		Batalla.restablecerVidaYEstamina(entrenadorAleatorio.getEquipoPokemon());
		
		movimietoJugador=null;

		// se cierra la ventana actual
		Stage stage2 = (Stage) this.atacar.getScene().getWindow();
		stage2.close();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		equipoJugador = new LinkedList<Pokemon>(entrenadorJugador.getEquipoPokemon());

		pokemonElegidoJugador = equipoJugador.getFirst();

		movimientosPokemonEnCombate = pokemonElegidoJugador.getMoves();

		entrenadorAleatorio = CargarEntrenador.obtenerEntrenadorAleatorio();

		equipoMaquina = new LinkedList<Pokemon>(entrenadorAleatorio.getEquipoPokemon());

		pokemonElegidoMaquina = equipoMaquina.get(contadorMaquina);

		imagenAtaqueJugador = new Image(getClass().getResourceAsStream(pokemonElegidoJugador.getImagen()));

		Image imagenMaquina = new Image(getClass().getResourceAsStream(pokemonElegidoMaquina.getImagen()));

		imagenJugador.setImage(imagenAtaqueJugador);

		imagenOponente.setImage(imagenMaquina);

		barra.setProgress(1);

	}
}
