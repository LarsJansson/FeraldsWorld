import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class Inventory{

    public void Inventory(JTextPane tp){
        tp.setText("INVENTORY");
    }

    public void clearInventory(JTextPane tp){
        tp.setText("INVENTORY");
    }

    public void addItem(JTextPane tp, String s, Color c) throws Exception{
        StyledDocument doc = tp.getStyledDocument();
        AttributeSet set = doc.getCharacterElement(0).getAttributes();
        Style style = tp.addStyle("", null);
        StyleConstants.setForeground(style, c);
        tp.setCharacterAttributes(style, true);
        
        try {
            doc.insertString(doc.getLength(), "\n", style);
            doc.insertString(doc.getLength(), s, style);
            }
        catch (BadLocationException e){}
             
        
        //AttributeSet att = tp.getStyledDocument().getCharacterElement(0).getAttributes();
        //Style style = tp.addStyle("", null);
        //StyleConstants.setForeground(style, c);
        //tp.setCharacterAttributes(style, true);

        //tp.setText(tp.getText()+"\n");
        //String[] splitString = s.split("");
        //for (String character : splitString){

        //    tp.setText(tp.getText() + character);
        //}
        //StyledDocument doc = tp.getStyledDocument();

        //Style style = tp.addStyle("I'm a Style", null);
        //StyleConstants.setForeground(style, Color.red);

        //StyleConstants.setForeground(att, c);

        //try { doc.insertString(doc.getLength(), "BLAH ",style); }
        //catch (BadLocationException e){}
    }

}
