import javax.swing.*;
import java.awt.event.*;

public class jTextArea extends JFrame {
    JButton b1 = new JButton("Enter");
    JTextField textField1= new JTextField();
    JTextArea l1 = new JTextArea();
    

    public jTextArea(){
        

        setBounds(100,100,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        textField1.setBounds(50,60,100,40);
        JLabel jl1 = new JLabel("User Name");
        jl1.setBounds(50,30,100,20);

        l1.setBounds(50,140,200,20);
        
        b1.setBounds(50,100,100,40);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                l1.setText(textField1.getText());
            }
        } );
        add(jl1);
        add(textField1);
        add(b1);
        add(l1);


        setVisible(true);
        
    }

    

    

    public static void main(String[] args) {
        new jTextArea();

        
    }

}
