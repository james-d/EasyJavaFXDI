package ezdi.input;

import ezdi.model.Model;
import javafx.fxml.FXML;

public class ButtonController {

	private Model model ;
	
	@FXML
	private void handleButton() {
		model.setText("Hello");
	}
}
