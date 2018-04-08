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
            String[] hints = {"Woods", "Opening", "Small cabin?", "Narrow path"};
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
                                  o.outputSlowQuote(t1,"I have a bad feeling about this...",0.0,3000*speed,100*speed,true);
                                  o.output(model, t1,"The dark forest looks pretty creepy for a "+hero.getGenderL()+" "+hero.getRaceL()+".\nYou need at least 50 XP!",0.0,true);
                              }
                              else{
                                  o.output(model, t1,"WOOD-QUEST --> ?+XP",0.0,true);       
                              }
                              break;
                case "South": if(inv.search(t2,"Pants")){
                                  o.output(model, t1,"OPENING_QUEST",0.0,true);
                              }
                              else
                                  o.outputSlowQuote(t1,"Maybe I should find me a pair of pants before I get out of these woods.",0.0,4000*speed,100*speed,true);
                              break;
                 case "East": if(inv.search(t2,"Shoes")){
                                  o.output(model, t1,"WELCOME BACK!",0.0,true);
                              }
                              else{
                                  frame.setVisible(false);
                                  Quest1cabin q1c = new Quest1cabin();
                                  q1c.run(inv,stats,hero);
                                  stats.updateStats(t3,hero);
                                  inv.update(t2);
                                  frame.setVisible(true);
                              }
                              break;
                 case "West": if(inv.search(t2,"Shoes")){
                                  o.output(model, t1,"PATH-QUEST --> PANTS+XP",0.0,true);
                              }
                              else{
                                  o.output(model, t1,"\"Ouch!\"",0.0,true);
                                  o.output(model, t1,"The rocky floor of the path hurt against your naked feet.",0.0,true);
                                  o.outputSlowQuote(t1,"I'm not taking one more step until I find some shoes...",0.0,4000*speed,100*speed,true);
                              }
                              break;
                     default: break;
            }
            stats.updateStats(t3, hero);
            super.hero = hero;
        }
    }
}
