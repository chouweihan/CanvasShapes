import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public abstract class Shapes {
	/** The point where the shape will rubber band around */
	protected Point2D src;
	protected Color color = Color.BLACK;
	
	/** Sets source point of shape */
	public void setPoint2D(Point2D point) {
		src = point;
	}
	
	public void setColor(Color c) {
		color = c;
	}
	/** Returns shape */
	public abstract Shape getShape();
	/** Sets initial shape x,y coordinate */
	public abstract void setShapes();
	/** Changes shape size */
	public abstract void changeShape(Point2D point);
	/** Moves the shape when selected */
	public abstract void moveShape(Point2D point);
	
}
