import javax.swing.*;
public class jTable extends JFrame {
    
    

    public jTable(){
        String[] columns = {"ID", "Name", "Age","Lang"};

        String[][] data = {
            {"1", "Rahul", "20","c"},
            {"2", "Amit", "21","c++"},
            {"3", "Priya", "19","java"}
        };
        //JScrollPane jsp =new JScrollPane();

        JTable jt =new JTable(data,columns);
        setBounds(30,30,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        JScrollPane jsp =new JScrollPane(jt);
        jsp.setBounds(30,30,200,200);
        jt.setBounds(30,30,200,200);
        //jsp.add(jt);
        
        add(jsp);
        setVisible(true);

    }

    public static void main(String[] args) {
        new jTable();
    }
}
