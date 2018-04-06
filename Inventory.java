import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class Inventory{

    public void Inventory(JTextPane tp){
        tp.setText("INVENTORY");
    }

    public void clear(JTextPane tp){
        tp.setText("INVENTORY");
    }

    public void addItem(JTextPane tp, String s) throws Exception{
        StyledDocument doc = tp.getStyledDocument();
        AttributeSet set = doc.getCharacterElement(1).getAttributes();
        Style style = tp.addStyle("", null);
        StyleConstants.setForeground(style, Color.WHITE);
        tp.setCharacterAttributes(style, true);
        
        try {
            doc.insertString(doc.getLength(), "\n", style);
            doc.insertString(doc.getLength(), s, style);
            }
        catch (BadLocationException e){}
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
    }

}
