import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;

/**
 * This class holds all the UI components together
 * 
 * @author chouw
 *
 */
public class UI {

	private BorderPane pane = new BorderPane();
	private CanvasFrame canvas = new CanvasFrame();
	private Menu menu = new Menu();

	/**
	 * Creates the menu bar at the top Creates canvas where shape will go
	 */
	public void initUI(Setting s) {
		canvas.setMenu(s);
		
		//If backspace or delete clicked, activate delete() method to delete a shape
		pane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.DELETE || e.getCode() == KeyCode.BACK_SPACE) {
				canvas.delete();
			}
		});

		menu.init();
		menu.setMenu(s);

		pane.setCenter(canvas.getPane());
		pane.setTop(menu.getBox());
	}

	public BorderPane getPane() {
		return pane;
	}

}
