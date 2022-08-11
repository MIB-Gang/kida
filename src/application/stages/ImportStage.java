package application.stages;

import java.io.File;
import java.util.List;

import javax.swing.GroupLayout.Alignment;

import application.Song;
import application.controller.MediaController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImportStage extends Stage {
	
	private MediaController controller = MediaController.getInstance();

	private BorderPane primaryPane = new BorderPane();
	private BorderPane secondaryPane = new BorderPane();

	private TableView<File> fileTable = new TableView<>();
	TableColumn<File, String> column;

	private VBox textFieldArea = new VBox();
	private HBox buttonArea = new HBox();

	Label headline = new Label();
	TextField titleField = new TextField("Titel");
	TextField artistField = new TextField("Interpret");
	TextField albumField = new TextField("Album");
	TextField genreField = new TextField("Genre");
	Button saveEntryButton = new Button("Speichern");
	Button nextEntryButton = new Button("Nächster");
	Button previousEntryButton = new Button("Vorherige");
	
	String selectedFilePath = "";

	public ImportStage(List<File> files) {

		column = new TableColumn<>("Dateien");
		column.setCellValueFactory(new PropertyValueFactory<>("path"));

		fileTable.setItems(FXCollections.observableArrayList(files));
		fileTable.getColumns().add(column);
		fileTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		
		fileTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observableValue, Object oldValue, Object newValue) {
				if (fileTable.getSelectionModel().getSelectedItem() != null) {
					TableViewSelectionModel<File> selectionModel = fileTable.getSelectionModel();
					ObservableList<?> selectedCells = selectionModel.getSelectedCells();
					TablePosition<Object, ?> tablePosition = (TablePosition<Object, ?>) selectedCells.get(0);
					Object val = tablePosition.getTableColumn().getCellData(newValue);
					selectedFilePath = (String) val;
					headline.setText((String) val);
				}
			}
		});
		
		saveEntryButton.setOnAction(new EventHandler<ActionEvent>() {
	        @Override public void handle(ActionEvent e) {
	            controller.addToAllSongs(new Song(
	            		titleField.getText(), 
	            		artistField.getText(), 
	            		albumField.getText(), 
	            		genreField.getText(), 
	            		false, 
	            		selectedFilePath, 
	            		"video"
	            ));
	        }
	    });

		textFieldArea.getChildren().addAll(titleField, artistField, albumField, genreField, saveEntryButton);
		buttonArea.getChildren().addAll(previousEntryButton, nextEntryButton);

		secondaryPane.setTop(headline);
		secondaryPane.setCenter(textFieldArea);
		secondaryPane.setBottom(buttonArea);

		primaryPane.setCenter(fileTable);
		primaryPane.setRight(secondaryPane);

		this.setScene(new Scene(primaryPane));
		this.show();

		applyStyle();
	}

	private void applyStyle() {
		this.getIcons().add(new Image("/kida_icon.png"));
		this.setTitle("Füge Songdaten hinzu");
		this.setMinWidth(640);
		this.setMinHeight(420);
		
		column.setMinWidth(458);
		secondaryPane.setMaxWidth(148);

		textFieldArea.setAlignment(Pos.CENTER);
		buttonArea.setAlignment(Pos.CENTER);

		fileTable.setBackground(Background.fill(Color.rgb(19, 19, 19)));
	}

}
