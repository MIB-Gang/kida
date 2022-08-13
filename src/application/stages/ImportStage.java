package application.stages;

import java.io.File;
import java.util.List;

import javax.swing.GroupLayout.Alignment;

import application.Song;
import application.controller.MediaController;
import application.controller.PlayerController;
import application.uiComponents.DefaultButton;
import application.uiComponents.DefaultTextField;
import application.uiComponents.Headline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ImportStage extends Stage {

	private MediaController mediaController = MediaController.getInstance();


	private BorderPane primaryPane = new BorderPane();
	private BorderPane secondaryPane = new BorderPane();

	private TableView<File> fileTable = new TableView<>();
	TableColumn<File, String> column;

	private VBox textFieldArea = new VBox();
	private HBox buttonArea = new HBox();

	Headline headline = new Headline("", "h3");
	DefaultTextField titleField = new DefaultTextField("Titel");
	DefaultTextField artistField = new DefaultTextField("Interpret");
	DefaultTextField albumField = new DefaultTextField("Album");
	DefaultTextField genreField = new DefaultTextField("Genre");
	DefaultButton saveEntryButton = new DefaultButton("Speichern");

	String selectedFilePath = "";

	public ImportStage(List<File> files) {

		column = new TableColumn<>("Dateien");
		column.setCellValueFactory(new PropertyValueFactory<>("path"));

		fileTable.setItems(FXCollections.observableArrayList(files));
		fileTable.getColumns().add(column);

		fileTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observableValue, Object oldValue, Object newValue) {
				if (fileTable.getSelectionModel().getSelectedItem() != null) {
					TableViewSelectionModel<File> selectionModel = fileTable.getSelectionModel();
					ObservableList<?> selectedCells = selectionModel.getSelectedCells();
					TablePosition<Object, ?> tablePosition = (TablePosition<Object, ?>) selectedCells.get(0);
					Object val = tablePosition.getTableColumn().getCellData(newValue);
					selectedFilePath = ((String) val).replace("\\", "/");
					String[] pathToName = selectedFilePath.split("/");
					headline.setText(pathToName[pathToName.length - 1].replace(".mp3", "").replace("-", " ").replace("_", " "));
				}
			}
		});

		saveEntryButton.setOnAction(event -> mediaController.addToAllSongs(new Song(titleField.getText(), artistField.getText(), albumField.getText(), genreField.getText(), false, selectedFilePath, "video")));

		textFieldArea.getChildren().addAll(titleField, new Rectangle(0, 12), artistField, new Rectangle(0, 12), albumField, new Rectangle(0, 12), genreField);
		buttonArea.getChildren().add(saveEntryButton);
		
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
		this.setMinHeight(450);
		
		saveEntryButton.setbackgroundColor("686868");

		secondaryPane.setMinWidth(300);
		secondaryPane.setMaxWidth(300);

		textFieldArea.setAlignment(Pos.CENTER);
		secondaryPane.setBackground(Background.fill(Color.rgb(19, 19, 19)));
		buttonArea.setAlignment(Pos.CENTER);
		secondaryPane.setPadding(new Insets(32));
		
		column.setStyle("-fx-text-fill: white;");
		fileTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		fileTable.setStyle("-fx-base: transparent; -fx-background-color: #292929; -fx-selection-bar: #686868; -fx-selection-bar-non-focused: #686868;");
	}

}
