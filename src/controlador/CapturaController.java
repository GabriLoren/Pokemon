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
import cargar.CargarPokemonEnEntrenador;
import funcionalidades.Captura;
import funcionalidades.GeneraPokemonAleatorio;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Pokemon;
import modelo.Trainer;

public class CapturaController implements Initializable {
	@FXML
	private Button capturarPokemon;
	@FXML
	private Button bucarPokemon;
	@FXML
	private Label pokemonEncontrado;
	

	private static Pokemon pokemon;

	private Trainer entrenador = CargarEntrenador.getEntrenador();
	
	@FXML
	private Label lblMote;

	@FXML
	private Button btnInsertarMote;
	
	@FXML
	private TextField txtMote;

	public Pokemon getPokemon() {
		return pokemon;
	}

	// Event Listener on Button[#btnInsertarMote].onAction
	@FXML
	public void insertarMotre(ActionEvent event) {
		// TODO Autogenerated

		String mote = txtMote.getText().toUpperCase();

		if (Pokemon.comprobarMote(mote)&&!mote.equals("")) {
			Captura.insertarEnBbDdElPokemonEncontrado(pokemon, mote, entrenador.getId());//inserta en pokemon capturado en la BbDd
			entrenador.insertraPokemonCapturado(pokemon,mote );//inserta el pokemon capturado en LinkedList<Pokemon> todosLosPokemon;
			
			Stage stage = (Stage) this.txtMote.getScene().getWindow(); 
			
			stage.close();
			
			
			
		}
		else {
		
			lblMote.setText("No se pueden introducir palabrotas ni dejar el mote vacio");

		}

//		pokemonCapturado.setText("Enhorabuenas has capturado un nuevo " + pokemon.getName());

		
	}

	// Event Listener on Button[#capturarPokemon].onAction
	@FXML
	public void capturarPokemon(ActionEvent event) throws IOException {
		
		int aletorio=(int)(Math.random()*3+1);
		int cazado=3;
		System.out.println(aletorio);

		if (pokemon != null) {
			
			if(aletorio==cazado) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/InsertarMote.fxml"));

				Parent root = loader.load();

				Scene scene = new Scene(root);

				Stage stage = new Stage();
//				stage.initModality(Modality.APPLICATION_MODAL); (hace que la ventana sea modal)

				stage.setScene(scene);
				stage.show();
				
				
				
			}else pokemonEncontrado.setText("No has conseguido, atrapalo inténtalo de nuevo");

		

		}

		else if (pokemon == null)
			pokemonEncontrado.setText("Aún no has encontrado ningun pokemon");
	}

	// Event Listener on Button[#bucarPokemon].onAction
	@FXML
	public void bucarPokemon(ActionEvent event) {

		pokemon = GeneraPokemonAleatorio.mostrarPokemonEncontrado();

		pokemonEncontrado.setText("has enconrado un " + pokemon.getName());

//		InsertarMoteController.setPokemon(pokemon);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
//		CargarPokemon.cargarPokemonDesdeBbDd();

//		for (int i = 0; i < pokemon.size(); i++) {
//            System.out.println(pokemon.get(i).toString());
//		}
//		
	}
}
