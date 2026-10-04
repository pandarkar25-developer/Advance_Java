import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class jTable2 extends JFrame {

    int index = 3;

    public jTable2() {

        String[] columns = {"ID", "Name", "Roll", "Lang"};

        String[][] data = {
            {"1", "Rahul", "20", "c"},
            {"2", "Amit", "21", "c++"},
            {"3", "Priya", "19", "java"}
        };

        DefaultTableModel dm = new DefaultTableModel(data, columns);

        // Fixed: give columns while creating the model
        DefaultTableModel sel = new DefaultTableModel(columns, 0);

        JTable jt = new JTable(dm);

        // Second table
        JTable t = new JTable(sel);

        setBounds(30, 30, 500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JScrollPane jsp = new JScrollPane(jt);
        jsp.setBounds(30, 30, 200, 200);

        JScrollPane jp = new JScrollPane(t);
        jp.setBounds(260, 30, 200, 200);

        JButton b = new JButton("Select");
        b.setBounds(30, 250, 100, 40);

        JButton add = new JButton("Add");
        add.setBounds(30, 300, 100, 40);

        JTextField user = new JTextField();
        user.setBounds(150, 300, 150, 40);
        user.setBorder(
            BorderFactory.createTitledBorder("Name")
        );

        JButton update = new JButton("Update");
        update.setBounds(30, 350, 100, 40);

        JTextField roll = new JTextField();
        roll.setBounds(150, 350, 150, 40);
        roll.setBorder(
            BorderFactory.createTitledBorder("Roll")
        );

        JButton delete = new JButton("Delete");
        delete.setBounds(30, 400, 100, 40);

        JTextField lang = new JTextField();
        lang.setBounds(150, 400, 150, 40);
        lang.setBorder(
            BorderFactory.createTitledBorder("Lang")
        );


        // ADD ROW
        add.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (user.getText().isEmpty()
                        || lang.getText().isEmpty()
                        || roll.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(
                        null,
                        "Fill All Fields Correctly"
                    );

                } else {

                    Object[] a = {
                        ++index,
                        user.getText(),
                        roll.getText(),
                        lang.getText()
                    };

                    dm.addRow(a);

                    user.setText(null);
                    roll.setText(null);
                    lang.setText(null);
                }
            }
        });


        // SELECT ROW
        b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int row = jt.getSelectedRow();

                if (row == -1) {

                    JOptionPane.showMessageDialog(
                        null,
                        "Select Row"
                    );

                    return;
                }

                Object[] da = new Object[4];

                for (int i = 0; i < 4; i++) {

                    da[i] = jt.getValueAt(row, i);
                }

                // Add selected row to second table
                sel.addRow(da);
            }
        });


        // DELETE ROW
        delete.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int n = jt.getSelectedRow();
                int j = t.getSelectedRow();

                if ((n == -1  && j==-1)) {

                    JOptionPane.showMessageDialog(
                        null,
                        "Select Row"
                    );

                } else {
                    if(n!=-1){
                        dm.removeRow(n);
                    }

                    if(j!=-1){
                        sel.removeRow(j);
                    }
                    
                }
            }
        });


        // UPDATE ROW
        update.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int n = jt.getSelectedRow();

                

                String u = user.getText();
                String r = roll.getText();
                String l = lang.getText();

                if (user.getText().isEmpty()
                        || roll.getText().isEmpty()
                        || lang.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(
                        null,
                        "Please Enter All Fields Correctly"
                    );

                    return;
                }

                if (n != -1) {

                    dm.setValueAt(u, n, 1);
                    dm.setValueAt(r, n, 2);
                    dm.setValueAt(l, n, 3);
                }

                user.setText(null);
                roll.setText(null);
                lang.setText(null);
            }
        });


        // ADD COMPONENTS
        add(b);
        add(add);
        add(update);
        add(delete);

        add(user);
        add(roll);
        add(lang);

        add(jsp);
        add(jp);

        setVisible(true);
    }


    public static void main(String[] args) {

        new jTable2();
    }
}