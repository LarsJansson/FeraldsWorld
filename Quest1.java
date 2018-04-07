import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class Quest1 extends TheGame{
    public void run(Inventory inv, Stats stats, Hero hero) throws Exception{
        inputPanel.addActionListener(al);
        bill.build(frame, inputPanel, textPanel, t1, t2, t3);
        stats.updateStats(t3, hero);
        //o.outputGUIH(t1,"Quest 1 begins...", 0.0, 0.0, true, Color.RED);
        o.output(t1,"As your other sences starts to return, you finally\nmanage to get up on your feet",0.0,3000*speed,true);
        o.output(t1,"After removing the twig from your butt you take a look around.",0.0,3000*speed,true);
        o.output(t1,"To the north the trees seem to grow tighter and taller.",0.0,3000*speed,true);
        stats.updateStats(t3, hero);
        super.hero = hero;
    }
}
