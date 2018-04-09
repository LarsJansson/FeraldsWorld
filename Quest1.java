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
            stats.updateStats(t3, hero);
            Picker picker = new Picker();
            String[] options = {"North", "South", "East", "West"};
            String[] hints = {"(Darkness)", "(Leave forest)", "(Forest cabin)", "(Follow path)"};
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
                                  o.output(model, t1,"\"I have a bad feeling about this...\"",0.0,true);
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
                                  o.output(model, t1,"\"Maybe I should find me a pair of pants before I get out of these woods.\"",0.0,true);
                              break;
                 case "East": if(inv.search(t2,"Shoes") && hero.getXp()>50){
                                  o.output(model, t1,"Now you have a small key maybe?",0.0,true);
                              }
                              else if(inv.search(t2,"Shoes") && hero.getXp()<50){
                                  o.output(model,t1,"\"I shouldn't bother that nice old lady any more tonight...\"",0.0,true);
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
                                  o.output(model,t1,"\"This feels much better! I'm so glad I have these shoes!\"",0.0,true); //getItem(huge...)
                                  o.output(model,t1,"You start to follow the path into the woods.",0.0,true);
                                  o.output(model,t1,"To make the forest seem less intimidating you start to sing a bit to yourself.",0.0,true);
                                  o.outputSlowQuote(model,t1,"I'm walking down on this path.",0.0,70*speed,true);
                                  o.outputSlowQuote(model,t1,"\nAbsorbed by the woods and its wrath.",0.0,70*speed,false);
                                  if(hero.isTransgender() && hero.isOrch()){
                                      o.outputSlowQuote(model,t1,"\nA transgender orc,",0.0,70*speed,false); 
                                      o.outputSlowQuote(model,t1,"\nmight feel like a dork,",0.0,70*speed,false);    
                                  }
                                  else if(hero.isMale() && hero.isOrch()){
                                      o.outputSlowQuote(model,t1,"\nA masculin orc,",0.0,70*speed,false); 
                                      o.outputSlowQuote(model,t1,"\nmight feel like a dork,",0.0,70*speed,false);    
                                  }
                                  else if(hero.isFemale() && hero.isOrch()){
                                      o.outputSlowQuote(model,t1,"\nA feminin orc,",0.0,70*speed,false); 
                                      o.outputSlowQuote(model,t1,"\nmight feel like a dork,",0.0,70*speed,false);    
                                  } 
                                  else if(hero.isTransgender() && hero.isHuman()){
                                      o.outputSlowQuote(model,t1,"\nA transgender being,",0.0,70*speed,false); 
                                      o.outputSlowQuote(model,t1,"\nwet from self peeing,",0.0,70*speed,false);    
                                  } 
                                  else if(hero.isMale() && hero.isHuman()){
                                      o.outputSlowQuote(model,t1,"\nA masculin guy,",0.0,70*speed,false); 
                                      o.outputSlowQuote(model,t1,"\nso scared he might die,",0.0,70*speed,false);    
                                  } 
                                  else if(hero.isFemale() && hero.isHuman()){
                                      o.outputSlowQuote(model,t1,"\nA feminin girl,",0.0,70*speed,false); 
                                      o.outputSlowQuote(model,t1,"\n'bout ready to hurl,",0.0,70*speed,false);    
                                  } 
                                  else if(hero.isTransgender() && hero.isElf()){
                                      o.outputSlowQuote(model,t1,"\nA transgender elf,",0.0,70*speed,false); 
                                      o.outputSlowQuote(model,t1,"\nwho just peed one self,",0.0,70*speed,false);    
                                  } 
                                  else if(hero.isMale() && hero.isElf()){
                                      o.outputSlowQuote(model,t1,"\nA masculin elf,",0.0,70*speed,false); 
                                      o.outputSlowQuote(model,t1,"\nwho just peed himself,",0.0,70*speed,false);    
                                  } 
                                  else if(hero.isFemale() && hero.isElf()){
                                      o.outputSlowQuote(model,t1,"\nA feminin elf,",0.0,70*speed,false); 
                                      o.outputSlowQuote(model,t1,"\nwho just peed herself,",0.0,70*speed,false);    
                                  } 
                                  else if(hero.isTransgender() && hero.isDwarf()){
                                      o.outputSlowQuote(model,t1,"\nA midget transgender,",0.0,70*speed,false); 
                                      o.outputSlowQuote(model,t1,"\nabout to surrender,",0.0,70*speed,false);    
                                  } 
                                  else if(hero.isMale() && hero.isDwarf()){
                                      o.outputSlowQuote(model,t1,"\nThough bearded and strong",0.0,70*speed,false); 
                                      o.outputSlowQuote(model,t1,"\nhe's not very long,",0.0,70*speed,false);    
                                  } 
                                  else if(hero.isFemale() && hero.isDwarf()){
                                      o.outputSlowQuote(model,t1,"\nGirly and short,",0.0,70*speed,false); 
                                      o.outputSlowQuote(model,t1,"\nyou consider abort,",0.0,70*speed,false);    
                                  } 
                                  o.outputSlowQuote(model,t1,"\nlonging for home and a bath!",0.0,70*speed,false);
                              }
                              else{
                                  o.output(model, t1,"\"Ouch!\"",0.0,true);
                                  o.output(model, t1,"The stoney soil hurt against your naked feet.",0.0,true);
                                  o.output(model, t1,"I'm not taking one more step until I find some shoes...",0.0,true);
                              }
                              break;
                     default: break;
            }
            stats.updateStats(t3, hero);
            super.hero = hero;
        }
    }
}
