import javafx.geometry.Point2D;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

public class Ovals extends Shapes{
	Ellipse r = new Ellipse();
	
	public void setShapes() {
		r.setCenterX(src.getX());
		r.setCenterY(src.getY());
		r.setFill(color);
	}
	
	public void changeShape(Point2D point) {
		double radiusX = point.getX() - src.getX();
		double radiusY = point.getY() - src.getY();
		
		if(radiusX > 0 && radiusY > 0) {
			r.setRadiusX(radiusX);
			r.setRadiusY(radiusY);
		}
		
		if(radiusX < 0 && radiusY > 0) {
			r.setCenterX(src.getX());
			r.setRadiusX(Math.abs(radiusX));
			r.setRadiusY(radiusY);
		}
		
		if(radiusX < 0 && radiusY < 0) {
			r.setCenterX(src.getX());
			r.setCenterY(src.getY());
			r.setRadiusX(Math.abs(radiusX));
			r.setRadiusY(Math.abs(radiusY));
		}
		
		
		if(radiusX > 0 && radiusY < 0) {
			r.setCenterY(src.getY());
			r.setRadiusX(radiusX);
			r.setRadiusY(Math.abs(radiusY));
		}
		
	}

	public void moveShape(Point2D point) {
		r.setCenterX(point.getX());
		r.setCenterY(point.getY());
	}
	
	
	public Shape getShape() {
		return r;
	}
	

}