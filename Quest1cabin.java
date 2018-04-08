import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class Quest1cabin extends TheGame{
    public void run(Inventory inv, Stats stats, Hero hero) throws Exception{
        inputPanel.addActionListener(al);
        inputPanel.addKeyListener(kl);
        bill.build(frame, inputPanel, textPanel, t1, t2, t3);
        inputPanel.grabFocus();

        if(hero.isMale()){
            o.output(t1, "Nice! A pair of tiny shoes!", 0.0, 500, false);
            inv.add(t2, "Too small Shoes");
        }else if(hero.isFemale()){
            o.output(t1, "Nice! A pair of huge shoes!", 0.0, 500, false);
            inv.add(t2, "Too big shoes");
        }else{
            o.output(t1, "Nice! Although not fit for a tranny, I will keep these non glittery shoes", 0.0, 500, false);
            inv.add(t2, "Normal people shoes");
        }   
        o.output(t1, "Added Shoes to the inventory!", 0.0, 500, false);
        hero.xpInc(50);
        o.output(t1, "Gained 50 xp!", 0.0, 500, false);
        
        stats.updateStats(t3, hero);
        super.hero = hero;
        super.inv = inv;
        super.stats = stats;
    }
}
