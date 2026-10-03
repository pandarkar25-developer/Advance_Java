import javax.swing.*;
import java.awt.event.*;
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

        JButton b =new JButton("Select");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                String da[][]=new String[1][4];
        

                for(int i=0;i<4;i++){
                    da[0][i]=data[jt.getSelectedRow()][i];
                }
                
                JTable t =new JTable(da,columns);

                JScrollPane jp =new JScrollPane(t);
                jp.setBounds(260,30,200,200);
                
                add(jp);
                


            }
        });

        
        b.setBounds(30,350,100,40);

        add(b);
        
        add(jsp);
        setVisible(true);

    }

    public static void main(String[] args) {
        new jTable();
    }
}
