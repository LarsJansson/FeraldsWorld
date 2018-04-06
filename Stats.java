import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class Stats{

    public void Stats(JTextPane tp){
        tp.setText("STATS");
    }

    public void clear(JTextPane tp){
        tp.setText("STATS");
    }

    public void updateStats(JTextPane tp, Hero hero) throws Exception{
        StyledDocument doc = tp.getStyledDocument();
        AttributeSet set = doc.getCharacterElement(1).getAttributes();
        Style style = tp.addStyle("", null);
        StyleConstants.setForeground(style, Color.WHITE);
        tp.setCharacterAttributes(style, true);
        
        try {
            doc.insertString(doc.getLength(), "\n", style);
            doc.insertString(doc.getLength(),
                    "Name: " + hero.getName() + "\t" + "Race: " + hero.getRace() + "\t" +  "Gender: " + hero.getGender(), style);
            }
        catch (BadLocationException e){}
    }
}
