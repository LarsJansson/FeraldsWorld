import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.*;

public class Output{
    public static final String RESET    = "\u001B[0m";
    public static final String RED      = "\u001B[31m";     //1
    public static final String GREEN    = "\u001B[32m";     //2
    public static final String YELLOW   = "\u001B[33m";     //3
    public static final String BLUE     = "\u001B[34m";     //4
    public static final String PURPLE   = "\u001B[35m";     //5
    public static final String CYAN     = "\u001B[36m";     //6
    public static final String WHITE    = "\u001B[37m";     //7


    public void output(){
        System.out.println("Output> No string provided");
    }
    public void output(String str) throws Exception{
        System.out.println(str);
    }
    public void output(String str, double bd, double ad, boolean remove) throws Exception{
        TimeUnit.SECONDS.sleep((long) bd);
        if(remove){
            System.out.print("\r                                                             ");
            System.out.print("\r"+str);
        }else{
            System.out.print(str);
        }
        TimeUnit.SECONDS.sleep((long) ad);
    }
    public void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void clearGUI(JTextPane tp){
        tp.setText("");
    }

   public void outputC(String str, double bd, double ad, boolean remove, int color) throws Exception{
        String pickedColor = "";
        if(color == 1)
            pickedColor = RED;
        else if(color == 2)
            pickedColor = GREEN;
        else if(color == 3)
            pickedColor = YELLOW;
        else if(color == 4)
            pickedColor = BLUE;
        else if(color == 5)
            pickedColor = PURPLE;
        else if(color == 6)
            pickedColor = CYAN;
        else if(color == 7)
            pickedColor = WHITE;
        else
            pickedColor = "";

        TimeUnit.SECONDS.sleep((long) bd);
        if(remove){
            System.out.print("\r                                                             ");
            System.out.print("\r"+pickedColor+str+RESET);
        }else{
            System.out.print(pickedColor+str+RESET);
        }
        TimeUnit.SECONDS.sleep((long) ad);
    }
    public void outputGUI(JTextPane tp, String s, double bd, double ad, boolean remove) throws Exception{
        String oldText = "";
        if (remove){
            oldText = "";
        }else{
            oldText = tp.getText();
        }
        TimeUnit.MILLISECONDS.sleep((long) bd);
        tp.setText(oldText + s);
        TimeUnit.MILLISECONDS.sleep((long) ad);
    }
    public void outputGUIS(JTextPane tp, String s) throws Exception{
        clear();
        tp.setText("");
        String[] splitString = s.split("");
        for (String character : splitString){
            TimeUnit.MILLISECONDS.sleep(150);
            tp.setText(tp.getText() + character);
        }
    }

}
