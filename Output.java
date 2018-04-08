import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;

public class Output{

    private SimpleAttributeSet att;

    public void Format(){
        StyleConstants.setAlignment(att, StyleConstants.ALIGN_LEFT);
        StyleConstants.setForeground(att, Color.WHITE);
        StyleConstants.setBackground(att, Color.BLACK);
        StyleConstants.setFontSize(att, 14);
        StyleConstants.setFontFamily(att, "Courier New");
    }

    public void clearGUI(JTextPane tp){
        tp.setText("");
    }
    
    public void output(JTextPane tp, String s, double bd, double ad, boolean remove) throws Exception{
        String oldText = "";
        if (remove){
            oldText = "";
        }else{
            oldText = tp.getText();
        }
        TimeUnit.MILLISECONDS.sleep((long) bd);
        tp.setText(oldText + s);
        TimeUnit.MILLISECONDS.sleep((long) ad);
    }

    public void outputColor(JTextPane tp, String s, double bd, double ad, boolean remove, Color c) throws Exception{
        StyledDocument doc = tp.getStyledDocument();
        AttributeSet set = doc.getCharacterElement(0).getAttributes();
        Style style = tp.addStyle("", null);
        StyleConstants.setForeground(style, c);
        StyleConstants.setFontFamily(style, "Courier New");
        StyleConstants.setFontSize(style, 14);
        tp.setCharacterAttributes(style, true);

        try{
            TimeUnit.MILLISECONDS.sleep((long) bd);
            doc.insertString(doc.getLength(), s, style);
            TimeUnit.MILLISECONDS.sleep((long) ad);
        }
        catch (BadLocationException e){}
    }
    
    public void outputHuge(JTextPane tp, String s, double d) throws Exception{
        StyledDocument doc = tp.getStyledDocument();
        att = new SimpleAttributeSet();
        Style style = tp.addStyle("", null);
        StyleConstants.setFontFamily(style, "Courier New");
        StyleConstants.setFontSize(style, 34);
        tp.setCharacterAttributes(style, true);
        doc.insertString(doc.getLength(), s, style);
        try{
            for(int m = 0; m<255; m++){
                TimeUnit.MILLISECONDS.sleep(5);
                Color color = new Color(0+m, 0+m, 0+m);
                StyleConstants.setForeground(style, color);
                tp.setCharacterAttributes(style, true);
                doc.remove(0, s.length());
                doc.insertString(0, s, style);
            }
        }
        catch (BadLocationException e){}
        Format();
        tp.setCharacterAttributes(att, true);
        tp.setParagraphAttributes(att, true);
        Thread.sleep((long) d);
    }

    public void outputSlow(JTextPane tp, String s, double bd, double ad, double sp, boolean remove) throws Exception{
        if(remove == true)
            tp.setText("");
        String[] splitString = s.split("");
        TimeUnit.MILLISECONDS.sleep((long)bd);
        int i;
        for (i = 0; i < splitString.length; i++){
            TimeUnit.MILLISECONDS.sleep((long)sp);
            tp.setText(tp.getText() + splitString[i]);
        }
        TimeUnit.MILLISECONDS.sleep((long)ad);
    }
    public void outputSlowQuote(JTextPane tp, String s, double bd, double ad, double sp, boolean remove) throws Exception{
        if(remove == true)
            tp.setText("");
        String[] splitString = s.split("");
        TimeUnit.MILLISECONDS.sleep((long)bd);
        int i;
        for (i = 0; i < splitString.length; i++){
            TimeUnit.MILLISECONDS.sleep((long)sp);
            tp.setText("\"" + tp.getText().replaceAll("\"","") + splitString[i] + "\"");
        }
        TimeUnit.MILLISECONDS.sleep((long)ad);
    }
}
