import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;


public class Frame extends JFrame{
    public Frame(){
        super("Untitled Frame");
        setBounds(300,50,900,600);
    }

    public Frame(String str){
        super(str);
        setBounds(300,50,900,600);
    }
}
