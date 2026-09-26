import javax.swing.*;
import java.awt.event.*;

public class jComboBox extends JFrame implements ActionListener {
    JComboBox <String>JC =new JComboBox<String>();
    JLabel j1= new JLabel("Gender");
    

    public jComboBox(){
        setBounds(50,50,500,500);
        j1.setBounds(30,30,100,40);
        JC.setBounds(30,80,100,50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JC.addItem("Male");
        JC.addItem("Female");


        JC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String s =(String) JC.getSelectedItem();

                JOptionPane.showMessageDialog(jComboBox.this,s);
            }
        });

        


        setLayout(null);
        setVisible(true);

       
        add(j1);
        add(JC);
    }
    
    public void actionPerformed(ActionEvent e ){

    }

    public static void main(String[] args) {
        new jComboBox();
    }
}
