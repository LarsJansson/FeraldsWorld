import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;
import java.awt.event.*;

public class Quest0 extends TheGame{
    public void run(Inventory inv, Stats stats, Hero hero) throws Exception {
        inputPanel.addActionListener(al);
        bill.build(frame, inputPanel, textPanel, t1, t2, t3);
        inputPanel.grabFocus(); 
        while(restart){
            o.clearGUI(t1);
            inv.clear(t2);

            /////////// test area
            //
            //
            //inv.addItem(t2, "Pants");
            //System.out.println(inv.search(t2, "Pants"));
            //
            o.outputHuge(t1, "Starting\n", 1000);
            //
            //////////////////////////////


            o.output(t1,"Press START (or enter \"1\" if playing on a computer) to begin\n",0.0,0.0,true);
            
            inputPanel.setText("");
            input = model.getInput();
            while(model.getInput().equals(""))
                Thread.sleep(100);
            
            if(model.getInput().equals("1"))          
            {
                o.clearGUI(t1);
                o.output(t1,"Welcome to FERALDS'S WORLD!",0.0,3000*speed,true);
                o.output(t1,"Before the adventure can begin you must choose a hero!",0.0,3000*speed,true);
                o.output(t1,"First, pick a RACE.",0.0,3000*speed,true);
                o.output(t1,"Human?",0.0,2000*speed,true);
                o.output(t1,"Orch?",0.0,2000*speed,true);
                o.output(t1,"Elf?",0.0,2000*speed,true);
                o.output(t1,"Oooor...",0.0,2000*speed,true);
                o.output(t1,"Dwarf?",0.0,2000*speed,true);
                
                inputPanel.setText("");
                model.setInput("");
                input = model.getInput();
                while(!model.getInput().equals("1") && !model.getInput().equals("2") && !model.getInput().equals("3") && !model.getInput().equals("4"))
                {
                    o.output(t1,"Since you're playing on a computer, choose a RACE by\nentering \"1\" (Human), \"2\" (Orch), \"3\" (Elf) or \"4\" (Dwarf):",0.0,0.0,true);
                    model.setInput("");
                    inputPanel.setText("");
                    input = model.getInput();
                    while(model.getInput().equals(""))
                        Thread.sleep(100);

                    if(model.getInput().equals("1"))
                    {
                        hero.setRace("Human");
                        o.clearGUI(t1);
                        o.output(t1,"Oh... A fancy human again. Oh well, to choose gender,\nenter a number between 1 and 10:",2000*speed,0.0,true);
                        inputPanel.setText("");model.setInput("");
                        input = model.getInput();
                        
                        while(model.getInput().equals(""))
                            Thread.sleep(100);

                        if(!model.getInput().equals(""))
                        {
                            o.clearGUI(t1);
                            o.output(t1,"Ok, this won't do...",3000*speed,2000*speed,false);
                            o.output(t1,"Please choose either male (\"1\"), female (\"2\") or transgender (\"3\")!\n",0.0,0.0,true);
                            inputPanel.setText("");model.setInput("");
                            input = model.getInput();
                        
                            while(model.getInput().equals(""))
                                Thread.sleep(100);
                        
                            if(model.getInput().equals("1"))
                                hero.setGender("Male");
                            else if(model.getInput().equals("2"))
                                hero.setGender("Female");
                            else
                                hero.setGender("Transgender");
                                o.clearGUI(t1);
                        }
                    }
                    else if(model.getInput().equals("2"))
                    {
                        hero.setRace("Orch");
                        o.clearGUI(t1);
                        o.output(t1,"A filthy orch? Really? Oh well, it's your choice!",2000*speed,3000*speed,true);
                        inputPanel.setText("");model.setInput("");
                        input = model.getInput();
    
                        o.clearGUI(t1);
                        o.output(t1,"Now, choose your gender. Enter (\"1\") for male,(\"2\") for female or (\"3\") for transgender.",0.0,0.0,true);
                        inputPanel.setText("");model.setInput("");
                        input = model.getInput();
 
                        while(model.getInput().equals(""))
                            Thread.sleep(100);
                        
                        if(model.getInput().equals("1"))
                            hero.setGender("Male");
                        else if(model.getInput().equals("2"))
                            hero.setGender("Female");
                        else
                            hero.setGender("Transgender");
                    }
                    else if(model.getInput().equals("3"))
                    {
                        hero.setRace("Elf");
                        o.clearGUI(t1);
                        o.output(t1,"Excellent choice! Elfs are famous for their wisdom!",2000*speed,3000*speed,true);
                        o.output(t1,"\nAnd their ears...",0.0,3000*speed,false);
                        inputPanel.setText("");model.setInput("");
                        input = model.getInput();
    
                        o.clearGUI(t1);
                        o.output(t1,"Now, pick your gender! Enter (\"1\") for male,(\"2\") for female or (\"3\") for transgender.",0.0,0.0,true);
                        inputPanel.setText("");model.setInput("");
                        input = model.getInput();
 
                        while(model.getInput().equals(""))
                            Thread.sleep(100);
                        
                        if(model.getInput().equals("1"))
                            hero.setGender("Male");
                        else if(model.getInput().equals("2"))
                            hero.setGender("Female");
                        else
                            hero.setGender("Transgender");
                    }
                    else if(model.getInput().equals("4"))
                    {
                        hero.setRace("Dwarf");
                        o.clearGUI(t1);
                        o.output(t1,"Oh hello! Didn't see you there! A true dwarf it is!",2000*speed,3000*speed,true);
                        inputPanel.setText("");model.setInput("");
                        input = model.getInput();
    
                        o.clearGUI(t1);
                        o.output(t1,"Maybe this is a stupid question...",0.0,0.0,true);
                        o.output(t1,"\nDo dwarfs have genders?",3000*speed,2000*speed,false);
                        o.output(t1,"\nIf you do, enter (\"1\") for male,(\"2\") for female or (\"3\") for transgender.",2000*speed,0.0,false);
                        inputPanel.setText("");model.setInput("");
                        input = model.getInput();
 
                        while(model.getInput().equals(""))
                            Thread.sleep(100);
                        
                        if(model.getInput().equals("1"))
                            hero.setGender("Male");
                        else if(model.getInput().equals("2"))
                            hero.setGender("Female");
                        else
                            hero.setGender("Transgender");                  
                    }
                    else
                    {
                        o.output(t1,"That was not an option!",0.0,2000*speed,true);
                    }
                }
                
                o.clearGUI(t1);
                o.output(t1,"Ok. Now the game can finally begin!",3000*speed,3000*speed,false);
                o.output(t1,"Wait!",0.0,2000*speed,true);
                o.output(t1,"Whats your name?",0.0,0.0,true);
                        
                inputPanel.setText("");model.setInput("");
                input = model.getInput();
 
                while(model.getInput().equals(""))
                    Thread.sleep(100);
                
                hero.setName(model.getInput());
                o.clearGUI(t1);
                o.output(t1,String.format("You have choosen to play as %s, the %s %s",hero.getNameU(),hero.getGenderU(),hero.getRaceU()),3000*speed,4000*speed,true);
                stats.updateStats(t3,hero);
                o.outputSlowQuote(t1,"Zzzz......",0.0,3000*speed,150*speed,true);
                o.outputSlowQuote(t1,"Zzzzzzzz...",0.0,2000*speed,150*speed,true);
                o.outputSlowQuote(t1,"Hrmph...",0.0,3000*speed,50*speed,true);
                String g;
                
                if(hero.getGender() == "Male")
                    g = "He";
                else if(hero.getGender() == "Female")
                    g = "She";
                else
                    g = "He/she";
               
                o.outputSlow(t1,g + " is waking up.",0.0,3000*speed,150*speed,true);
                o.outputSlowQuote(t1,"What?",0.0,2000*speed,100*speed,true);
                o.outputSlowQuote(t1," Where am I?",0.0,4000*speed,100*speed,false);
                o.outputSlow(t1,"As I tried to rise, it felt like the cold hard ground rose up around my body.",0.0,2000*speed,75*speed,true);
                o.outputSlow(t1,"Even though the sun was already halfway up, I was still too disoriented\nto rely on any other sence than touch.",0.0,3000*speed,75*speed,true);
                o.outputSlow(t1,"The giant twig that had found its home in my butt told me I was in a forest.",0.0,3000*speed,75*speed,true);
                o.outputSlow(t1,"\nAnd I had no clothes...",0.0,4000*speed,75*speed,false);

                o.output(t1,"As your other sences starts to return, you finally\nmanage to get up on your feet",0.0,4000*speed,true);
                o.output(t1,"After removing the twig from your butt you take a look around.",0.0,4000*speed,true);
                o.output(t1,"To the north the forest only seem to be thickening.",0.0,4000*speed,true);
                o.output(t1,"Turning around, looking south, the forest seem to open up a bit.",0.0,4000*speed,true);
                o.output(t1,"When you look to the east, you see something between the trees.",0.0,4000*speed,true);
                o.output(t1,"\nIt looks like the contours of small cabin or something!",0.0,4000*speed,false);
                o.output(t1,"In the other direction there is a small path leading further into the woods.",0.0,4000*speed,true);

                restart = false;
                frame.dispose();
            }
        }
        super.hero = hero;
        super.inv = inv;
        super.stats = stats;
    }
}
