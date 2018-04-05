import javax.swing.*;

public class Frame extends JFrame{
    public Frame(){
        super("Untitled Frame");
        setBounds(0,0,300,300);
    }

    public Frame(String str){
        super(str);
        setBounds(0,0,300,300);
    }
}
