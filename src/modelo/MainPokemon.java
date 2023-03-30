package modelo;

import java.util.Objects;

import cargar.CargarPokemon;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class MainPokemon extends Application {
	@Override
	public void start(Stage primaryStage) {
	
			try {
				Parent root=FXMLLoader.load(getClass().getResource("/vista/Captura.fxml"));
//				hace lo mismo que la sentencia anterior
//				Parent root=new FXMLLoader(getClass().getResource("/vista/EscenaPrincipal.fxml")).load();
				Scene scene= new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		
		}



	public static void main(String[] args) {
		
		launch(args);



	}

}


