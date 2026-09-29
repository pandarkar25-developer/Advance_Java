import java.awt.GridLayout;
import javax.swing.*;

public class gridLayout extends JFrame{

    public gridLayout(){
        setLayout(null);
        setBounds(50,50,500,500);
        JPanel j1 = new JPanel();

        j1.setBounds(30,30,200,200);

        
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");
        JButton b3 = new JButton("Button 3");
        JButton b4 = new JButton("Button 4");

        b1.setBounds(30,30,50,50);

        GridLayout g =new GridLayout(2,2);
        g.setVgap(10);
        g.setHgap(10);

        j1.setLayout(g);

        j1.add(b1);
        j1.add(b2);
        j1.add(b3);
        j1.add(b4);
        add(j1);
        setVisible(true);
    }

    public static void main(String[] args) {
        new gridLayout();
    }
}