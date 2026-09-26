import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class jRadioButton extends JFrame {
    JLabel j1= new JLabel("Gender");
    JRadioButton jrb1 =new JRadioButton("Male");
    JRadioButton jrb2 =new JRadioButton("Female");

    public jRadioButton(){
        setBounds(50,50,500,500);
        
        j1.setBounds(30,50,100,50);
        jrb1.setBounds(30,110,100,50);
        jrb2.setBounds(30,170,100,50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jrb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(jRadioButton.this, "Genger : Male");
            }
        });

        jrb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(jRadioButton.this, "Genger : Female");
            }
        });


        setLayout(null);
        setVisible(true);
        add(jrb1);
        add(jrb2);
        add(j1);
    }


    public static void main(String[] args) {
        new jRadioButton();
    }

}
