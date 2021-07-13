import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Circles extends Shapes {

	Circle r = new Circle();
	
	public void setShapes() {
		r.setCenterX(src.getX());
		r.setCenterY(src.getY());
		r.setFill(color);
	}
	
	public void changeShape(Point2D point) {
		double distance = point.distance(src.getX(), src.getY());
		
		r.setRadius(distance);
	}

	public void moveShape(Point2D point) {
		r.setCenterX(point.getX());
		r.setCenterY(point.getY());
	}
	
	public Shape getShape() {
		return r;
	}
	
	

}
