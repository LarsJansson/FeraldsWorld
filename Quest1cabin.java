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

        o.output(model, t1, "As you get closer the dark contours emerges to the shape of a small cabin.",0.0, true);
        o.outputSlowQuote(model, t1, "Maybe I can find some clothes here...", 0.0, 100*speed, true);

        if(hero.isMale()){
            SmallShoes ss = new SmallShoes();
            o.output(model, t1, "Nice! A pair of tiny shoes!\n", 0.0, false);
            inv.add(t2, ss);
        }else if(hero.isFemale()){
            LargeShoes ls = new LargeShoes();
            o.output(model, t1, "Nice! A pair of huge shoes!\n", 0.0, false);
            inv.add(t2, ls);
        }else{
            NormieShoes ns = new NormieShoes();
            o.output(model, t1, "Nice! Although not fit for a tranny, I will keep these non glittery shoes\n", 0.0, false);
            inv.add(t2, ns);
        }   
        o.output(model, t1, "Added Shoes to the inventory!\n", 0.0, false);
        hero.xpInc(50);
        o.output(model, t1, "Gained 50 xp!\n", 0.0, false);
        
        stats.updateStats(t3, hero);
        super.hero = hero;
        super.inv = inv;
        super.stats = stats;
        frame.dispose();
    }
}
