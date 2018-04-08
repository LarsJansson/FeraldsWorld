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

        if(choice == "Go sneaky peeky"){
            o.output(model, t1, "As you move in closer you try to use the trees as cover.", 0.0, true);
            o.output(model, t1, "Almost there, you crouch down behind a bush to take a closer look.\nYou don't see any lights in any of the windows.", 0.0, true);
            o.outputSlowQuote(model, t1, "Maybe there's no one home...", 0.0, 70*speed, true);
            o.output(model, t1, "You leave your cover and sneak up to one of the windows.", 0.0, true);
            o.output(model, t1, "As you look inside, a light is turned on!", 0.0, true);
            o.output(model, t1, "Quickly you crouch down under the window!", 0.0, true);
            o.output(model, t1, "You now hear someone walking inside.", 0.0, true);
            o.outputSlowQuote(model, t1, "Hello?", 0.0, 70*speed, true);
            o.outputSlowQuote(model, t1, "Is there someone out there?", 0.0, 70*speed, true);
            o.output(model, t1, "What ", 0.0, true);
        }
        else if(choice == "Rush forward"){
            o.output(model, t1, "\"Ouch!\"", 0.0, true);
            o.output(model, t1, "", 0.0, true);
        }
        else{
            o.output(model, t1, "\"I'll come back later\"", 0.0, true);
        }

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
