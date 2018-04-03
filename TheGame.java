import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.*;

public class TheGame
{
    public static void main(String[] args) throws Exception
    {
        int i = 0;
        while(i != 1)
        {
            output("test");
            System.out.println("Press START (or enter \"1\" if playing on a computer) to begin");
            Scanner ans = new Scanner(System.in);
            i = ans.nextInt();
            if(i == 1)
            {
                System.out.print("\nWelcome to FERALD'S WORLD!");
                TimeUnit.SECONDS.sleep(4);
                System.out.print("\r                                                      ");
                System.out.print("\rBefore the adventure can begin you must choose a hero!");
                TimeUnit.SECONDS.sleep(4);
                System.out.print("\r                                                      ");
                System.out.print("\rFirst, pick a RACE.");
                TimeUnit.SECONDS.sleep(3);
                System.out.print("\r                                                      ");
                System.out.print("\rHuman?");
                TimeUnit.SECONDS.sleep(2);
                System.out.print("\r                                                      ");
                System.out.print("\rOrch?");
                TimeUnit.SECONDS.sleep(2);
                System.out.print("\r                                                      ");
                System.out.print("\rElf?");
                TimeUnit.SECONDS.sleep(2);
                System.out.print("\r                                                      ");
                System.out.print("\rOooooor...");
                TimeUnit.SECONDS.sleep(4);
                System.out.print("\r                                                      ");
                System.out.print("\rDwarf?");
                TimeUnit.SECONDS.sleep(3);
                System.out.print("\r                                                      ");
                System.out.println("\rSince you're playing on a computer, choose a RACE by");
                System.out.println("entering \"1\" (Human), \"2\" (Orch), \"3\" (Elf) or \"4\" (Dwarf):");
                Scanner ansRace = new Scanner(System.in);
                int Race = ansRace.nextInt();
                
                if(Race == 1)
                {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("\nOh... A fancy human again. Oh well, to choose gender,\nenter a number between 1 and 10:");
                    Scanner ansGender = new Scanner(System.in);
                    int Gender = ansGender.nextInt();
                    if(true)
                    {
                        TimeUnit.SECONDS.sleep(3);
                        System.out.print("\nOk, this won't do...");
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("\rPlease choose either male (\"1\"), female (\"2\") or transgender (\"3\")!");
                        Scanner ansNewGender = new Scanner(System.in);
                        int NewGender = ansNewGender.nextInt();
                        String gender;
                        if(NewGender == 1)
                        {
                            gender = "MALE";
                        }
                        else if(NewGender == 2)
                        {
                            gender = "FEMALE";
                        }
                        else
                        {
                            gender = "TRANSGENDER";
                        }
                        TimeUnit.SECONDS.sleep(3);
                        System.out.print("\nOk. Now the game can finally begin!");
                        TimeUnit.SECONDS.sleep(3);
                        System.out.print("\r                                                      ");
                        System.out.println("\rWait! Whats your name?");
                        Scanner name = new Scanner(System.in);
                        String Name = name.next();
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println(String.format("\nYou have choosen to play as %s the "+gender+" HUMAN",Name)); 
                    }
                }
            }
        }
    }
}
