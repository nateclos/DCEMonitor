package view;

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
import javafx.stage.Stage;

public class DCEView extends Application {

	private int presses = 0;
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setTitle("DCE Monitoring Tool");
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid, 300, 300);
		Button b = new Button("Press me");
		TextArea text = new TextArea();
		b.setOnAction((event) -> {
			text.appendText("Button has been pressed " + (++presses) + " times!\n");
		});
		text.setEditable(false);
		HBox hbox = new HBox();
		hbox.getChildren().add(b);
		grid.add(hbox, 0, 0);
		grid.add(text, 0, 1);
		stage.setScene(scene);
		stage.show();
	}
	
}