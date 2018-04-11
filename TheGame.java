import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;
import java.awt.event.*;

public class TheGame{

    int pickerPosition = 1;
    String input = "";

    final DataModel model = new DataModel();
    private final Frame frame = new Frame("FERALD'S WORLD");
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

    ArrowKeys kl = new ArrowKeys(inputPanel, model);

    public TheGame(){
        frame.setBackground(Color.BLACK);
        frame.setLayout(new GridBagLayout());
        //frame.setVisible(true);
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

    public void run() throws Exception{
        if(true){
            Quest_Intro q_i = new Quest_Intro(frame);
            q_i.run(inv, stats, hero);
        }

        //hero.setGender("Male");
        //hero.setRace("Orc");
        //hero.setName("Feralkohol");

        if(true){
            Quest_Beginning q_i = new Quest_Beginning(frame);
            q_i.run(inv, stats, hero);
        }
    }
}
