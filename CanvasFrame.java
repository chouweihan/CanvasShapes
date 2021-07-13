import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.util.List;
import java.util.ArrayList;
import javafx.geometry.Point2D;

public class CanvasFrame {
	
	/**The pane to hold all pane */
	private Pane pane = new Pane();
	/** List to hold the panes that hold shapes */
	private List<PaneShape> paneList = new ArrayList<PaneShape>();
	private Setting setting;
	/** Point of click */
	private Point2D click;
	/** Points when dragging */
	private Point2D drag;
	/** Current shape being added */
	private Shapes shape = null;
	/** Current Pane selected */
	private PaneShape curPane = null;
	/** index of current Pane */
	private int curIndex = 0;
	
	/** Sets event handlers */
	public CanvasFrame() {
		pane.setOnMousePressed(this::MousePress);
		pane.setOnMouseDragged(this::MouseDrag);
	}

	public Pane getPane() {
		return pane;
	}
	
	public void setMenu(Setting s) {
		setting = s;
	}
	
	/** Mouse pressed */
	private void MousePress(MouseEvent event) {
		click = new Point2D(event.getX(), event.getY());
		
		if (setting.getDraw()) {
			addShape();
		} else if (!setting.getDraw()) {
			selectShape();
		}
		
	}

	/** Adds shape by creating a temp Pane, adding a shape to it and adding it to paneList */
	private void addShape() {
		curPane = null;
		if (setting.getType().equals("Circle")) {
			shape = new Circles();
		} else if (setting.getType().equals("Oval")) {
			shape = new Ovals();
		} else if (setting.getType().equals("Rectangle")) {
			shape = new Rectangles();
		} else if (setting.getType().equals("Square")) {
			shape = new Squares();
		}

		shape.setPoint2D(click);
		shape.setColor(setting.getColor());
		shape.setShapes();
		PaneShape p = new PaneShape(shape);
		paneList.add(p);
		pane.getChildren().add(p);
	}
	
	/** Iterate through List to find out which pane is on top, and selects it
	  if it is where the mouse is */
	private void selectShape() {
		for(int i = paneList.size() - 1; i >= 0; i--) {
			if(paneList.get(i).getBlock().contains(click)) {
				curPane = paneList.get(i);
				curIndex = i;
				break;
			}
		}
	}
	
	
	
	
	
	/** Mouse dragging
	 * Resizes the shape if in draw mode
	 * Moves shape if in select mode
	 */
	private void MouseDrag(MouseEvent event2) {
		drag = new Point2D(event2.getX(), event2.getY());
		if (setting.getDraw()) {
			shape.changeShape(drag);
		} else if (!setting.getDraw()){
			moveShape();
		}
	}
	
	/** Moves the selected shape */
	private void moveShape() {
		if(curPane != null) {
			curPane.getShapes().moveShape(drag);
		}
	}
	
	/** Deletes the selected shape */
	public void delete() {
		if(!setting.getDraw() && curPane != null) {
			pane.getChildren().remove(curPane);
			paneList.remove(curIndex);
		}
	}
}
