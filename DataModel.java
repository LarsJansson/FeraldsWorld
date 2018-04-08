import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class DataModel{
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport( this );

    private String input = "";
    private boolean enterPressed=false;
    private int fontSize = 14;

    public void addPropertyChangeListener( PropertyChangeListener listener ) {
      propertyChangeSupport.addPropertyChangeListener( listener );
    }

    public String getInput() {
      return input;
    }

    public boolean getEnterPressed() {
        return enterPressed;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int newFontSize){
        int oldFontSize = fontSize;
        fontSize = newFontSize;
        propertyChangeSupport.firePropertyChange( "enterPressed", fontSize, newFontSize );
    }

    public void setEnterPressed(boolean newValue){
        boolean oldValue = enterPressed;
        enterPressed = newValue;
        propertyChangeSupport.firePropertyChange( "enterPressed", enterPressed, newValue );
    }

    public void setInput( String input2 ) {
        String old = input;
        input = input2;
        propertyChangeSupport.firePropertyChange( "input", input, input2 );
    }
}
