import java.awt.event.*;
import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.awt.EventQueue;
import java.awt.HeadlessException;

public class EnterStroke implements ActionListener{
    private String str;
    private JTextField inputPanel;
    private final DataModel dataModel;
    
    
    public EnterStroke(JTextField inputPanel, DataModel model) throws HeadlessException{
        
        this.inputPanel = inputPanel;
        dataModel = model;
        dataModel.addPropertyChangeListener( new PropertyChangeListener() {
            @Override
            public void propertyChange( PropertyChangeEvent evt ) {
              updateUIFromModel();
            }
        } );
        str = dataModel.getInput();
        }

        private void updateUIFromModel(){
            inputPanel.setText(dataModel.getInput());
        }

    
        public void actionPerformed(ActionEvent e){
            str = inputPanel.getText();
            inputPanel.setText("");
            dataModel.setInput(str);
            dataModel.setEnterPressed(true);
        }
}
