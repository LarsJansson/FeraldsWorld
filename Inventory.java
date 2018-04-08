import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class Inventory{

    private SimpleAttributeSet att;

    public void Format(){
        StyleConstants.setAlignment(att, StyleConstants.ALIGN_RIGHT);
        StyleConstants.setForeground(att, Color.WHITE);
        StyleConstants.setBackground(att, Color.BLACK);
        StyleConstants.setFontSize(att, 14);
        StyleConstants.setBold(att, false);
        StyleConstants.setFontFamily(att, "Courier New");
    }

    public Inventory(JTextPane tp){
        att = new SimpleAttributeSet();
        Format();
        tp.setEditable(false);
        tp.setCharacterAttributes(att, true);
        tp.setParagraphAttributes(att, true);
        tp.setText("INVENTORY");
    }

    public void clear(JTextPane tp){
        tp.setText("INVENTORY");
    }

    public void add(JTextPane tp, String s) throws Exception{
        StyledDocument doc = tp.getStyledDocument();
        Style style = tp.addStyle("", null);
        StyleConstants.setForeground(style, Color.WHITE);
        
        try {
            doc.insertString(doc.getLength(), "\n", style);
            doc.insertString(doc.getLength(), s, style);
            }
        catch (BadLocationException e){}
    }

    public boolean search(JTextPane tp, String s) throws Exception{
        StyledDocument doc = tp.getStyledDocument();
        String inv = doc.getText(0, doc.getLength());
        return inv.contains(s);
    }

   public void addItem(JTextPane tp, String s, Color c) throws Exception{
        StyledDocument doc = tp.getStyledDocument();
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
