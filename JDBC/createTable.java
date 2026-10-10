package JDBC;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class createTable extends JFrame {

    public createTable() {
        setTitle("Create Table");
        setBounds(50, 50, 500, 300);
        setLayout(null);

        JLabel l = new JLabel("Table Name:");
        l.setBounds(30, 30, 100, 30);
        add(l);

        JTextField t = new JTextField();
        t.setBounds(130, 30, 200, 30);
        add(t);

        JButton b = new JButton("Create");
        b.setBounds(130, 80, 100, 35);
        add(b);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new createTable();
    }
}