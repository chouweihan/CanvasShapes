import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

/**
 * This class creates a pane which holds My own shapes objects, each shape objects would contain a javafx shape.
 * @author chouw
 *
 */
public class PaneShape extends Pane {
	
	private Shape shape;
	private Shapes shapes;
	
	/** adds the shape to the pane */
	public PaneShape(Shapes s) {
		shapes = s;
		shape = shapes.getShape();
		this.getChildren().add(shape);
	}
	
	
	public Pane getPane() {
		return this;
	}
	
	/** returns javafx shape*/
	public Shape getBlock() {
		return shape;
	}
	
	/** returns my shape */
	public Shapes getShapes() {
		return shapes;
	}
}
