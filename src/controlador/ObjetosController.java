package controlador;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import modelo.AddObject;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class ObjetosController {
	@FXML
	private Label etiqueta;
	@FXML
	private TextField texto;
	@FXML
	private Button boton;
	@FXML
	private Button boton2;
	@FXML
	private TextField texto1;
	@FXML
	private Label etiqueta1;
	@FXML
	private Label etiqueta2;
	@FXML
	private Label etiqueta11;

	// Event Listener on Button[#boton].onAction
	@FXML
	public void mostrarObjetos(ActionEvent event) {
		// TODO Autogenerated
		etiqueta.setText(AddObject.obtenerObjetosBbDD());	
	}
	// Event Listener on Button[#boton2].onAction
	@FXML
	public void insertarMovimiento(ActionEvent event) {
		// TODO Autogenerated
		
		texto1.getText();
		
		AddObject.addObjectToPokemon(null, null);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
