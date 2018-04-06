//import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;
import java.awt.event.*;

public class TheGame
{
    Output o = new Output();
    Inventory inv = new Inventory();
    Hero hero = new Hero();
    Stats stats = new Stats();
    String input = "";
    
    public void setInput(String str){
         input = str;
    }

    public void run(JFrame frame) throws Exception {
        JPanel textPanel = new JPanel();
        JTextField inputPanel = new JTextField();
        JTextPane t1 = new JTextPane();
        JTextPane t2 = new JTextPane();
        JTextPane t3 = new JTextPane();
                
        ActionListener al =  new ActionListener()
        {
            public String str;
            public void actionPerformed(ActionEvent event)
            {
                str = inputPanel.getText();
                inputPanel.setText("");
                setInput(str);
            }
        };
        inputPanel.addActionListener(al);
      
        FrameBuilder bill = new FrameBuilder();
        bill.build(frame, inputPanel, textPanel, t1, t2, t3);
       
        double speed = 0.05;
        boolean restart = true;
        while(restart){
            o.clear();
            inv.clear(t2);
            o.outputGUI(t1,"Press START (or enter \"1\" if playing on a computer) to begin\n",0.0,0.0,false);
            
            inputPanel.setText("");
            input = inputPanel.getText();
            while(input.equals("")){
                Thread.sleep(100);
            }
            if(input.equals("1"))
            
            {
                o.clearGUI(t1);
                o.outputGUI(t1,"Welcome to FERALDS'S WORLD!",0.0,4000*speed,false);
                inv.addItem(t2,"Pants!");
                o.outputGUI(t1,"Before the adventure can begin you must choose a hero!",0.0,4000*speed,true);
                o.outputGUI(t1,"First, pick a RACE.",0.0,3000*speed,true);
                o.outputGUI(t1,"Human?",0.0,2000*speed,true);
                o.outputGUI(t1,"Orch?",0.0,2000*speed,true);
                o.outputGUI(t1,"Elf?",0.0,2000*speed,true);
                o.outputGUI(t1,"Oooor...",0.0,3000*speed,true);
                o.outputGUI(t1,"Dwarf?",0.0,3000*speed,true);
                o.outputGUI(t1,"Since you're playing on a computer, choose a RACE by\nentering \"1\" (Human), \"2\" (Orch), \"3\" (Elf) or \"4\" (Dwarf):",0.0,0.0,true);
                
                inputPanel.setText("");
                input = inputPanel.getText();
                while(input.equals(""))
                    Thread.sleep(100);

                if(input.equals("1"))
                {
                    hero.setRace("Human");
                    o.clearGUI(t1);
                    o.outputGUI(t1,"Oh... A fancy human again. Oh well, to choose gender,\nenter a number between 1 and 10:",2000*speed,0.0,true);
                    
                    inputPanel.setText("");
                    input = inputPanel.getText();
                    while(input.equals(""))
                            Thread.sleep(100);

                    if(!input.equals(""))
                    {
                        o.clearGUI(t1);
                        o.outputGUI(t1,"Ok, this won't do...",3000*speed,2000*speed,false);
                        o.outputGUI(t1,"Please choose either male (\"1\"), female (\"2\") or transgender (\"3\")!\n",0.0,0.0,true);
                        
                        inputPanel.setText("");
                        input = inputPanel.getText();
                        while(input.equals(""))
                            Thread.sleep(100);
                        
                        if(input.equals("1"))
                            hero.setGender("Male");
                        else if(input.equals("2"))
                            hero.setGender("Female");
                        else
                            hero.setGender("Transgender");
                        o.clearGUI(t1);
                        o.outputGUI(t1,"Ok. Now the game can finally begin!",3000*speed,3000*speed,false);
                        o.outputGUI(t1,"Wait!",0.0,2000*speed,true);
                        o.outputGUI(t1,"Whats your name?",0.0,0.0,true);
                        
                        inputPanel.setText("");
                        input = inputPanel.getText();
                        while(input.equals(""))
                            Thread.sleep(100);
                        hero.setName(input);
                        o.clearGUI(t1);
                        o.outputGUI(t1,String.format("You have choosen to play as %s, the %s %s",hero.getNameU(),hero.getGenderU(),hero.getRaceU()),3000*speed,0.0,true);
                        stats.updateStats(t3,hero);
                        o.outputGUISQ(t1,"Zzzz......",0.0,3000*speed,true);
                        o.outputGUISQ(t1,"Zzzzzzzz...",0.0,2000*speed,true);
                        o.outputGUISQ(t1,"Hrmph...",0.0,3000*speed,true);
                        String g;
                        if(hero.getGender() == "Male")
                            g = "He";
                        else if(hero.getGender() == "Female")
                            g = "She";
                        else
                            g = "He/she";
                        o.outputGUIS(t1,g + " is waking up.",0.0,3000*speed,true);
                        o.outputGUISQ(t1,"What? ",0.0,3000*speed,true);
                        o.outputGUISQ(t1,"Where am I?",0.0,3000*speed,false);

                        restart = false;
                    }
                }
            }
        }
    }
}
