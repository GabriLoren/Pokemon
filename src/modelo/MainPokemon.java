package modelo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class MainPokemon extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root=FXMLLoader.load(getClass().getResource("EscenaPrincipal.fxml"));
			
			Scene scene=new Scene(root);
			primaryStage.setTitle("hola");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);

		Trainer gabriel = CargarEntrenador.cargarEntrenador("1");

		Trainer alejandro = CargarEntrenador.cargarEntrenador("2");

		CargarPokemonEnEntrenador.cargarPokemonEnEntrenador(gabriel);

		CargarPokemonEnEntrenador.cargarPokemonEnEntrenador(alejandro);

		Battle batalla1 = new Battle(gabriel, alejandro);

		batalla1.trainer1VsTrainer2();

	}

}
