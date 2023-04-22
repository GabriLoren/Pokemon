package controlador;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import cargar.CargarEntrenador;
import cargar.CargarTodosPokemons;
import funcionalidades.ActualizarCaracteristicasPokemon;
import funcionalidades.Entrenar2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Pokemon;
import modelo.Trainer;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

public class Entrenar2Controller implements Initializable {
	
	@FXML
	private Label noSuficienteDinero;
	@FXML
	private TableView tabla;
	@FXML
	private TableColumn c1;
	@FXML
	private TableColumn c2;
	@FXML
	private TableColumn c3;
	
	private Trainer entrenador=CargarEntrenador.getEntrenador();
	
	private LinkedList<Pokemon> equipoPokemon=entrenador.getEquipoPokemon();

	
	public void seleccionarPokemon(String tipoEntrenamiento) {
		
		ObservableList<Pokemon>pokemonSeleccionado=tabla.getSelectionModel().getSelectedItems();
		
		ObservableList<Pokemon>pokemon=tabla.getItems();
		
		
//	for(int i=0;i<to)	
		int id=0;
	for(Pokemon p: pokemonSeleccionado) {
		
		id=p.getId();
		
	}
		
		System.out.println("el id es:"+id);
		
		for(int i=0;i<entrenador.getEquipoPokemon().size();i++) {
			
			if(entrenador.getEquipoPokemon().get(i).getId()==id) {
				
				//si es true muestra en el label "no hay suficiente dinero"
				if(Entrenar2.tipoEntrenamiento(entrenador, tipoEntrenamiento,entrenador.getEquipoPokemon().get(i)))noSuficienteDinero.setText("no hay suficiente dinero");
				

				
				System.out.println(entrenador.getEquipoPokemon().get(i).getVit());
				
				
				ActualizarCaracteristicasPokemon.actualizarPokemonEnBbDd(entrenador.getEquipoPokemon().get(i));
				
				System.out.println(entrenador.getEquipoPokemon().get(i).getVit());
				
				tabla.setItems(metodo());
			}
			
			

		
		System.out.println(entrenador.getPokeDollar());
	
		
		
	}
	}
	
	
	public ObservableList<Pokemon>metodo() {
		
		ObservableList<Pokemon>lista= FXCollections.observableArrayList();
		
//		lista.add(new Pokemon(0, "a", 0));
//		lista.add(new Pokemon(0, "a", 0));
//		lista.add(new Pokemon(0, "a", 0));
//		lista.add(new Pokemon(0, "a", 0));
		
		
		for(int i=0;i<equipoPokemon.size();i++) {
			
			Pokemon p=new Pokemon(0, null, 0);
			
			p.setId(equipoPokemon.get(i).getId());
			p.setName(equipoPokemon.get(i).getName());
			p.setVit(equipoPokemon.get(i).getVit());
			
			
			
			lista.add(p);

		}
		
				
		return lista;
		
	}
	
	

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
//		System.out.println(todosLosPokemon.toString());
		
		tabla.setItems(metodo());
		
//		tabla.getColumns().addAll(c1);
		
		c1.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("id"));
		c2.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("name"));
		c3.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("vit"));
		
		
		
	
		System.out.println(equipoPokemon);
		
	}
	
	
//	// Event Listener on Button.onAction
//		@FXML
//		public void eliminar(ActionEvent event) {
//			
//			seleccionarPokemon();
//			
//		}
		// Event Listener on Button.onAction
		@FXML
		public void furioso(ActionEvent event) {
			// TODO Autogenerated
			seleccionarPokemon("FURIOSO");
		}
		// Event Listener on Button.onAction
		@FXML
		public void funcional(ActionEvent event) {
			// TODO Autogenerated
			seleccionarPokemon("FUNCIONAL");
		}
		// Event Listener on Button.onAction
		@FXML
		public void onirico(ActionEvent event) {
			// TODO Autogenerated
			seleccionarPokemon("ONIRICO");
		}
		// Event Listener on Button.onAction
		@FXML
		public void pesado(ActionEvent event) {
			// TODO Autogenerated
			seleccionarPokemon("PESADO");
		}

}