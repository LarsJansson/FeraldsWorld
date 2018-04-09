import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class Quest_Path extends TheGame{
    private final Frame frame;
    public Quest_Path(final Frame frame){
        this.frame = frame;
        inputPanel.addActionListener(al);
        inputPanel.addKeyListener(kl);
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        bill.build(panel, inputPanel, textPanel, t1, t2, t3);
        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public void run(Inventory inv, Stats stats, Hero hero) throws Exception{
        inputPanel.grabFocus();
        stats.updateStats(t3, hero);
        boolean q_pruns = true;

        while(q_pruns){
            o.output(model, t1, "\"This feels much better! I'm so glad I have these shoes!\"", 0.0, true);
            o.output(model, t1, "You start to follow the path into the woods.", 0.0, true);
            o.output(model, t1, "To make the forest seem less intimidating you start to sing a bit to yourself.", 0.0, true);
            o.outputSlowQuote(model, t1, "I'm walking down on this path.", 0.0, 70*speed, true);
            o.outputSlowQuote(model, t1, "\nAbsorbed by the woods and its wrath.", 0.0, 70*speed, false);
            if(hero.isTransgender() && hero.isOrc()){
                o.outputSlowQuote(model, t1, "\nA transgender orc,", 0.0, 70*speed, false); 
                o.outputSlowQuote(model, t1, "\nmight feel like a dork,", 0.0, 70*speed, false);    
            }
            else if(hero.isMale() && hero.isOrc()){
                o.outputSlowQuote(model, t1, "\nA masculin orc,", 0.0, 70*speed, false); 
                o.outputSlowQuote(model, t1, "\nmight feel like a dork,", 0.0, 70*speed, false);    
            }
            else if(hero.isFemale() && hero.isOrc()){
                o.outputSlowQuote(model, t1, "\nA feminin orc,", 0.0, 70*speed, false); 
                o.outputSlowQuote(model, t1, "\nmight feel like a dork,", 0.0, 70*speed, false);    
            } 
            else if(hero.isTransgender() && hero.isHuman()){
                o.outputSlowQuote(model, t1, "\nA transgender being,", 0.0, 70*speed, false); 
                o.outputSlowQuote(model, t1, "\nwet from self peeing,", 0.0, 70*speed, false);    
            } 
            else if(hero.isMale() && hero.isHuman()){
                o.outputSlowQuote(model, t1, "\nA masculin guy,", 0.0, 70*speed, false); 
                o.outputSlowQuote(model, t1, "\nso scared he might die,", 0.0, 70*speed, false);    
            } 
            else if(hero.isFemale() && hero.isHuman()){
                o.outputSlowQuote(model, t1, "\nA feminin girl,", 0.0, 70*speed, false); 
                o.outputSlowQuote(model, t1, "\n'bout ready to hurl,", 0.0, 70*speed, false);    
            } 
            else if(hero.isTransgender() && hero.isElf()){
                o.outputSlowQuote(model, t1, "\nA transgender elf,", 0.0, 70*speed, false); 
                o.outputSlowQuote(model, t1, "\nwho just peed one self,", 0.0, 70*speed, false);    
            } 
            else if(hero.isMale() && hero.isElf()){
                o.outputSlowQuote(model, t1, "\nA masculin elf,", 0.0, 70*speed, false); 
                o.outputSlowQuote(model, t1, "\nwho just peed himself,", 0.0, 70*speed, false);    
            } 
            else if(hero.isFemale() && hero.isElf()){
                o.outputSlowQuote(model, t1, "\nA feminin elf,", 0.0, 70*speed, false); 
                o.outputSlowQuote(model, t1, "\nwho just peed herself,", 0.0, 70*speed, false);    
            } 
            else if(hero.isTransgender() && hero.isDwarf()){
                o.outputSlowQuote(model, t1, "\nA midget transgender,", 0.0, 70*speed, false); 
                o.outputSlowQuote(model, t1, "\nabout to surrender,", 0.0, 70*speed, false);    
            } 
            else if(hero.isMale() && hero.isDwarf()){
                o.outputSlowQuote(model, t1, "\nThough bearded and strong", 0.0, 70*speed, false); 
                o.outputSlowQuote(model, t1, "\nhe's not very long,", 0.0, 70*speed, false);    
            } 
            else if(hero.isFemale() && hero.isDwarf()){
                o.outputSlowQuote(model, t1, "\nGirly and short,", 0.0, 70*speed, false);
                o.outputSlowQuote(model, t1, "\nyou consider abort,", 0.0, 70*speed, false);
            }
            o.outputSlowQuote(model, t1, "\nlonging for home and a bath!", 0.0, 70*speed, false);

            q_pruns = false;
            stats.updateStats(t3, hero);
            super.hero = hero;
            super.inv = inv;
            super.stats = stats;
        }
    }
}
