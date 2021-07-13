import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Squares extends Shapes {

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
			r.setHeight(point.getX() - src.getX());
		} 
		
		if((point.getX() - src.getX() < 0) && (point.getY() - src.getY() > 0)) {
			r.setX(point.getX());
			r.setY(src.getY());
			r.setWidth(src.getX() - point.getX());
			r.setHeight(src.getX() - point.getX());
		} 
		
		if((point.getX() - src.getX() > 0) && (point.getY() - src.getY() < 0)) {
			r.setX(src.getX());
			r.setY(src.getY() - r.getHeight());
			r.setWidth(point.getX() - src.getX());
			r.setHeight(point.getX() - src.getX());
		} 
		
		if((point.getX() - src.getX() < 0) && (point.getY() - src.getY() < 0)) {
			r.setX(point.getX());
			r.setY(src.getY() - r.getHeight());
			r.setWidth(src.getX() - point.getX());
			r.setHeight(src.getX() - point.getX());
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
