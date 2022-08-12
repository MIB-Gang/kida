package application;

import java.io.File;
import java.util.List;

import application.controller.MediaController;
import application.controller.PlayerController;
import application.stages.ImportStage;
import application.stages.MainStage;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	
	public void start(Stage stage) throws Exception {		
		
		PlayerController playerController = PlayerController.getInstance();
		MediaController mediaController = MediaController.getInstance();

		playerController.setCurrentPlaylist(mediaController.getAllSongs());
		
		MainStage mainStage = new MainStage();
		mainStage.show();
		
//		ImportStage importStage = new ImportStage(List.of(new File("C:/Users/" + System.getProperty("user.name") + "/Music/Get-Through_NEFFEX.mp3"), new File("C:/Users/" + System.getProperty("user.name") + "/Music/Hush-Little-Baby_The-Green-Orbs.mp3"), new File("C:/Users/" + System.getProperty("user.name") + "/Music/Positive-Fuse_French-Fuse.mp3")			));
//		importStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
	