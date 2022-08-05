package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {

	public void start(Stage stage) throws Exception {
		Label hello = new Label("42 kida\nyaaay");
		
		Scene scene = new Scene(hello);
		stage.setMinWidth(200);
		stage.setMaxHeight(400);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
