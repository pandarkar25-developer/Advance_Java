import javax.swing.*;

import java.awt.Color;
import java.awt.Event;
import java.awt.event.*;

public class jPanel extends JFrame{
    JPanel jp = new JPanel();
    JButton jb = new JButton("Enter");

    public jPanel(){
        setBounds(50,50,500,500);
        jp.setBounds(30,90,200,200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        

        add(jp);
        add(jb);
        jp.setVisible(false);
        jp.setLayout(null);
        jp.setBackground(Color.LIGHT_GRAY);

        jb.setBounds(20,20,100,50);
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(jPanel.this,"Button Press");
                
                jp.setVisible(true);
            }
        });
        
        setVisible(true);

    }

    public static void main(String[] args) {
        new jPanel();
    }
}
