import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class Stats{

    private SimpleAttributeSet att;

    public void Format(){
        StyleConstants.setAlignment(att, StyleConstants.ALIGN_RIGHT);
        StyleConstants.setForeground(att, Color.WHITE);
        StyleConstants.setBackground(att, Color.BLACK);
        StyleConstants.setFontSize(att, 14);
        StyleConstants.setBold(att, false);
        StyleConstants.setFontFamily(att, "Courier New");
    }

    public Stats(JTextPane tp){
        att = new SimpleAttributeSet();
        Format();
        tp.setEditable(false);
        tp.setCharacterAttributes(att, true);
        tp.setParagraphAttributes(att, true);
        tp.setText("STATS");
    }

    public void clear(JTextPane tp){
        tp.setText("STATS");
    }

    public void updateStats(JTextPane tp, Hero hero) throws Exception{
        tp.setText("");
        StyledDocument doc = tp.getStyledDocument();
        AttributeSet set = doc.getCharacterElement(1).getAttributes();
        Style style1 = tp.addStyle("", null);
        Style style2 = tp.addStyle("", null);
        StyleConstants.setForeground(style1, Color.darkGray);
        StyleConstants.setForeground(style2, Color.RED);
        
        try {
            doc.insertString(doc.getLength(), "\n", style1);
            doc.insertString(doc.getLength(), "Name: ", style1);
            doc.insertString(doc.getLength(), hero.getName()+"\t", style2);
            doc.insertString(doc.getLength(), "Race : ", style1);
            doc.insertString(doc.getLength(), hero.getRace()+"\t", style2);
            doc.insertString(doc.getLength(), "Gender : ", style1);
            doc.insertString(doc.getLength(), hero.getGender()+"\t", style2);
            doc.insertString(doc.getLength(), "XP :", style1);
            doc.insertString(doc.getLength(), Integer.toString(hero.getXp()), style2);

            }
        catch (BadLocationException e){}
    }
}
