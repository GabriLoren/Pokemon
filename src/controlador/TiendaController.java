package controlador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import crud.AddObject;
import crud.CargarEntrenador;
import crud.CargarMoves;
import crud.CargarTodosLosObjetos;
import crud.PokemonEntrenadorCrud;
import funcionalidades.ActualizarEquipoBbDd;
import funcionalidades.ComprarObjeto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Obj;
import modelo.Pokemon;
import modelo.Trainer;
import javafx.scene.control.TableColumn;

public class TiendaController implements Initializable {
	@FXML
	private TableView tienda;
	@FXML
	private TableColumn objeto;
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
	private TableColumn precio;
	@FXML
	private TableView mochila;
	@FXML
	private TableColumn objetosEntrenador;
	@FXML
	private TableColumn cantidadObjetos;
	@FXML
	private TableView Pokemon;
	@FXML
	private TableColumn motePokemon;
	@FXML
	private TableColumn nombrePokemon;
	@FXML
	private TableColumn ataquePokemon;
	@FXML
	private TableColumn defensaPokemon;
	@FXML
	private TableColumn ataqueSpPokemon;
	@FXML
	private TableColumn defensaSpPokemon;
	@FXML
	private TableColumn velocidadPokemon;
	@FXML
	private TableColumn estaminaPokemon;
	@FXML
	private TableColumn objetoPokemon;
	@FXML
	private Button comprar;
	@FXML
	private Button quitar;
	@FXML
	private Button vender;
	@FXML
	private Button insertar;
	@FXML
	private Label pokedollarEntrenador;

	private ObservableList<Obj> objetoSeleccionado;

	private static Trainer entrenador;

	// Event Listener on Button[#comprar].onAction
	@FXML
	public void comprar(ActionEvent event) {
		// TODO Autogenerated
		objetoSeleccionado = tienda.getSelectionModel().getSelectedItems();

		Obj objeto = objetoSeleccionado.get(0);

		// si es true efectua la compra
		if (ComprarObjeto.comprobarSaldoEntrenador(entrenador, objeto)) {

			pokedollarEntrenador.setText(entrenador.getPokeDollar() + "");

//			entrenador.comprobarSiTieneObjetoComprado(objeto);

//			CargarEntrenador.getEntrenador().comprobarSiTieneObjetoComprado(objeto);

			System.out.println("objetos entrenador " + entrenador.getObjetos());

		} else
			pokedollarEntrenador.setText("Saldo insuficiente");

		mochila.setItems(muestraMochila());

	}

	// Event Listener on Button[#quitar].onAction
	@FXML
	public void quitar(ActionEvent event) {
		// TODO Autogenerated
		ObservableList<Pokemon> p = Pokemon.getSelectionModel().getSelectedItems();
		Pokemon pokeonSeleccionado = p.get(0);

//		Pokemon pokemon=null;
//		
//		for(int i=0;i<entrenador.getEquipoPokemon().size();i++) {
//			
//		if(entrenador.getEquipoPokemon().get(i).getId()==(pokeonSeleccionado.getId()))	{
//			
//			 pokemon=entrenador.getEquipoPokemon().get(i);
//			
//		}
//	}

//		entrenador.getObjetos().add(pokeonSeleccionado.getObject());
//		
//		pokeonSeleccionado.setAtk(1000);

		if (!pokeonSeleccionado.getObject().getName().equalsIgnoreCase("NULO")) {

			// añade el objeto a la lista de objetos del entrenador
			ComprarObjeto.comprobarSiTieneObjetoComprado(entrenador, pokeonSeleccionado.getObject());

			// añade a la bbdd el objeto que se a quitado al pokemon(vuelve a la mochila)
			AddObject.insertarEnBbDdElObjetoComprado(pokeonSeleccionado.getObject(), entrenador);

//			AddObject.insertarEnBbDdElObjetoComprado(pokeonSeleccionado.getObject(), CargarEntrenador.getEntrenador());

			// LE APLICO LAS ESTADISTICAS QUE PROPORCIONA EL OBJETO(EN ESTE CASO LE PONGO
			// LAS QUE TENIA ANTES DE APLICARLE EL OBJETO)
			pokeonSeleccionado.quitarObjeto();

			// añado al pokemon el objeto que es nulo(como si no tubiera objeto)
			pokeonSeleccionado.setObject(new Obj(CargarTodosLosObjetos.getTodosLosObjetos().getFirst()));

			pokeonSeleccionado.setNombreObjeto(pokeonSeleccionado.getObject().getName());

			PokemonEntrenadorCrud.actualizarPokemonEnBbDd(pokeonSeleccionado);

			pokedollarEntrenador.setText(entrenador.getPokeDollar() + "");

		} else {

			pokedollarEntrenador.setText("ya tiene incorporado: " + pokeonSeleccionado.getObject().getName());

			pokedollarEntrenador.setText("no tienes incorporado ningin objeto ");
		}

		mochila.setItems(muestraMochila());

//		Pokemon.setItems(metodo());

		Pokemon.refresh();

	}

	// Event Listener on Button[#vender].onAction
	@FXML
	public void vender(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#insertar].onAction
	@FXML
	public void insertar(ActionEvent event) {
		// TODO Autogenerated
		ObservableList<Pokemon> p = Pokemon.getSelectionModel().getSelectedItems();

		ObservableList<Obj> o = mochila.getSelectionModel().getSelectedItems();

		
		
		Pokemon pokeonSeleccionado = p.get(0);

		Obj objetoSeleccionado = o.get(0);

		if (pokeonSeleccionado.getObject().getName().equalsIgnoreCase("NULO")) {

			pokeonSeleccionado.setObject(objetoSeleccionado);

			// LE APLICO LAS ESTADISTICAS QUE PROPORCIONA EL OBJETO
			pokeonSeleccionado.aplicarObjeto();

			PokemonEntrenadorCrud.actualizarPokemonEnBbDd(pokeonSeleccionado);

			System.out.println("el id del objeto es: " + objetoSeleccionado.getId());

			AddObject.eliminaEnBbDdElObjetoSacadoDeLaMochila(objetoSeleccionado, CargarEntrenador.getEntrenador());

			ComprarObjeto.comprobarSiTieneObjetoCompradoYrestar(entrenador, objetoSeleccionado);

			pokedollarEntrenador.setText(entrenador.getPokeDollar() + "");

		} else {

//			pokedollarEntrenador.setText("ya tiene incorporado: " +pokeonSeleccionado.getObject().getName());

			pokedollarEntrenador.setText("ya tiene incorporado: ");
		}
		mochila.setItems(muestraMochila());

		Pokemon.setItems(metodo());

		Pokemon.refresh();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		entrenador = CargarEntrenador.getEntrenador();

		pokedollarEntrenador.setText(CargarEntrenador.getEntrenador().getPokeDollar() + "");

		tienda.setItems(muestraTodoLosObjetos());

		objeto.setCellValueFactory(new PropertyValueFactory<Obj, String>("name"));
		precio.setCellValueFactory(new PropertyValueFactory<Obj, String>("precio"));
		ataque.setCellValueFactory(new PropertyValueFactory<Obj, String>("atk"));
		defensa.setCellValueFactory(new PropertyValueFactory<Obj, String>("def"));
		defensaSp.setCellValueFactory(new PropertyValueFactory<Obj, String>("spDef"));
		velocidad.setCellValueFactory(new PropertyValueFactory<Obj, String>("speed"));
		estamina.setCellValueFactory(new PropertyValueFactory<Obj, String>("stamina"));

		mochila.setItems(muestraMochila());

		objetosEntrenador.setCellValueFactory(new PropertyValueFactory<Obj, String>("name"));
		cantidadObjetos.setCellValueFactory(new PropertyValueFactory<Obj, String>("cantidad"));

		Pokemon.setItems(metodo());

		motePokemon.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("nickname"));
		nombrePokemon.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("name"));
		ataquePokemon.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("atk"));
		defensaPokemon.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("def"));
		ataqueSpPokemon.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("spAtk"));
		defensaSpPokemon.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("spDef"));
		velocidadPokemon.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("speed"));
		objetoPokemon.setCellValueFactory(new PropertyValueFactory<Pokemon, String>("nombreObjeto"));

	}

	// añade a la ObservableList todos los objetos que hay en la tienda
	public ObservableList<Obj> muestraTodoLosObjetos() {

		ObservableList<Obj> lista = FXCollections.observableArrayList();

		for (int i = 0; i < CargarTodosLosObjetos.getTodosLosObjetos().size(); i++) {

			if (CargarTodosLosObjetos.getTodosLosObjetos().get(i).getId() != 0) {

				Obj o = new Obj(CargarTodosLosObjetos.getTodosLosObjetos().get(i));

				lista.add(o);
			}

		}
		return lista;
	}

	public ObservableList<Obj> muestraMochila() {

		entrenador = CargarEntrenador.getEntrenador();

		LinkedList<Obj> objetos = entrenador.getObjetos();

		ObservableList<Obj> lista = FXCollections.observableArrayList();

		for (int i = 0; i < objetos.size(); i++) {

			Obj o = new Obj(objetos.get(i));
			lista.add(o);

//			Obj o = new Obj();
//			
//			o.setCantidad(objetos.get(i).getCantidad());
//			o.setName(objetos.get(i).getName());

		}
		return lista;
	}

	public ObservableList<Pokemon> metodo() {

		ObservableList<Pokemon> lista = FXCollections.observableArrayList();

		CargarEntrenador.comprobarUsuarioYCargarlo(entrenador.getName());

		entrenador = CargarEntrenador.getEntrenador();

		LinkedList<Pokemon> equipo = entrenador.getEquipoPokemon();

		for (int i = 0; i < equipo.size(); i++) {

			Pokemon p = equipo.get(i);

//			Pokemon p = new Pokemon(equipo.get(i));

			p.setNombreObjeto(p.getObject().getName());

//			System.out.println("este es el pokemon "+p.getObject());

			lista.add(p);

		}

		return lista;

	}
}
