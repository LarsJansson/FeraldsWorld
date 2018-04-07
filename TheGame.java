import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;
import java.awt.event.*;

public class TheGame
{
    double speed = 0.05;
    boolean restart = true;
    int pickerPosition = 1;
    String input = "";
    
    final DataModel model = new DataModel();

    JFrame frame = new Frame("FERALDS WORLD");
    Output o = new Output();
    Hero hero = new Hero();
    JPanel textPanel = new JPanel();
    JTextField inputPanel = new JTextField();
    JTextPane t1 = new JTextPane();
    JTextPane t2 = new JTextPane();
    JTextPane t3 = new JTextPane();
    Inventory inv = new Inventory(t2);
    Stats stats = new Stats(t3);
    FrameBuilder bill = new FrameBuilder();
            
    EnterStroke al =  new EnterStroke(inputPanel, model);
    
    KeyListener kl = new KeyListener(){
        public void keyPressed(KeyEvent e){
            //System.out.println(e);
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                {}//System.out.println("left");
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                {}//System.out.println("right");
            else if (e.getKeyCode() == KeyEvent.VK_UP)
                changePosition(-1);
            else if (e.getKeyCode() == KeyEvent.VK_DOWN)
                changePosition(1);
        }
        public void keyReleased(KeyEvent e){}
        public void keyTyped(KeyEvent e){}
    };
    
    public TheGame(){
        frame.setBackground(Color.BLACK);
        frame.setLayout(new GridBagLayout());
        frame.setVisible(true);
    }
        public void setInput(String str){
         input = str;
    }

    public void changePosition(int p){
        pickerPosition += p;
    }
    public void setPosition(int p){
        pickerPosition = p;
    }

    public void run() throws Exception {
        frame.dispose();
        if(true){
        Quest0 q0 = new Quest0();
        q0.run(inv, stats, hero);
        }
        if(true){
        Quest1 q1 = new Quest1();
        q1.run(inv, stats, hero);
        }
    }
}
