import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class Quest1path extends TheGame{
    public void run(Inventory inv, Stats stats, Hero hero) throws Exception{
        inputPanel.addActionListener(al);
        inputPanel.addKeyListener(kl);
        bill.build(frame, inputPanel, textPanel, t1, t2, t3);
        inputPanel.grabFocus();
        stats.updateStats(t3, hero);

        o.output(model, t1, "Path Quest",0.0, true);
        //o.outputSlowQuote(model, t1, "Maybe I can find some clothes here...", 0.0, 100*speed, true);
        
        boolean q1cruns = true;

        while(q1cruns){
            //Picker picker = new Picker();
            //String[] options = {"Go sneaky peeky", "Rush forward", "Turn back"};
            //String[] hints = {"", "", ""};
            //pickerPosition = 0;
            //while(model.getInput().equals("")){
            //    Thread.sleep(50);
            //    if(pickerPosition > options.length - 1)
            //        pickerPosition = 0;
            //    if(pickerPosition < 0)
            //        pickerPosition = options.length - 1;
            //    picker.pickOption(t1, options, hints, pickerPosition, "How do you wish to approach?\n");
            //    inputPanel.setText(options[pickerPosition]);
            //}
            //inputPanel.setText("");model.setInput("");
            //String choice = options[pickerPosition];

            q1cruns = false;
        }
        stats.updateStats(t3, hero);
        super.hero = hero;
        super.inv = inv;
        super.stats = stats;
        frame.dispose();
    }
}
