import  javax.swing.*;
import java.awt.event.*;

public class jCheckBox extends JFrame implements ActionListener{

    JCheckBox JCB = new JCheckBox();
    public jCheckBox(){
        setBounds(50,50,500,500);
        setLayout(null);
        setTitle("JCheckBox");

        
        JCB.setBounds(30,50,200,50);
        add(JCB);
        JCB.setText("Prasanna");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JCB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(JCB.isSelected()){
                    JOptionPane.showMessageDialog(jCheckBox.this, "Selected");
                }else{
                    JOptionPane.showMessageDialog(jCheckBox.this, "Not Selected");
                }
                
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        
    }

    public static void main(String[] args) {
        new jCheckBox();
    }
}
