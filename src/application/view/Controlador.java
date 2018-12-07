package application.view;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controlador {

	@FXML
	ImageView imagen;
	
	@FXML
	Pane  panelLogin;
	
	@FXML
	Label lblBienvenido;
	
	@FXML	
	ImageView menuImagen;
	
	@FXML
	AnchorPane panelMenu;
	
	@FXML
	AnchorPane panelPrincipal1, panelPrincipal;
	
	int controlador = 0;
	/**
	 * Metodo que se inicializa a la vez que la aplicacion
	 */
	public void initialize() {
		FadeTransition fadeTransition = new FadeTransition(
				Duration.seconds(5), imagen);
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1);
		fadeTransition.play();
		
		TranslateTransition translateTransition = new TranslateTransition(
				Duration.seconds(0.1), lblBienvenido);
		translateTransition.setByY(+700);
		translateTransition.play();
		
		TranslateTransition translateTransition3 = new TranslateTransition(
				Duration.seconds(0.1), menuImagen);
		translateTransition3.setByX(+700);
		translateTransition3.play();
		
		TranslateTransition translateTransition5 = new TranslateTransition(
				Duration.seconds(0.1), panelMenu);
		translateTransition5.setByX(+700);
		translateTransition5.play();
		
		
		
		
	}
	
	/**
	 * Metodo que abre una nueva ventana.
	 */
	public void nuevaVentana() {
		
		
		Stage stage2 = new Stage();
		
		AnchorPane mypane = new AnchorPane();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaNuevaBoton.fxml"));
		
		try {
			mypane = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		stage2.setResizable(false);
		stage2.setTitle("Bienvenido Andres P.");
		stage2.setScene(new Scene(mypane));
		stage2.show();

		Stage thisStage = (Stage) panelPrincipal1.getScene().getWindow();
	    thisStage.close();

		
	}
	/**
	 * Metodo que al pulsar un boton hace desaparecer y aparecer ciertos elementos
	 */
	public void botonEntrar() {
		
		FadeTransition fadeTransition = new FadeTransition(
				Duration.seconds(5), panelLogin);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();
		
		fadeTransition.setOnFinished(event -> {
			
			TranslateTransition translateTransition = new TranslateTransition(
					Duration.seconds(0.1), lblBienvenido);
			translateTransition.setByY(-700);
			translateTransition.play();
			
			TranslateTransition translateTransition3 = new TranslateTransition(
					Duration.seconds(0.1), menuImagen);
			translateTransition3.setByX(-700);
			translateTransition3.play();
			
			
		});
				
	}
	/**
	 * Metodo que hace aparecer y desaparecer el menu.
	 */
	public void menuAparece() {
		if (controlador == 0) {
			 TranslateTransition translateTransition6 = new TranslateTransition(
						Duration.seconds(0.5), panelMenu);
				translateTransition6.setByX(-700);
				translateTransition6.play();
				controlador = 1;
		}else {
			TranslateTransition translateTransition5 = new TranslateTransition(
					Duration.seconds(0.5), panelMenu);
			translateTransition5.setByX(+700);
			translateTransition5.play();
			controlador = 0;
		}
	}
	
	public void salir() {
		Stage thisStage = (Stage) panelPrincipal.getScene().getWindow();
	    thisStage.close();
		
	}
	
}
