package JDBC;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class updateData extends JFrame {

    static JTextField t = new JTextField();
    static JTextField t1 = new JTextField();
    static JTextField t2 = new JTextField();
    static JTextField t3 = new JTextField();
    static JTextField t4 = new JTextField();

    static void create(){
        String tableName = t.getText().trim();

                if (tableName.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        null, "Please enter a table name"
                    );
                    return;
                }

                // Allow only valid SQL table identifiers
                if (!tableName.matches("[A-Za-z][A-Za-z0-9_]*")) {
                    JOptionPane.showMessageDialog(
                        null, "Enter a valid table name"
                    );
                    return;
                }

                String url = "jdbc:mysql://localhost:3306/clg";
                String user = "prasanna";
                String password = "Prasanna@123";

                String query = "CREATE TABLE IF NOT EXISTS "
                        + tableName
                        + " (roll_no INT, std_name VARCHAR(50), "
                        + "sub VARCHAR(50), mark INT)";

                try (
                    Connection con = DriverManager.getConnection(
                        url, user, password
                    );
                    Statement stm = con.createStatement()
                ) {
                    stm.executeUpdate(query);

                    JOptionPane.showMessageDialog(
                        null, "Table '" + tableName
                        + "' created successfully!"
                    );

                } catch (Exception exp) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Error: " + exp.getMessage(),
                        "Database Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            
    }

    static void  delete(){
        
        String tableName = t.getText().trim();

        if (tableName.isEmpty()) {
            JOptionPane.showMessageDialog(
                null, "Please enter a table name"
            );
            return;
        }

        // Allow only valid SQL table identifiers
        if (!tableName.matches("[A-Za-z][A-Za-z0-9_]*")) {
            JOptionPane.showMessageDialog(
                null, "Enter a valid table name"
            );
            return;
        }

        String url = "jdbc:mysql://localhost:3306/clg";
        String user = "prasanna";
        String password = "Prasanna@123";

        String query = "DROP TABLE "
                + tableName;

        try (
            Connection con = DriverManager.getConnection(
                url, user, password
            );
            Statement stm = con.createStatement()
        ) {
            stm.executeUpdate(query);

            JOptionPane.showMessageDialog(
                null, "Table '" + tableName
                + "' deleted successfully!"
            );

        } catch (Exception exp) {
            JOptionPane.showMessageDialog(
                null,
                "Error: " + exp.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    static void insert(){
        String tableName = t.getText().trim();

        if (tableName.isEmpty()) {
            JOptionPane.showMessageDialog(
                null, "Please enter a table name"
            );
            return;
        }

        // Allow only valid SQL table identifiers
        if (!tableName.matches("[A-Za-z][A-Za-z0-9_]*")) {
            JOptionPane.showMessageDialog(
                null, "Enter a valid table name"
            );
            return;
        }

        String url = "jdbc:mysql://localhost:3306/clg";
        String user = "prasanna";
        String password = "Prasanna@123";

        String query = "INSERT INTO "
                + tableName + " (roll_no,std_name,sub,mark) VALUES ( "+Integer.parseInt(t2.getText().trim())+", '"+t1.getText().trim()+"','"+t3.getText().trim()+"', "+Integer.parseInt(t4.getText().trim())+" )";

        try (
            Connection con = DriverManager.getConnection(
                url, user, password
            );
            Statement stm = con.createStatement()
        ) {
            stm.executeUpdate(query);

            JOptionPane.showMessageDialog(
                null, "Table '" + tableName
                + "' data inserted successfully!"
            );

        } catch (Exception exp) {
            JOptionPane.showMessageDialog(
                null,
                "Error: " + exp.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    static void update(){
        String tableName = t.getText().trim();

        if (tableName.isEmpty()) {
            JOptionPane.showMessageDialog(
                null, "Please enter a table name"
            );
            return;
        }

        // Allow only valid SQL table identifiers
        if (!tableName.matches("[A-Za-z][A-Za-z0-9_]*")) {
            JOptionPane.showMessageDialog(
                null, "Enter a valid table name"
            );
            return;
        }

        String url = "jdbc:mysql://localhost:3306/clg";
        String user = "prasanna";
        String password = "Prasanna@123";

        String query = "UPDATE " + tableName +
                        " SET std_name = '" + t1.getText().trim() +
                        "', sub = '" + t3.getText().trim() +
                        "', mark = " + Integer.parseInt(t4.getText().trim()) +
                        " WHERE roll_no = " + Integer.parseInt(t2.getText().trim());

        try (
            Connection con = DriverManager.getConnection(
                url, user, password
            );
            Statement stm = con.createStatement()
        ) {
            stm.executeUpdate(query);

            JOptionPane.showMessageDialog(
                null, "Table '" + tableName
                + "' data updated successfully!"
            );

        } catch (Exception exp) {
            JOptionPane.showMessageDialog(
                null,
                "Error: " + exp.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public updateData() {
        setTitle("Create Table");
        setBounds(50, 50, 500, 300);
        setLayout(null);

        JLabel l = new JLabel("Table Name:");
        l.setBounds(30, 30, 100, 30);
        add(l);

        
        t.setBounds(130, 30, 200, 30);
        add(t);

        JButton b = new JButton("Create");
        b.setBounds(80, 80, 100, 35);
        add(b);

        JButton b1 = new JButton("Delete");
        b1.setBounds(200, 80, 100, 35);
        add(b1);

        JButton b2 = new JButton("Insert");
        b2.setBounds(80, 420, 100, 35);
        add(b2);

        JButton b3 = new JButton("update");
        b3.setBounds(200, 420, 100, 35);
        add(b3);

        JLabel l1 =new JLabel("Name");
        l1.setBounds(30,130,100,50);
        add(l1);

        t1.setBounds(85,130,150,50);
        add(t1);

        JLabel l2 =new JLabel("Roll");
        l2.setBounds(30,200,100,50);
        add(l2);

        t2.setBounds(85,200,150,50);
        add(t2);

        JLabel l3 =new JLabel("Subject");
        l3.setBounds(30,270,100,50);
        add(l3);

        t3.setBounds(85,270,150,50);
        add(t3);

        JLabel l4 =new JLabel("Mark");
        l4.setBounds(30,350,100,50);
        add(l4);

        t4.setBounds(85,350,150,50);
        add(t4);

         

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                create();
            }
        });

         b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insert();
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });

       

        setBounds(50,50,500,600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new updateData();
    }
}