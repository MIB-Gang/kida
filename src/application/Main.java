package application;

import application.controller.MediaController;
import application.controller.PlayerController;
import application.stages.MainStage;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application{
	
	public void start(Stage stage) throws Exception {		
		
		PlayerController playerController = PlayerController.getInstance();
		MediaController mediaController = MediaController.getInstance();

		// TODO: Set currentPlaylist to saved playlist in file
		playerController.setCurrentPlaylist(mediaController.getAllSongs());
		
		MainStage mainStage = new MainStage();
		mainStage.show();
	}

	public static void main(String[] args) {		
		launch(args);
	}

}
	