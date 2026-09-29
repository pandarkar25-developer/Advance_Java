import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class jComboBox2 extends JFrame {
    
    public jComboBox2(){

        setBounds(50,50,500,500);
        setTitle("Languages");
        setLayout(null);
        JComboBox<String> jcb =new JComboBox<String>();

        setBackground(new Color(168, 187, 163));

        jcb.addItem("Java");
        jcb.addItem("C++");
        jcb.addItem("Python");
        jcb.addItem("Go");

        jcb.setBounds(30,30,100,40);
        jcb.setBackground(Color.LIGHT_GRAY);
        add(jcb);

        jcb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                jcb.setBackground(new Color(252, 249, 234));
                jcb.setForeground(new Color(151, 168, 122));
                JOptionPane.showMessageDialog(jComboBox2.this,jcb.getSelectedItem());
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new jComboBox2();
    }
}