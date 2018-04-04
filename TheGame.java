import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.*;

public class TheGame
{
    Output o = new Output();
    Hero hero = new Hero();
    public void run() throws Exception
    {
        double speed = 1;
        int i = 0;
        while(i != 1)
        {
            o.clear();
            o.output("\nPress START (or enter \"1\" if playing on a computer) to begin\n",0.0,0.0,false);
            Scanner ans = new Scanner(System.in);
            try
            {
                i = ans.nextInt();
            }
            catch(Exception e)
            {
                o.clear();
                o.output("\nI'll take that as a 1!",0.0,4.0*speed,true);
                i = 1;
            }
            if(i == 1)
            {
                o.clear();
                o.output("\nWelcome to FERALDS'S WORLD!",0.0,4.0*speed,false);
                o.output("Before the adventure can begin you must choose a hero!",0.0,4.0*speed,true);
                o.output("First, pick a RACE.",0.0,3.0*speed,true);
                o.output("Human?",0.0,2.0*speed,true);
                o.output("Orch?",0.0,2.0*speed,true);
                o.output("Elf?",0.0,2.0*speed,true);
                o.output("Oooor...",0.0,3.0*speed,true);
                o.output("Dwarf?",0.0,3.0*speed,true);
                o.output("Since you're playing on a computer, choose a RACE by\nentering \"1\" (Human), \"2\" (Orch), \"3\" (Elf) or \"4\" (Dwarf):\n",0.0,0.0,true);
                Scanner ansRace = new Scanner(System.in);
                int Race = ansRace.nextInt();
                if(Race == 1)
                {
                    hero.setRace("Human");
                    o.clear();
                    o.output("\nOh... A fancy human again. Oh well, to choose gender,\nenter a number between 1 and 10:\n",2.0*speed,0.0,true);
                    Scanner ansGender = new Scanner(System.in);
                    int Gender = ansGender.nextInt();
                    if(true)
                    {
                        o.clear();
                        o.output("\nOk, this won't do...",3.0*speed,2.0*speed,false);
                        o.output("Please choose either male (\"1\"), female (\"2\") or transgender (\"3\")!\n",0.0,0.0,true);
                        Scanner ansNewGender = new Scanner(System.in);
                        int NewGender = ansNewGender.nextInt();
                        String gender;
                        if(NewGender == 1)
                        {
                            gender = "MALE";
                            hero.setGender("Male");
                        }
                        else if(NewGender == 2)
                        {
                            gender = "FEMALE";
                            hero.setGender("Female");
                        }
                        else
                        {
                            gender = "TRANSGENDER";
                            hero.setGender("Transgender");
                        }
                        o.clear();
                        o.output("\nOk. Now the game can finally begin!",3.0*speed,3.0*speed,false);
                        o.output("Wait!",0.0,2.0*speed,true);
                        o.output("Whats your name?\n",0.0,0.0,true);
                        Scanner name = new Scanner(System.in);
                        String Name = name.next();
                        hero.setName(Name);
                        o.clear();
                        o.output("\nYou have choosen to play as "+hero.getNameU(1)+", the "+hero.getGenderU(1)+" "+hero.getRaceU(1)+"\n",3*speed,4*speed,true);
                    }
                }
                o.clear();
                o.outputS("\nOnce upon a time there was a very nice text based game.\nIt was the best game ever designed by two human beings.\nPlus it had this awesome text feature!\n");
            }
        }
    }
}
