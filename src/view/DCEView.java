package view;

import java.io.File;
import java.io.FileNotFoundException;

import controller.DCEController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.DCEModel;

public class DCEView extends Application {

	private DCEController controller = new DCEController();
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("DCEMonitor");
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid, 300, 300);
		TextArea text = new TextArea();
		text.setEditable(false);
		Button fileChooser = new Button("Choose File");
		fileChooser.setOnAction((event) -> {
			FileChooser fc = new FileChooser();
			File file = fc.showOpenDialog(null);
			if(!file.exists() || !file.getName().substring((int) (file.getName().length() - 3)).equals("txt")) {
				Alert fileNotFound = new Alert(AlertType.ERROR);
				fileNotFound.setContentText("Incorrect file type for a DCE report.");
				fileNotFound.show();
			} else {
				Alert fileRead = new Alert(AlertType.INFORMATION);
				fileRead.setContentText("One file read from: " + file.getAbsolutePath());
				fileRead.show();
				//text.appendText("One file read from: " + file.getAbsolutePath() + "\n\n");
				try {
					this.controller.readFile(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		Button highPdus = new Button("Check for High PDUs");
		highPdus.setOnAction((event) -> {
			text.appendText(this.controller.getHighReadings() + "\n");
		});
		
		Button allPdus = new Button("Highest Reading for All PDUs");
		allPdus.setOnAction((event) -> {
			text.appendText(this.controller.getAllReadings() + "\n");
		});
		
		HBox hboxTop = new HBox();
		hboxTop.setAlignment(Pos.CENTER);
		hboxTop.setPadding(new Insets(15));
		hboxTop.getChildren().addAll(fileChooser, highPdus, allPdus);
		
		HBox hboxBottom = new HBox();
		hboxBottom.setAlignment(Pos.CENTER);
		hboxBottom.setPadding(new Insets(10));
		HBox.setHgrow(text, Priority.ALWAYS);
		hboxBottom.getChildren().add(text);
		
		grid.add(hboxTop, 0, 0);
		grid.add(hboxBottom, 0, 1);
		stage.setScene(scene);
		stage.setWidth(500);
		stage.setHeight(500);
		stage.show();
		
	}
	
}