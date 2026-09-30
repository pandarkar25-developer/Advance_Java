import javax.swing.*;
import java.awt.*;


public class gridBagLayout extends JFrame {
    
    public gridBagLayout(){
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout gb = new GridBagLayout();
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=0.5;

        setLayout(gb);
        gbc.fill=2;
        setBounds(30,30,600,600);

        add(new JButton("1"),gbc);
        
       
        gbc.gridx=1;
        gbc.gridy=0;
        add(new JButton("2"),gbc);
        gbc.gridx=2;
        gbc.gridy=0;
        add(new JButton("3"),gbc);
        
        gbc.gridwidth=3;
        gbc.ipady=30;
        gbc.gridx=0;
        gbc.gridy=1;
        
        add(new JButton("4"),gbc);

        
        

        gbc.gridwidth=2;
        gbc.ipady=0;
        gbc.anchor=20;
        gbc.weighty=1;
        
        gbc.gridx=1;
        gbc.gridy=3;
        add(new JButton("2"),gbc);
        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
    }

    public static void main(String[] args) {
        new gridBagLayout();
    }
}
