import javax.swing.*;
import java.awt.event.*;

public class jTable extends JFrame {
    
    

    public jTable(){
        String[] columns = {"ID", "Name", "Age"};

        String[][] data = {
            {"1", "Rahul", "20"},
            {"2", "Amit", "21"},
            {"3", "Priya", "19"}
        };

        JTable jt =new JTable(data,columns);
        setBounds(30,30,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        jt.setBounds(30,30,200,200);
        
        add(jt);
        setVisible(true);

    }

    public static void main(String[] args) {
        new jTable();
    }
}
