import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;
import java.awt.event.*;

public class Quest0 extends TheGame{
    public void run(Inventory inv, Stats stats, Hero hero) throws Exception {
        inputPanel.addActionListener(al);
        bill.build(frame, inputPanel, textPanel, t1, t2, t3);
        
        while(restart){
            o.clearGUI(t1);
            inv.clear(t2);
            o.outputGUI(t1,"Press START (or enter \"1\" if playing on a computer) to begin\n",0.0,0.0,false);
            
            inputPanel.setText("");
            input = inputPanel.getText();
            while(input.equals(""))
                Thread.sleep(100);
            
            if(input.equals("1"))          
            {
                o.clearGUI(t1);
                o.outputGUI(t1,"Welcome to FERALDS'S WORLD!",0.0,4000*speed,false);
                inv.addItem(t2,"Pants!");
                o.outputGUI(t1,"Before the adventure can begin you must choose a hero!",0.0,3000*speed,true);
                o.outputGUI(t1,"First, pick a RACE.",0.0,3000*speed,true);
                o.outputGUI(t1,"Human?",0.0,2000*speed,true);
                o.outputGUI(t1,"Orch?",0.0,2000*speed,true);
                o.outputGUI(t1,"Elf?",0.0,2000*speed,true);
                o.outputGUI(t1,"Oooor...",0.0,2000*speed,true);
                o.outputGUI(t1,"Dwarf?",0.0,2000*speed,true);
                
                inputPanel.setText("");
                input = inputPanel.getText();
                while(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4"))
                {
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
                        }
                    }
                    else if(input.equals("2"))
                    {
                        hero.setRace("Orch");
                        o.clearGUI(t1);
                        o.outputGUI(t1,"A filthy orch? Really? Oh well, it's your choice!",2000*speed,3000*speed,true);
                        inputPanel.setText("");
                        input = inputPanel.getText();
                            
                        o.clearGUI(t1);
                        o.outputGUI(t1,"Now, choose your gender. Enter (\"1\") for male,(\"2\") for female or (\"3\") for transgender.",0.0,0.0,true);
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
                    }
                    else if(input.equals("3"))
                    {
                        hero.setRace("Elf");
                        o.clearGUI(t1);
                        o.outputGUI(t1,"Excellent choice! Elfs are famous for their wisdom!",2000*speed,3000*speed,true);
                        o.outputGUI(t1,"\nAnd their ears...",0.0,3000*speed,false);
                        inputPanel.setText("");
                        input = inputPanel.getText();
                            
                        o.clearGUI(t1);
                        o.outputGUI(t1,"Now, pick your gender! Enter (\"1\") for male,(\"2\") for female or (\"3\") for transgender.",0.0,0.0,true);
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
                    }
                    else if(input.equals("4"))
                    {
                        hero.setRace("Dwarf");
                        o.clearGUI(t1);
                        o.outputGUI(t1,"Oh hello! Didn't see you there! A true dwarf it is!",2000*speed,3000*speed,true);
                        inputPanel.setText("");
                        input = inputPanel.getText();
                            
                        o.clearGUI(t1);
                        o.outputGUI(t1,"Maybe this is a stupid question, but do dwarfs have genders?\nIf you do, enter (\"1\") for male,(\"2\") for female or (\"3\") for transgender.",0.0,0.0,true);
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
                    }
                    else
                    {
                        o.outputGUI(t1,"That was not an option!",0.0,2000*speed,true);
                    }
                }
                
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
                o.outputGUI(t1,String.format("You have choosen to play as %s, the %s %s",hero.getNameU(),hero.getGenderU(),hero.getRaceU()),3000*speed,4000*speed,true);
                stats.updateStats(t3,hero);
                o.outputGUISQ(t1,"Zzzz......",0.0,3000*speed,150*speed,true);
                o.outputGUISQ(t1,"Zzzzzzzz...",0.0,2000*speed,150*speed,true);
                o.outputGUISQ(t1,"Hrmph...",0.0,3000*speed,75*speed,true);
                String g;
                
                if(hero.getGender() == "Male")
                    g = "He";
                else if(hero.getGender() == "Female")
                    g = "She";
                else
                    g = "He/she";
               
                o.outputGUIS(t1,g + " is waking up.",0.0,3000*speed,150*speed,true);
                o.outputGUISQ(t1,"What?",0.0,2000*speed,100*speed,true);
                o.outputGUISQ(t1," Where am I?",0.0,4000*speed,100*speed,false);
                o.outputGUIS(t1,"As I tried to rise, it felt like the cold hard ground rose up around my body.",0.0,2000*speed,75*speed,true);
                o.outputGUIS(t1,"\nEven though the sun was already halfway up, I was still to disoriented\nto rely on any other sences than smell and touch.",0.0,3000*speed,75*speed,true);
                 o.outputGUIS(t1,"\nThe giant twig that had found its home in my butt told me I was in a forest.",0.0,3000*speed,75*speed,true);

                restart = false;
                frame.dispose();
            }
        }
        super.hero = hero;
        super.inv = inv;
        super.stats = stats;
    }
}
