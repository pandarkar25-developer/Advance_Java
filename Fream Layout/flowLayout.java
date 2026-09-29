import javax.swing.*;
import java.awt.*;

public class flowLayout extends JFrame {

    flowLayout() {
        setTitle("FlowLayout Example");
        setSize(400, 300);
        setLayout(new FlowLayout());


        for(int i=0;i<=100; i++)
            add(new JButton("Button "+i));

        
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new flowLayout();
    }
}