package view;

import java.io.File;

import controller.DCEController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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

	private int presses = 0;
	private DCEController controller = new DCEController();
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("DCE Monitoring Tool");
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid, 300, 300);
		Button b = new Button("Press me");
		TextArea text = new TextArea();
		b.setOnAction((event) -> {
			text.appendText("Button has been pressed " + (++presses) + " times!\n");
		});
		text.setEditable(false);
		Button fileChooser = new Button("Choose File");
		fileChooser.setOnAction((event) -> {
			FileChooser fc = new FileChooser();
			File file = fc.showOpenDialog(null);
			text.appendText("One file found at: " + file.getAbsolutePath() + '\n');
		});
		HBox hbox = new HBox();
		hbox.getChildren().addAll(b, fileChooser);
		grid.add(hbox, 0, 0);
		grid.add(text, 0, 1);
		stage.setScene(scene);
		stage.show();
		//DCEModel model = new DCEModel("03-01-19-090000_CJ8jjM6P.txt");
		
	}
	
}