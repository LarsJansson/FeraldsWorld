import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class Quest1 extends TheGame{
    public void run(Inventory inv, Stats stats, Hero hero) throws Exception{
        inputPanel.addActionListener(al);
        inputPanel.addKeyListener(kl);
        bill.build(frame, inputPanel, textPanel, t1, t2, t3);
        inputPanel.grabFocus(); 
        stats.updateStats(t3, hero);
        //o.outputGUIH(t1,"Quest 1 begins...", 0.0, 0.0, true, Color.RED);
        o.output(t1,"As your other sences starts to return, you finally\nmanage to get up on your feet",0.0,3000*speed,true);
        o.output(t1,"After removing the twig from your butt you take a look around.",0.0,3000*speed,true);
        o.output(t1,"To the north the forest only seem to be thickening.",0.0,3000*speed,true);
        o.output(t1,"Turning around, looking south, the forest seem to open up a bit.",0.0,3000*speed,true);
        o.output(t1,"When you look to the east, you see something between the trees.",0.0,3000*speed,true);
        o.output(t1,"\nIt looks like the contours of small cabin or something!",0.0,3000*speed,false);
        o.output(t1,"In the other direction there is a small path leading further into the woods.",0.0,3000*speed,true);
        o.output(t1,"Where do you want do go?",0.0,0.0,true);
        
        hero.xpInc(1000);
        stats.updateStats(t3, hero);
        
        Picker picker = new Picker();
        String[] options = {"North", "South", "East", "West"};
        String[] hints = {"Thick Forest", "Opening", "Small cabin?", "Small path"};
        pickerPosition = 0;
        while(model.getInput().equals("")){
            Thread.sleep(50);
            if(pickerPosition > options.length - 1)
                pickerPosition = 0;
            if(pickerPosition < 0)
                pickerPosition = options.length - 1;
            picker.pickOption(t1, options, hints, pickerPosition, "Where do you want do go?");
            inputPanel.setText(options[pickerPosition]);
        }
        inputPanel.setText("");model.setInput("");
        String choice = options[pickerPosition];
        
        switch(choice){
            case "North": if(hero.getXp() < 50){
                              o.output(t1,"The forest looks pretty creepy for a "+hero.getGender()+" "+hero.getRace()+".\nYou need at least 50 XP",3000*speed,3000*speed,true);
                          }
                          else{
                              o.output(t1,"Woodquest! Yeah baby!",0.0,3000*speed,true);       
                          }
                          break;
            case "South": o.output(t1,"",0.0,0.0,true);
                          break;
             case "East": o.output(t1,"",0.0,0.0,true);
                          break;
             case "West": o.output(t1,"",0.0,0.0,true);
                          break;
                 default: break;
        }
        stats.updateStats(t3, hero);
        super.hero = hero;
    }
}
