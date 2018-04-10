import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;


public class Picker{
    int p;

    public void pickOption(JTextPane tp, String[] options, String[] hints, int p, String q) throws Exception{
        try{
            String oldText = tp.getText();
            String newText = q+"\n\n";
            for (int o = 0; o < options.length; o++){
                if (p == o){
                    newText = newText.concat(">"+options[o]+" "+hints[o]+"\n");
                }else{
                    newText = newText.concat(" "+options[o]+" "+hints[o]+"\n");
                }
            }
            tp.setText(""+newText);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
            p = 1;
        }
    }

    public void pick(DataModel model, JTextPane tp, String[] op, String[] h, String q, JTextField inputPanel) throws Exception{
        while(model.getInput().equals("")){
            Thread.sleep(50);
            if(model.getPosition() > op.length - 1)
                model.setPosition(0);
            if(model.getPosition() < 0)
                model.setPosition(op.length - 1);
            try{
                String oldText = tp.getText();
                String newText = q+"\n\n";
                for (int o = 0; o < op.length; o++){
                    if (model.getPosition() == o){
                        newText = newText.concat(">"+op[o]+" "+h[o]+"\n");
                    }else{
                        newText = newText.concat(" "+op[o]+" "+h[o]+"\n");
                    }
                }
                tp.setText(""+newText);
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println(e);
                model.setPosition(1);
            }
            inputPanel.setText(op[p]);
        }
        inputPanel.setText("");
        model.setInput("");
    }
}
