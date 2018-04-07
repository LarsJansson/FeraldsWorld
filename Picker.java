import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;


public class Picker{
    public void pickOption(JTextPane tp, String[] options, String[] hints, int p, String q) throws Exception{
        String oldText = tp.getText();
        String newText = q+"\n";
        for (int o = 0; o<options.length; o++){
            if (p == o){
                newText = newText.concat(">"+options[o]+" : " + hints[o] + "\n");
            }else{
                newText = newText.concat(" "+options[o]+" : " + hints[o] + "\n");
            }
        }
        tp.setText(""+newText);
    }
}




