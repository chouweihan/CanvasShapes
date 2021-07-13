import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 * Settings for the program
 * @author chouw
 */
public class Setting {
	
	private String shape = "Square";
	private ColorPicker color;
	private boolean draw = true;

	
	/**
	 * Sets the current shape to draw
	 */
	public void setType(String s) {
		shape = s;
	}
	
	public String getType() {
		return shape;
	}
	
	/**
	 * Sets the color to use
	 */
	public void setColor(ColorPicker c) {
		color = c;
	}
	
	/**
	 * Sets whether program draws or selects shapes
	 */
	public void setDraw(String s) {
		if(s.equals("draw"))
			draw = true;
		else
			draw = false;
	}
	
	/** Returns the color value */
	public Color getColor() {
		return color.getValue();
	}
	
	public boolean getDraw() {
		return draw;
	}
}
