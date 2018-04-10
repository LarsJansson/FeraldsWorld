import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.io.*;


public class Quest_Intro extends TheGame{
    private final Frame frame;
    public Quest_Intro(final Frame frame){
        this.frame = frame;
        inputPanel.addActionListener(al);
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        bill.build(panel, inputPanel, textPanel, t1, t2, t3);
        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public void run(Inventory inv, Stats stats, Hero hero) throws Exception{
        inputPanel.grabFocus(); 
        boolean q_iruns = true;

        while(q_iruns){
            o.output(model, t1, "Press START (or enter \"1\" if playing on a computer) to begin.", 0.0, true, false);
            
            inputPanel.setText("");
            model.setInput("");
            input = model.getInput();
            
            while(model.getInput().equals(""))
                Thread.sleep(100);
            
            if(model.getInput().equals("1")){
                o.clearGUI(t1);
                
                BufferedReader in = new BufferedReader(new FileReader("Logo.txt"));
                String splashLine;
                while((splashLine = in.readLine()) != null){
                    o.output(model, t1, splashLine+"\n", 0.0, false, false);
                }
                in.close();

                while(!model.getEnterPressed())
                    Thread.sleep(100);
                model.setEnterPressed(false);
 
                
                o.output(model, t1, "Before the adventure can begin you must choose a hero!", 0.0, true);
                o.output(model, t1, "First, pick a RACE.", 0.0, true);
                o.output(model, t1, "Human?", 0.0, true);
                o.output(model, t1, "Orc?", 0.0, true);
                o.output(model, t1, "Elf?", 0.0, true);
                o.output(model, t1, "Oooor...", 0.0, true);
                o.output(model, t1, "Dwarf?", 0.0, true);
                
                while(racePick(model, t1, hero))
                    racePick(model, t1, hero);

                if(hero.isHuman()){
                    o.output(model, t1, "Oh... A fancy human again. Oh well, to choose gender,\nenter a number between 1 and 10.", 2000*speed, true, false);
                    inputPanel.setText("");
                    model.setInput("");
                    input = model.getInput();
                    
                    while(model.getInput().equals(""))
                        Thread.sleep(100);
                    o.clearGUI(t1);
                    o.output(model, t1, "Ok, this won't do...", 2000*speed, true);
                    genderPick(model, t1, hero);
                }
                else if(hero.isOrc()){
                    o.output(model, t1, "A filthy orc? Really? Oh well, it's your choice!", 2000*speed, true);
                    genderPick(model, t1, hero);
                }
                else if(hero.isElf()){
                    o.output(model, t1, "Excellent choice! Elfs are famous for their wisdom!", 2000*speed, true);
                    o.output(model, t1, "\nAnd their ears...", 0.0, false);
                    genderPick(model, t1, hero);
                }
                else if(hero.isDwarf()){
                    o.output(model, t1, "Oh hello! Didn't see you there! A true dwarf it is!", 2000*speed, true);
                    o.output(model, t1, "Maybe this is a stupid question...", 0.0, true);
                    o.output(model, t1, "\nDo dwarfs have genders?", 0.0, false);
                    genderPick(model, t1, hero);
                }

                o.output(model, t1, "Ok. Now the game can finally begin!", 2000*speed, true);
                o.output(model, t1, "Wait!", 0.0, true);
                o.output(model, t1, "Whats your name?", 0.0, true, false);   
                namePick(model, t1, hero);

                o.output(model, t1, String.format("You have choosen to play as %s, the %s %s.", hero.getNameU(), hero.getGenderU(), hero.getRaceU()), 2000*speed, true);
                
                stats.updateStats(t3, hero);

                o.outputSlowQuote(model, t1, "Zzzz......", 0.0, 150*speed, true);
                o.outputSlowQuote(model, t1, "Zzzzzzzz...", 0.0, 150*speed, true);
                o.outputSlowQuote(model, t1, "Hrmph...", 0.0, 30*speed, true);
                
                String g;
                if(hero.getGender() == "Male")
                    g = "He";
                else if(hero.getGender() == "Female")
                    g = "She";
                else
                    g = "He/she";
               
                o.output(model, t1, g+" is waking up.", 0.0, true);
                o.outputSlowQuote(model, t1, "What?", 0.0, 100*speed, true);
                o.outputSlowQuote(model, t1, " Where am I?", 0.0, 100*speed, false);
                o.output(model, t1, "As I tried to rise, it felt like the cold hard ground rose up around my body.", 0.0, true);
                o.output(model, t1, "Even though the sun was already halfway up, I was still too disoriented\nto rely on any other sense than touch.", 0.0, true);
                o.output(model, t1, "The giant twig that had found its home in my butt told me I was in a forest.", 0.0, true);
                o.output(model, t1, "\nAnd I had no clothes...", 0.0, false);
                o.output(model, t1, "As your other senses starts to return, you finally\nmanage to get up on your feet.", 0.0, true);
                o.output(model, t1, "After removing the twig from your butt you take a look around.", 0.0, true);
                o.output(model, t1, "To the north the forest only seem to thicken and grow darker.", 0.0, true);
                o.output(model, t1, "When you turn around the forest seem to open up a bit however!", 0.0, true);
                o.output(model, t1, "Turning east, you see something between the trees.", 0.0, true);
                o.output(model, t1, "It looks like the contours of a house of some kind!\nA small path on the forest floor leads towards it.", 0.0, true);
                o.output(model, t1, "In the opposite direction the path dissapears into the woods...", 0.0, true);

                q_iruns = false;
            }
        }
        super.hero = hero;
        super.inv = inv;
        super.stats = stats;
    }

    public boolean racePick(DataModel model, JTextPane t1, Hero hero) throws Exception{
        boolean racepick = true;
        o.output(model, t1, "Since you're playing on a computer, choose a RACE by entering\n\"1\" for HUMAN, \"2\" for ORC, \"3\" for ELF or \"4\" for DWARF.", 0.0, true, false);
    
        inputPanel.setText("");
        model.setInput("");
        input = model.getInput();
                 
        while(model.getInput().equals(""))
            Thread.sleep(100);
                
        o.clearGUI(t1);
        if(model.getInput().equals("1")){
            hero.setRace("Human");
            racepick = false;
        }   
        else if(model.getInput().equals("2")){
            hero.setRace("Orc");
            racepick = false;
        }
        else if(model.getInput().equals("3")){
            hero.setRace("Elf");
            racepick = false;
        }
        else if(model.getInput().equals("4")){
            hero.setRace("Dwarf");
            racepick = false;
        }
        else{
            o.output(model, t1, "That was not an option!", 0.0, true);
        }
        return racepick;
    }

    public void genderPick(DataModel model, JTextPane t1, Hero hero) throws Exception{
        o.output(model, t1, "Please enter \"1\" for MALE, \"2\" for FEMALE or \"3\" for TRANSGENDER.", 0.0, true, false);
        
        inputPanel.setText("");
        model.setInput("");
        input = model.getInput();
        
        while(model.getInput().equals(""))
            Thread.sleep(100);
        o.clearGUI(t1);        
        if(model.getInput().equals("1"))
            hero.setGender("Male");
        else if(model.getInput().equals("2"))
            hero.setGender("Female");
        else
            hero.setGender("Transgender");
    }

    public void namePick(DataModel model, JTextPane t1, Hero hero) throws Exception{
        inputPanel.setText("");
        model.setInput("");
        input = model.getInput();
                    
        while(model.getInput().equals(""))
            Thread.sleep(100);
        o.clearGUI(t1);                                                
        hero.setName(model.getInput());
    }

}
