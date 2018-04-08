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
        stats.updateStats(t3, hero);

        o.output(model, t1, "As you get closer the dark contours emerges to the shape of a small cabin.",0.0, true);
        o.outputSlowQuote(model, t1, "Maybe I can find some clothes here...", 0.0, 100*speed, true);
        
        Picker picker = new Picker();
        String[] options = {"Go sneaky peeky", "Rush forward", "Turn back"};
        String[] hints = {"", "", ""};
        pickerPosition = 0;
        while(model.getInput().equals("")){
            Thread.sleep(50);
            if(pickerPosition > options.length - 1)
                pickerPosition = 0;
            if(pickerPosition < 0)
                pickerPosition = options.length - 1;
            picker.pickOption(t1, options, hints, pickerPosition, "How do you wish to approach?\n");
            inputPanel.setText(options[pickerPosition]);
        }
        inputPanel.setText("");model.setInput("");
        String choice = options[pickerPosition];

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
