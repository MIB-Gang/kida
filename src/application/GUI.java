package application;

import application.scenes.MainScene;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GUI extends Application {

	public void start(Stage stage) throws Exception {		
		Image icon = new Image("kida_icon.png");
		stage.getIcons().add(icon);

		stage.setMinWidth(1000);
		stage.setMinHeight(700);
		stage.setScene(new MainScene(stage));
				
		stage.show();
	}

	public static void open() {
		launch();
	}

}
