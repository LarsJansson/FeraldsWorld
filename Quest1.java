import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class Quest1 extends TheGame{
    public void run(Inventory inv, Stats stats, Hero hero) throws Exception{
        inputPanel.addActionListener(al);
        bill.build(frame, inputPanel, textPanel, t1, t2, t3);
        stats.updateStats(t3, hero);
        o.outputGUIH(t1,"Quest 1 begins...", 0.0, 0.0, true, Color.RED);

        super.hero = hero;
    }
}
