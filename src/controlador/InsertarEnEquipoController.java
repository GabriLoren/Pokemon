package controlador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import modelo.Pokemon;
import modelo.Trainer;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ResourceBundle;

import cargar.CargarEntrenador;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class InsertarEnEquipoController implements Initializable {
	@FXML
	private TextField txtInsertar;
	@FXML
	private TextField txtSacar;
	@FXML
	private Button btnInsertar;
	@FXML
	private Label lblInsertar;
	@FXML
	private Label lblSacar;
	@FXML
	private Label lblEquipo;
	@FXML
	private Label lblTodos;
	
	private Trainer entrenador=CargarEntrenador.getEntrenador();;

	// Event Listener on Button[#btnInsertar].onAction
	@FXML
	public void insertar(ActionEvent event) {
		// TODO Autogenerated
		
		try {
			int idPokemonInsertar=Integer.parseInt(txtInsertar.getText());
			
//			int idPokemonSacar=Integer.parseInt(lblSacar.getText());
			
			Pokemon insertar=entrenador.getTodosLosPokemon().get(idPokemonInsertar);
			
			entrenador.getEquipoPokemon().add(insertar);
			
			entrenador.getTodosLosPokemon().remove(insertar);
			
			lblTodos.setText(entrenador.getTodosLosPokemon().toString());
			
			lblEquipo.setText(entrenador.getEquipoPokemon().toString());
			
			if(entrenador.getEquipoPokemon().size()>5)lblEquipo.setText("Saca uno para poder insertar otro\n"+entrenador.getEquipoPokemon().toString());
		} catch (Exception e) {
			// TODO: handle exception
			lblEquipo.setText("Valor incorrecto\n"+entrenador.getEquipoPokemon().toString());
		}
		
		
//		Pokemon sacar=entrenador.getEquipoPokemon().get(idPokemonSacar);
		
		
//		LinkedList<Pokemon>insertarPokemonEnEquipo=entrenador.getEquipoPokemon();
//		insertarPokemonEnEquipo.add(insertar);
//		
//		entrenador.setEquipoPokemon(insertarPokemonEnEquipo);
//		
//		System.out.println(insertarPokemonEnEquipo.toString());
		
//		entrenador.getTodosLosPokemon().remove(insertar);
		
		
		
		
		
		
		
		
		
//		(idPokemonInsertar);
		
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
		
		String todosPokemon=entrenador.getTodosLosPokemon().toString();
		
		String equipo=entrenador.getEquipoPokemon().toString();
		
		lblTodos.setText(todosPokemon);
		
		lblEquipo.setText(equipo);
		
	}
}