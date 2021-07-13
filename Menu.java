import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Menu {
	
	/** Sets of radio button to select shape type*/
	private final ToggleGroup shapeGroup = new ToggleGroup();
	private RadioButton rb1 = new RadioButton("Square"); 
	private RadioButton rb2 = new RadioButton("Rectangle"); 
	private RadioButton rb3 = new RadioButton("Oval"); 
	private RadioButton rb4 = new RadioButton("Circle"); 
	
	/** Sets of radio button to select action type */
	private final ToggleGroup selectGroup = new ToggleGroup();
	private RadioButton rb5 = new RadioButton("Draw");
	private RadioButton rb6 = new RadioButton("Select");
	
	/** pick color */
	private ColorPicker colorPicker = new ColorPicker(Color.BLACK);
	private Setting setting;
	private HBox box;
	
	
	public void init() {
		box = new HBox(50, rb1, rb2, rb3, rb4, colorPicker, rb5, rb6);
		box.setStyle("-fx-background-color: #ffffff");
		
		rb1.setToggleGroup(shapeGroup);
		rb1.setUserData("Square");
		rb1.setSelected(true);
		
		rb2.setToggleGroup(shapeGroup);
		rb2.setUserData("Rectangle");
		
		rb3.setToggleGroup(shapeGroup);
		rb3.setUserData("Oval");
		
		rb4.setToggleGroup(shapeGroup);
		rb4.setUserData("Circle");
		
		rb5.setToggleGroup(selectGroup);
		rb5.setUserData("draw");
		rb5.setSelected(true);
		
		rb6.setToggleGroup(selectGroup);
		rb6.setUserData("select");
		
		// Adds event listener for shape group
		shapeGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
		      public void changed(ObservableValue<? extends Toggle> ov,
		          Toggle old_toggle, Toggle new_toggle) {
		        if (shapeGroup.getSelectedToggle() != null) {
		          setting.setType(shapeGroup.getSelectedToggle().getUserData().toString());
		        }	
		      }
		    });
		
		// Event listener for action group 
		selectGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
		      public void changed(ObservableValue<? extends Toggle> ov,
		          Toggle old_toggle, Toggle new_toggle) {
		        if (selectGroup.getSelectedToggle() != null) {
		          setting.setDraw(selectGroup.getSelectedToggle().getUserData().toString());
		        }	
		      }
		    });
	}
	
	/** Returns the menu ui */
	public HBox getBox() {
		return box;
	}
	
	/** Adds setting to menu, so that it can be manipulated 
	    Sets up color in settings */
	public void setMenu(Setting s) {
		setting = s;
		s.setColor(colorPicker);
	}
}
