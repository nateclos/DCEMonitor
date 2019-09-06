package view;

import java.io.File;
import java.io.FileNotFoundException;

import controller.DCEController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
				text.appendText("One file found at: " + file.getAbsolutePath() + "\n\n");
				try {
					this.controller.readFile(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
			}
		});
		HBox hbox = new HBox();
		hbox.getChildren().addAll(fileChooser);
		grid.add(hbox, 0, 0);
		grid.add(text, 0, 1);
		stage.setScene(scene);
		stage.show();
		//DCEModel model = new DCEModel("03-01-19-090000_CJ8jjM6P.txt");
		
	}
	
}