import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class Quest_Beginning extends TheGame{
    private final Frame frame;
    private JPanel panel;
    public Quest_Beginning(final Frame frame){
        this.frame = frame;
        inputPanel.addActionListener(al);
        inputPanel.addKeyListener(kl);
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        bill.build(panel, inputPanel, textPanel, t1, t2, t3);
        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public void run(Inventory inv, Stats stats, Hero hero) throws Exception{
        inputPanel.grabFocus(); 
        stats.updateStats(t3, hero);
        boolean q_bruns = true;

        while(q_bruns){
            stats.updateStats(t3, hero);
            
            Picker picker = new Picker();
            String[] options = {"North", "South", "East", "West"};
            String[] hints = {"(Darkness)", "(Leave forest)", "(Forest cabin)", "(Follow path)"};
            String question = "Where do you want to go?";
            picker.pick(model, t1, options, hints, question, inputPanel);
            String choice = options[model.getPosition()];

            if(choice == "North"){
                if(hero.getXp() < 50){
                    o.output(model, t1, "\"I have a bad feeling about this...\"", 0.0, true);
                    o.output(model, t1, "The dark forest looks pretty creepy for a "+hero.getGenderL()+" "+hero.getRaceL()+".\nYou need at least 50 XP!", 0.0, true);
                }
                else{
                    o.output(model, t1, "WOOD-QUEST --> ?+XP", 0.0, true);       
                }
            }
            else if(choice == "South"){
                if(inv.search(t2, "Pants")){
                    o.output(model, t1, "OPENING_QUEST", 0.0, true);
                }
                else
                    o.output(model, t1, "\"Maybe I should find me a pair of pants before I get out of these woods.\"", 0.0, true);
            }
            else if(choice == "East"){
                if(inv.search(t2, "Shoes") && hero.getXp() > 50){
                    o.output(model, t1, "Now you have a small key maybe?", 0.0, true);
                }
                else if(inv.search(t2, "Shoes") && hero.getXp() < 50)
                    o.output(model, t1, "\"I shouldn't bother that nice old lady any more tonight...\"", 0.0, true);
                else{
                    Quest_Cabin q_c = new Quest_Cabin(frame);
                    q_c.run(inv,stats,hero);
                    frame.setContentPane(panel);
                    inputPanel.grabFocus(); 
                    stats.updateStats(t3,hero);
                    inv.update(t2);
                }
            }
            else if(choice == "West"){
                if(inv.search(t2,"Shoes")){
                    Quest_Path q_p = new Quest_Path(frame);
                    q_p.run(inv,stats,hero);
                    frame.setContentPane(panel);
                    inputPanel.grabFocus(); 
                    stats.updateStats(t3,hero);
                    inv.update(t2);
                }
                else{
                    o.output(model, t1, "\"Ouch!\"", 0.0, true);
                    o.output(model, t1, "The stoney soil hurt against your naked feet.", 0.0, true);
                    o.output(model, t1, "I'm not taking one more step until I find some shoes...", 0.0, true);
                }
            }
            stats.updateStats(t3, hero);
            super.hero = hero;
        }
    }
}
