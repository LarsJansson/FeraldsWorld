import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.*;

public class Inventory{

    private SimpleAttributeSet att;
    private String Inventory;
    private ArrayList<Item> items;

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
        Inventory = tp.getText();
        items = new ArrayList<Item>();
    }

    public void clear(JTextPane tp){
        tp.setText("INVENTORY");
        Inventory = tp.getText();
        int length = items.size();
        for(int j = 0; j<length; j++){
            items.remove(0);
        }
            
    }

    public void add(JTextPane tp, Item i) throws Exception{
        StyledDocument doc = tp.getStyledDocument();
        Style style = tp.addStyle("", null);
        StyleConstants.setForeground(style, Color.WHITE);
        try {
            doc.insertString(doc.getLength(), "\n", style);
            doc.insertString(doc.getLength(), i.getName(), style);
            }
        catch (BadLocationException e){}
        Inventory = tp.getText();
        items.add(i);
    }

    public boolean search(JTextPane tp, String s) throws Exception{
        StyledDocument doc = tp.getStyledDocument();
        String inv = doc.getText(0, doc.getLength());
        return inv.toLowerCase().contains(s.toLowerCase());
    }

    public void update(JTextPane tp){
        tp.setText("Inventory");
        StyledDocument doc = tp.getStyledDocument();
        Style style = tp.addStyle("", null);
        StyleConstants.setForeground(style, Color.WHITE);
        try {
            for(Item i : items){
                doc.insertString(doc.getLength(), "\n", style);
                doc.insertString(doc.getLength(), i.getName(), style);
            }
        }
        catch (BadLocationException e){}
        Inventory = tp.getText();
    }
}
