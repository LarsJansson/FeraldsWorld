import java.awt.event.*;
import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.awt.EventQueue;
import java.awt.HeadlessException;

public class ArrowKeys implements KeyListener{
    private int pos;
    private JTextField inputPanel;
    private final DataModel dataModel;


    public ArrowKeys(JTextField inputPanel, DataModel model) throws HeadlessException{

        this.inputPanel = inputPanel;
        dataModel = model;
        dataModel.addPropertyChangeListener( new PropertyChangeListener() {
            @Override
            public void propertyChange( PropertyChangeEvent evt ) {
                updateUIFromModel();
            }
        } );
        dataModel.setPosition(0);
    }

    private void updateUIFromModel(){
        //inputPanel.setText(dataModel.getInput());
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){}
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){}
        else if(e.getKeyCode() == KeyEvent.VK_UP){
            dataModel.changePosition(-1);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            dataModel.changePosition(1);
        }
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}

    //public void actionPerformed(ActionEvent e){
    //    str = inputPanel.getText();
    //    inputPanel.setText("");
    //    dataModel.setInput(str);
    //    dataModel.setEnterPressed(true);
    //}
}
