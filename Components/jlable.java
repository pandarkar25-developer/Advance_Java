import javax.swing.*;

public class jlable extends JFrame{

    jlable(){
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setVisible(true);
        setLayout(null);
        JLabel l1 = new JLabel("Jay Ganesh");
        JTextField tf = new JTextField();
        JScrollPane js = new JScrollPane();
        tf.setBounds(50,200,200,60);
        
        l1.setBounds(50,50,100,100);//
        //l1.setSize(100,100);

        js.setBounds(50,400,100,100);//
        //l1.setSize(100,100);
        add(l1);
        add(tf);
        add(js);
        setVisible(true);

    }
    public static void main(String[] args) {
       new jlable();

    }
}
