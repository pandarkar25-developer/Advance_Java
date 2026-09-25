import javax.swing.*;
import java.awt.event.*;

public class jtextfild extends JFrame implements ActionListener{
    JButton b1 = new JButton("Enter");
    JTextField textField= new JTextField();
    JLabel l1 = new JLabel();
    
    

    public jtextfild(){
        

        setBounds(100,100,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        textField.setBounds(50,60,100,40);
        JLabel jl1 = new JLabel("User Name");
        jl1.setBounds(50,30,100,20);

        l1.setBounds(50,140,200,20);
        
        b1.setBounds(50,100,100,40);
        b1.addActionListener(this);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                l1.setText(textField.getText());
            }
        });
        add(jl1);
        add(textField);
        add(b1);
        add(l1);


        setVisible(true);
        
    }

    @Override 
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==b1){
                
                l1.setText("Hello "+(String)(textField.getText()));
                //l1.setBounds(50,200,200,40);
               
            }
        }

    public static void main(String[] args) {
        new jtextfild();

        
    }
}