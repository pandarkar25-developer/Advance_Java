import java.awt.*;

import javax.swing.*;

public class borderLayout extends JFrame{
    public borderLayout(){
        setTitle("FlowLayout Example");
        setSize(400, 300);
        setLayout(new BorderLayout());


        add(new JButton(" ^ "),BorderLayout.NORTH);
        add(new JButton(" v "),BorderLayout.SOUTH);
        add(new JButton(" > "),BorderLayout.EAST);
        add(new JButton(" < "),BorderLayout.WEST);
        add(new JButton(" Enter "),BorderLayout.CENTER);


            

        
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new borderLayout();
    }
}
