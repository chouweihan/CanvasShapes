import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	private Setting setting;
	private UI ui;
	private Scene scene;
		
	@Override
	public void start(Stage primaryStage) throws Exception {
		setting = new Setting();
		
		
		ui = new UI();
		//sets up UI and Setting
		ui.initUI(setting);
		
		scene = new Scene(ui.getPane(), 1000, 800, Color.BLACK);
		
		primaryStage.setTitle("Paint");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
