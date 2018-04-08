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
        boolean quest1runs = true;
        
        while(quest1runs){
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
                picker.pickOption(t1, options, hints, pickerPosition, "Where do you want do go?\n");
                inputPanel.setText(options[pickerPosition]);
            }
            inputPanel.setText("");model.setInput("");
            String choice = options[pickerPosition];
            
            switch(choice){
                case "North": if(hero.getXp() < 50){
                                  o.output(t1,"The forest looks pretty creepy for a "+hero.getGenderL()+" "+hero.getRaceL()+".\nYou need at least 50 XP!",0.0,3000*speed,true);
                              }
                              else{
                                  o.output(t1,"Woodquest! Yeah baby!",0.0,3000*speed,true);       
                              }
                              break;
                case "South": if(inv.search(t2,"Pants"))
                                o.output(t1,"Pants",0.0,3000*speed,true);
                              else
                                  o.output(t1,"\"Maybe I should find me a pair of pants before I get out of these woods.",0.0,4000*speed,true);
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
}
