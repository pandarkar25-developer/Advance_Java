import javax.swing.*;
import java.awt.event.*;




public class jPasswordField extends JFrame implements ActionListener{

    JPasswordField pass = new JPasswordField();
    JTextField user =new JTextField();
    JLabel l1 = new JLabel("Username");
    JLabel l2 =new JLabel("Password");
    JButton btn = new JButton("Login");
    JFrame jf1 =new JFrame();
    JOptionPane jop =new JOptionPane();
   

    public jPasswordField(){
        l1.setBounds(30,50,100,40);
        user.setBounds(150,50,100,40);
        l2.setBounds(30,120,100,40);
        pass.setBounds(150,120,100,40);
        setBounds(50,50,500,500);
        setLayout(null);
        setTitle("Login");

        btn.setBounds(100,180,100,50);

        add(l1);
        add(user);
        add(l2);
        add(pass);
        add(btn);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jop.setBounds(100,100,200,200);
                JLabel jl3 =new JLabel("Login Sucessfull");
                jl3.setBounds(25,25,100,50);
                
                if(user.getText().equals("Prasanna") && itmatches(pass.getPassword())){
                    
                    JOptionPane.showMessageDialog(jPasswordField.this, "Login Successful");

                }else{
                    JOptionPane.showMessageDialog(jPasswordField.this, "Login Unsuccessful");
                }
                
            }
        });
    }

    
    static boolean itmatches(char []a){

        char P[]={'p','r','a','s','@','1','2','3'};

        if(a.length!=P.length){
            return false;
        }

        for(int i=0;i<a.length;i++){
            if(a[i]!=P[i]){
                return false;
            }
        }

        return true;
    }


    

    public void actionPerformed(ActionEvent e){

    }

    public static void main(String[] args) {
        new jPasswordField();
    }
}
