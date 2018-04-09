import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class Quest_Cabin extends TheGame{
    private final Frame frame;
    public Quest_Cabin(final Frame frame){
        this.frame = frame;
        inputPanel.addActionListener(al);
        inputPanel.addKeyListener(kl);
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        bill.build(panel, inputPanel, textPanel, t1, t2, t3);
        frame.add(panel);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }




    public void run(Inventory inv, Stats stats, Hero hero) throws Exception{
        inputPanel.grabFocus();
        stats.updateStats(t3, hero);
        boolean q_cruns = true;

        o.output(model, t1, "As you get closer the dark contours emerges to the shape of a small cabin.", 0.0, true);
        o.outputSlowQuote(model, t1, "Maybe I can find some clothes here...", 0.0, 100*speed, true);     

        while(q_cruns){
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
                picker.pickOption(t1, options, hints, pickerPosition, "How do you wish to approach?");
                inputPanel.setText(options[pickerPosition]);
            }
            inputPanel.setText("");
            model.setInput("");
            String choice = options[pickerPosition];

            if(choice == "Go sneaky peeky"){
                o.output(model, t1, "You try to use the trees as cover as you move in closer.", 0.0, true);
                o.output(model, t1, "Almost there... You crouch down behind a bush to take a closer look.\nYou don't see any lights in any of the windows.", 0.0, true);
                o.outputSlowQuote(model, t1, "Maybe no one is home...", 0.0, 70*speed, true);
                o.output(model, t1, "You leave your cover and sneak up to one of the windows.", 0.0, true);
                o.output(model, t1, "As you look inside, a light is turned on!", 0.0, true);
                o.output(model, t1, "Quickly you crouch down beneath the window!", 0.0, true);
                o.output(model, t1, "Someone is walking inside!", 0.0, true);
                o.outputSlowQuote(model, t1, "Hello!?", 0.0, 70*speed, true);
                o.output(model, t1, "It's the voice of an old woman.", 0.0, true);
                o.outputSlowQuote(model, t1, "Someone out there?", 0.0, 70*speed, true);
                o.outputSlowQuote(model, t1, "...", 0.0, 70*speed, true);
                o.output(model, t1, "For a second you completely forget the fact that you're naked.", 0.0, true);
                o.outputSlowQuote(model, t1, "It's only me, "+hero.getName()+"!", 0.0, 70*speed, true);
                o.output(model, t1, "A moment of silence is followed by the door opening.\nThe old woman takes a good hard look at you.", 0.0, true);
                o.outputSlowQuote(model, t1, "What in the name of god is a "+hero.getGenderL()+" "+hero.getRaceL()+" doing\nout here in the middle of the night!?", 0.0, 70*speed, true);
                o.output(model, t1, "You try your best to answer.", 0.0,  true);
                o.outputSlowQuote(model, t1, "I have no idea! I woke up out here like this!\nPlease, do you have any clothes that I can borrow?\nAnything will do!", 0.0, 70*speed, true);
                o.output(model, t1, "The old women looks at you with sadness in her eyes.", 0.0, true);
                o.outputSlowQuote(model, t1, "Let me see what I can find. Come inside and warm yourself\nwhile I take a look in the basement.", 0.0, 70*speed, true);
                o.output(model, t1, "Once inside she invites you to have a seat in a rocking chair.\nYou use a pillow to cover your private parts. She closes the door\nbehind you, then takes off down a tiny staircase.", 0.0, true);
                o.output(model, t1, "You look around you.", 0.0, true);
                o.output(model, t1, "On the other side of the room there's a framed picture standing on a bureau.", 0.0, true);
                o.output(model, t1, "You walk over for a closer look.", 0.0, true);
                o.output(model, t1, "It looks like an old family portrait. A mother, a father and three young children.\nThe photograph must be at least 60 years old, because you recognize\nthe young mother as the old woman living here now.", 0.0, true);
                o.outputSlowQuote(model, t1, "I wonder what happened to them...", 0.0, 70*speed, true);
                o.output(model, t1, "Next to the bureau, there's a SMALL CHEST standing on the floor!", 0.0, true);
                
                String[] options2 = {"Yes", "No"};
                String[] hints2 = {"", ""};
                pickerPosition = 0;
                while(model.getInput().equals("")){
                    Thread.sleep(50);
                    if(pickerPosition > options2.length - 1)
                        pickerPosition = 0;
                    if(pickerPosition < 0)
                        pickerPosition = options2.length - 1;
                    picker.pickOption(t1, options2, hints2, pickerPosition, "Try to open it?");
                    inputPanel.setText(options2[pickerPosition]);
                }
                inputPanel.setText("");model.setInput("");
                String choice2 = options2[pickerPosition];
                if(choice2 == "Yes"){
                    if(inv.search(t2, "SMALL KEY"))
                        o.output(model, t1, "Here's some nice stuff!", 0.0, true);
                    else
                        o.output(model, t1, "You need a SMALL KEY to open this chest.", 0.0, true);
                }
                o.output(model, t1, "You hear the old lady coming back upstairs.", 0.0, true);
                if(hero.isMale()){
                    SmallShoes ss = new SmallShoes();
                    o.outputSlowQuote(model, t1, "I didn't find anything except for these old shoes. They might be\ntoo small for a "+hero.getGenderL()+", but please accept them as a gift!", 0.0, 70*speed, true);
                    o.output(model, t1, "Nice! Added TINY SHOES to the inventory!", 0.0, true);
                    inv.add(t2, ss);
                }else if(hero.isFemale()){
                    LargeShoes ls = new LargeShoes();
                    o.outputSlowQuote(model, t1, "I didn't find anything except for these old shoes. They might be\ntoo big for a "+hero.getGenderL()+", but please accept them as a gift!", 0.0, 70*speed, true);
                    o.output(model, t1, "Nice! Added HUGE SHOES to the inventory!", 0.0, true);
                    inv.add(t2, ls);
                }else{
                    NormieShoes ns = new NormieShoes();
                    o.outputSlowQuote(model, t1, "I didn't find anything except for these old shoes. They should be\nperfect for a "+hero.getGenderL()+". Please accept them as a gift!", 0.0, 70*speed, true);
                    o.output(model, t1, "Although not fit for a tranny, you decide to keep these non glittery shoes.", 0.0, true);
                    o.output(model, t1, "Nice! Added NORMAL SHOES to the inventory!", 0.0, true);
                    inv.add(t2, ns);
                }   
                    o.outputSlowQuote(model, t1, "I better get going now. Thank you so much for your help!", 0.0, 70*speed, true);
                    o.output(model, t1, "Gained 1 xp!", 0.0, true);
                    q_cruns = false;
                    hero.xpInc(1);
                    stats.updateStats(t3, hero);
                }
                else if(choice == "Rush forward"){
                    o.output(model, t1, "\"Ouch!\"", 0.0, true);
                    o.output(model, t1, "Running with bare feet out here is a bad idea...", 0.0, true);
                }
                else{
                    o.output(model, t1, "\"I'll come back later.\"", 0.0, true);
                    q_cruns = false;
                }
        }
        stats.updateStats(t3, hero);
        super.hero = hero;
        super.inv = inv;
        super.stats = stats;
    }
}
