package ua.kpi.crc;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CRCApplication extends Application {

	private Stage window;
	private Button button;
	private TextField inputField;
	private Label label;
	private final ToggleGroup group = new ToggleGroup();
	private RadioButton rb1;
	private RadioButton rb2;

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

		rb1 = new RadioButton("CRC16");
		rb1.setToggleGroup(group);
		rb1.setSelected(true);

		rb2 = new RadioButton("CRC32");
		rb2.setToggleGroup(group);

		label = new Label();

		inputField = new TextField();
		inputField.setPromptText("String data");
		inputField.setMinWidth(60);

		button = new Button("Calculate!");
		button.setOnAction(e -> {
			String result = radioSelect();
			setLabel("For message: " + inputField.getText() + ", CRC = " + result);
		});

		VBox lay = new VBox();
		lay.setPadding(new Insets(10, 10, 10, 10));
		lay.getChildren().addAll(rb1, rb2, inputField, button, label);
		lay.setAlignment(Pos.CENTER);
		Scene scene = new Scene(lay, 300, 150);
		window.setScene(scene);
		window.show();
	}

	private void windowClose() {
		boolean answer = ConfirmBox.display("Confirming dialog", "Are u sure to close this app?");
		if (answer)
			window.close();
	}

	private void setLabel(String text) {
		label.setText(text);
	}

	private String radioSelect() {
		if (rb1.isSelected()) {
			return CRCAlghoritm.crc16(inputField.getText());
		} else {
			return CRCAlghoritm.crc32(inputField.getText());
		}
	}

}
