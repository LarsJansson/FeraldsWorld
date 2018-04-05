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
      
        FrameBuilder bill = new FrameBuilder();
        bill.build(frame, inputPanel, textPanel, t1, t2);
       
        double speed = 0.5;
        int i = 0;
        while(i != 1){
            o.clear();
            o.outputGUI(t1,"Press START (or enter \"1\" if playing on a computer) to begin\n",0.0,0.0,false);
            Scanner ans = new Scanner(System.in);
            try
            {
                i = ans.nextInt();
            }
            catch(Exception e)
            {
                o.clearGUI(t1);
                o.outputGUI(t1,"I'll take that as a 1!",0.0,4000*speed,true);
            }
            if(i == 1)
            {
                o.clearGUI(t1);
                o.outputGUI(t1,"Welcome to FERALDS'S WORLD!",0.0,4000*speed,false);
                o.outputGUI(t1,"Before the adventure can begin you must choose a hero!",0.0,4000*speed,true);
                o.outputGUI(t1,"First, pick a RACE.",0.0,3000*speed,true);
                o.outputGUI(t1,"Human?",0.0,2000*speed,true);
                o.outputGUI(t1,"Orch?",0.0,2000*speed,true);
                o.outputGUI(t1,"Elf?",0.0,2000*speed,true);
                o.outputGUI(t1,"Oooor...",0.0,3000*speed,true);
                o.outputGUI(t1,"Dwarf?",0.0,3000*speed,true);
                o.outputGUI(t1,"Since you're playing on a computer, choose a RACE by\nentering \"1\" (Human), \"2\" (Orch), \"3\" (Elf) or \"4\" (Dwarf):",0.0,0.0,true);
                Scanner ansRace = new Scanner(System.in);
                int Race = ansRace.nextInt();
                if(Race == 1)
                {
                    hero.setRace("Human");
                    o.clearGUI(t1);
                    o.outputGUI(t1,"Oh... A fancy human again. Oh well, to choose gender,\nenter a number between 1 and 10:",2000*speed,0.0,true);
                    Scanner ansGender = new Scanner(System.in);
                    int Gender = ansGender.nextInt();
                    if(true)
                    {
                        o.clearGUI(t1);
                        o.outputGUI(t1,"Ok, this won't do...",3000*speed,2000*speed,false);
                        o.outputGUI(t1,"Please choose either male (\"1\"), female (\"2\") or transgender (\"3\")!\n",0.0,0.0,true);
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
                        o.clearGUI(t1);
                        o.outputGUI(t1,"Ok. Now the game can finally begin!",3000*speed,3000*speed,false);
                        o.outputGUI(t1,"Wait!",0.0,2000*speed,true);
                        o.outputGUI(t1,"Whats your name?",0.0,0.0,true);
                        Scanner name = new Scanner(System.in);
                        String Name = name.next();
                        hero.setName(Name);
                        o.clearGUI(t1);
                        o.outputGUI(t1,"You have choosen to play as "+hero.getNameU(1)+", the "+hero.getGenderU(1)+" "+hero.getRaceU(1)+"",3000*speed,0.0,true);
                    }
                }
            }
        }
    }
}
