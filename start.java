import javax.swing.*;
import java.awt.*;

public class start{
    public static void main(String[] args) throws Exception{
        JFrame frame = new Frame("FERALDS WORLD");
        frame.setVisible(true);
        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        TheGame g = new TheGame();
        g.run(frame);
    }
}
