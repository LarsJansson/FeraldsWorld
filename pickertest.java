import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.awt.event.*;

public class pickertest{
    int key;
    int dx;
    public void run(){
        System.out.print("^");
        Scanner m = new Scanner(Console.in);
        while(true){ //
            String key = m.nextLine();
            if(key != null){
                System.out.println(key);
            }
        }
    }
}
