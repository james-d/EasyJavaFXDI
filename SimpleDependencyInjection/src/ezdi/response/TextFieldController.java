package ezdi.response;

import ezdi.model.Model;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TextFieldController {

	@FXML
	private TextField display ;
	
	private Model model ;
	
	@FXML
	private void initialize() {
		display.textProperty().bindBidirectional(model.textProperty());
	}
}
