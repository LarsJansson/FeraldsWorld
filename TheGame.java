import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;
import java.awt.event.*;

public class TheGame
{
    JFrame frame = new Frame("FERALDS WORLD");
    Output o = new Output();
    Hero hero = new Hero();
    String input = "";
    JPanel textPanel = new JPanel();
    JTextField inputPanel = new JTextField();
    JTextPane t1 = new JTextPane();
    JTextPane t2 = new JTextPane();
    JTextPane t3 = new JTextPane();
    Inventory inv = new Inventory(t2);
    Stats stats = new Stats(t3);
            
    ActionListener al =  new ActionListener(){
        public String str;
        public void actionPerformed(ActionEvent event){
            str = inputPanel.getText();
            inputPanel.setText("");
            setInput(str);
        }};
    FrameBuilder bill = new FrameBuilder();
    public TheGame(){
        frame.setBackground(Color.BLACK);
        frame.setLayout(new GridBagLayout());
        frame.setVisible(true);
    }
    double speed = 0.5;
    boolean restart = true;

    public void setInput(String str){
         input = str;
    }

    public void run() throws Exception {
        frame.dispose();
        if(false){
            Quest0 q0 = new Quest0();
            q0.run(inv, stats, hero);
        }
        Quest1 q1 = new Quest1();
        q1.run(inv, stats, hero);
        
    }
}
