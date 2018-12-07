package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * 
 * @author Andres Perez
 * @version 1.0
 * @see view.Controlador
 *
 */
public class Main extends Application {
	
	Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		
		stage = primaryStage;

		MainWindow();
		
	}
	/**
	 * Metodo que carga la pantalla prioncipal al iniciarse.
	 */
	private void MainWindow() {
		
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource(
					"view/Profile.fxml"));
			AnchorPane pane = loader.load();

			Scene scene = new Scene(pane);
	
			scene.getStylesheets().add(
					"https://fonts.googleapis.com/css?family=Poiret+One");
			scene.getStylesheets().add(
					"https://fonts.googleapis.com/css?family=Underdog");

			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
