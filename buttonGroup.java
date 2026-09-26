import javax.swing.*;

public class buttonGroup extends JFrame {
    
    public buttonGroup(){
        setBounds(40,40,500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ButtonGroup bg=new ButtonGroup();

        JRadioButton j1 =new JRadioButton("Male");
        j1.setBounds(30,30,100,40);
        JRadioButton j2 =new JRadioButton("Femal");
        j2.setBounds(30,80,100,40);
        JRadioButton j3 =new JRadioButton("Other");
        j3.setBounds(30,130,100,40);

        setLayout(null);

        bg.add(j3);
        bg.add(j2);
        bg.add(j1);

        add(j1);
        add(j2);
        add(j3);


    }

    public static void main(String[] args) {
        new buttonGroup();
    }
}
