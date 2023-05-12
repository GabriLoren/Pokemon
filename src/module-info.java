module Pokemon {
	exports crud;
	exports jUnit;
	exports controlador;
	exports modelo;
	exports funcionalidades;

	requires java.sql;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.media;
	requires org.junit.jupiter.api;
	

	opens controlador to javafx.graphics, javafx.fxml, javafx.controls;
}