import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;

public class TheGame
{
    Output o = new Output();
    Hero hero = new Hero();
    public void run(JFrame frame) throws Exception {
        
        JPanel textPanel = new JPanel();
        JTextField inputPanel = new JTextField();
        JTextPane t1 = new JTextPane();
        JTextPane t2 = new JTextPane();
        
        inputPanel.setPreferredSize(new Dimension(0, 100));
        textPanel.setBackground(Color.darkGray);
        inputPanel.setBackground(Color.BLACK);
        inputPanel.setForeground(Color.WHITE);
        t1.setBackground(Color.BLACK);
        t2.setBackground(Color.BLACK);
        double speed = 0.5;
        int i = 0;
        while(i != 1)
        {
            textPanel.setLayout(new BorderLayout());
            textPanel.add(t1, BorderLayout.WEST);
            textPanel.add(t2, BorderLayout.EAST);
            
            SimpleAttributeSet att_t1 = new SimpleAttributeSet();
            StyleConstants.setAlignment(att_t1, StyleConstants.ALIGN_LEFT);
            StyleConstants.setForeground(att_t1, Color.WHITE);
            StyleConstants.setBackground(att_t1, Color.GRAY);
            StyleConstants.setFontSize(att_t1, 25);
            StyleConstants.setBold(att_t1, false);
            StyleConstants.setFontFamily(att_t1, "Terminal");

            t1.setCharacterAttributes(att_t1, true);

            SimpleAttributeSet att_t2 = new SimpleAttributeSet();
            StyleConstants.setAlignment(att_t2, StyleConstants.ALIGN_RIGHT);
            StyleConstants.setForeground(att_t2, Color.WHITE);
            StyleConstants.setBackground(att_t2, Color.GRAY);
            StyleConstants.setFontSize(att_t2, 25);
            t2.setCharacterAttributes(att_t2, true);
 
            frame.add(textPanel, BorderLayout.NORTH);
            frame.add(inputPanel, BorderLayout.SOUTH);

            
            o.clear();
            o.output("Press START (or enter \"1\" if playing on a computer) to begin\n",0.0,0.0,false);

            o.outputGUI(t1, "TEXT 1", 500, 500, true);
            o.outputGUI(t1, "\nTEXT 2", 500, 500, true);
            
            o.outputGUI(t2, "GAME PANE", 0, 0, true);
            Scanner ans = new Scanner(System.in);
            try
            {
                i = ans.nextInt();
            }
            catch(Exception e)
            {
                o.clear();
                o.outputC("I'll take that as a 1!",0.0,4.0*speed,true,1);
                o.outputGUI(t1, "I'll...", 0, 4000*speed, true);
                i = 1;
            }
            if(i == 1)
            {
                o.clear();
                o.output("\nWelcome to FERALDS'S WORLD!",0.0,4.0*speed,false);
                o.output("Before the adventure can begin you must choose a hero!",0.0,4.0*speed,true);
                o.output("First, pick a RACE.",0.0,3.0*speed,true);
                o.output("Human?",0.0,2.0*speed,true);
                o.output("Orch?",0.0,2.0*speed,true);
                o.output("Elf?",0.0,2.0*speed,true);
                o.output("Oooor...",0.0,3.0*speed,true);
                o.output("Dwarf?",0.0,3.0*speed,true);
                o.output("Since you're playing on a computer, choose a RACE by\nentering \"1\" (Human), \"2\" (Orch), \"3\" (Elf) or \"4\" (Dwarf):\n",0.0,0.0,true);
                Scanner ansRace = new Scanner(System.in);
                int Race = ansRace.nextInt();
                if(Race == 1)
                {
                    hero.setRace("Human");
                    o.clear();
                    o.output("\nOh... A fancy human again. Oh well, to choose gender,\nenter a number between 1 and 10:\n",2.0*speed,0.0,true);
                    Scanner ansGender = new Scanner(System.in);
                    int Gender = ansGender.nextInt();
                    if(true)
                    {
                        o.clear();
                        o.output("\nOk, this won't do...",3.0*speed,2.0*speed,false);
                        o.output("Please choose either male (\"1\"), female (\"2\") or transgender (\"3\")!\n",0.0,0.0,true);
                        Scanner ansNewGender = new Scanner(System.in);
                        int NewGender = ansNewGender.nextInt();
                        String gender;
                        if(NewGender == 1)
                        {
                            gender = "MALE";
                            hero.setGender("Male");
                        }
                        else if(NewGender == 2)
                        {
                            gender = "FEMALE";
                            hero.setGender("Female");
                        }
                        else
                        {
                            gender = "TRANSGENDER";
                            hero.setGender("Transgender");
                        }
                        o.clear();
                        o.output("\nOk. Now the game can finally begin!",3.0*speed,3.0*speed,false);
                        o.output("Wait!",0.0,2.0*speed,true);
                        o.output("Whats your name?\n",0.0,0.0,true);
                        Scanner name = new Scanner(System.in);
                        String Name = name.next();
                        hero.setName(Name);
                        o.clear();
                        o.output("\nYou have choosen to play as "+hero.getNameU(1)+", the "+hero.getGenderU(1)+" "+hero.getRaceU(1)+"\n",3*speed,0,true);
                    }
                }
            }
        }
    }
}
