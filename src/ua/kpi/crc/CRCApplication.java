package ua.kpi.crc;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CRCApplication extends Application {

	private Stage window;
	private Button button;
	private TextField inputField;
	private Label label;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("CRC Calculator");
		window.setOnCloseRequest(e -> {
			e.consume();
			windowClose();
		});

		label = new Label();

		inputField = new TextField();
		inputField.setPromptText("Hex value");
		inputField.setMinWidth(60);

		button = new Button("Calculate");
		button.setOnAction(e -> {

		});

		VBox lay = new VBox();
		lay.getChildren().addAll(inputField, button, label);
		lay.setAlignment(Pos.CENTER);
		Scene scene = new Scene(lay, 200, 150);
		window.setScene(scene);
		window.show();
	}

	private void windowClose() {
		boolean answer = ConfirmBox.display("Confirming dialog", "Are u sure to close this app?");
		if (answer)
			window.close();
	}
	
	public void setLabel(String text){
		label.setText(text);
	}

}
