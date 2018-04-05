import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.*;

public class Inventory{

    public void Inventory(JTextPane tp){
        tp.setText("INVENTORY");
    }

    public void clearInventory(JTextPane tp){
        tp.setText("INVENTORY");
    }

    public void addItem(JTextPane tp, String s) throws Exception{
        String item = s.concat("\n"+s);
        String[] splitString = s.split("");
        for (String character : splitString){
            tp.setText(tp.getText() + character);
        }
    }

}
