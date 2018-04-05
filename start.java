import javax.swing.*;

public class start{
    public static void main(String[] args) throws Exception{
        JFrame frame = new Frame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TheGame g = new TheGame();
        g.run();
    }
}
