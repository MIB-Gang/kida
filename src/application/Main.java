package application;

import application.screens.Scaffold;
import application.screens.ScreenHome;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
	
	public void start(Stage stage) throws Exception {		
		stage.getIcons().add(new Image("/kida_icon.png"));
		stage.setTitle("kiɗa");
		stage.setMinWidth(1000);
		stage.setMinHeight(700);
		
		stage.setScene(new Scene(new Scaffold(new ScreenHome())));		
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
