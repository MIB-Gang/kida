package application.controller;

import java.io.File;
import java.util.List;

import application.scenes.Scaffold;
import application.stages.ImportStage;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SceneController {
	
	private static SceneController sceneController = new SceneController();	
	
	private Stage importStage;
	private Scene scene;

	public static SceneController getInstance() {
		return sceneController;
	}
	
	
	public void changeBody(ActionEvent e, Node body) {			//EVENT WEG?
		Scaffold scaffold = Scaffold.getInstance();
		scaffold.setBody(body);
	}
		
	public List<File> openFileChooser(ActionEvent event) {
		FileChooser chooser = new FileChooser();
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		chooser.setTitle("Wähle Songs zum Importieren aus");
		chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("kida-Dateien", "*.mp3"));
		chooser.setInitialDirectory(new File("C:/Users/" + System.getProperty("user.name") + "/Music"));
		List<File> files = chooser.showOpenMultipleDialog(stage);
		return files;
	}
	
	public void openImportWindow(List<File> files) {
		importStage = new ImportStage(files);	
		importStage.show();
	}

}
