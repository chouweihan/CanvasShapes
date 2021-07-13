import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Rectangles extends Shapes {

	Rectangle r = new Rectangle();
	
	public void setShapes() {
		r.setX(src.getX());
		r.setY(src.getY());
		r.setFill(color);
	}
	
	public void changeShape(Point2D point) {
		
		if((point.getX() - src.getX() > 0) && (point.getY() - src.getY() > 0)) {
			r.setX(src.getX());
			r.setY(src.getY());
			r.setWidth(point.getX() - src.getX());
			r.setHeight(point.getY() - src.getY());
		} 
		
		if((point.getX() - src.getX() < 0) && (point.getY() - src.getY() > 0)) {
			r.setX(point.getX());
			r.setY(src.getY());
			r.setWidth(src.getX() - point.getX());
			r.setHeight(point.getY() - src.getY());
		} 
		
		if((point.getX() - src.getX() > 0) && (point.getY() - src.getY() < 0)) {
			r.setX(src.getX());
			r.setY(point.getY());
			r.setWidth(point.getX() - src.getX());
			r.setHeight(src.getY() - point.getY());
		} 
		
		if((point.getX() - src.getX() < 0) && (point.getY() - src.getY() < 0)) {
			r.setX(point.getX());
			r.setY(point.getY());
			r.setWidth(src.getX() - point.getX());
			r.setHeight(src.getY() - point.getY());
		} 
		
	}
	
	public void moveShape(Point2D point) {
		r.setX(point.getX() - (r.getWidth()/2));
		r.setY(point.getY() - (r.getHeight()/2));
	}
	
	
	public Shape getShape() {
		return r;
	}

}
