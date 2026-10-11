
package JDBC;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class selectSteatment extends JFrame {

    static JTextField t = new JTextField();
    static JTextField t1 = new JTextField();
    static JTextField t2 = new JTextField();
    static JTextField t3 = new JTextField();
    static JTextField t4 = new JTextField();

    static String url = "jdbc:mysql://localhost:3306/clg";
    static String user = "prasanna";
    static String password = "Prasanna@123";

    // Validate table name
    static boolean validTableName(String tableName) {
        if (tableName.isEmpty()) {
            JOptionPane.showMessageDialog(
                null, "Please enter a table name"
            );
            return false;
        }

        if (!tableName.matches("[A-Za-z][A-Za-z0-9_]*")) {
            JOptionPane.showMessageDialog(
                null, "Enter a valid table name"
            );
            return false;
        }

        return true;
    }

    // CREATE TABLE
    static void create() {
        String tableName = t.getText().trim();

        if (!validTableName(tableName)) {
            return;
        }

        String query = "CREATE TABLE IF NOT EXISTS " + tableName
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
                null, "Error: " + exp.getMessage(),
                "Database Error", JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // DELETE TABLE
    static void delete() {
        String tableName = t.getText().trim();

        if (!validTableName(tableName)) {
            return;
        }

        int choice = JOptionPane.showConfirmDialog(
            null,
            "Are you sure you want to delete table '"
                + tableName + "'?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION
        );

        if (choice != JOptionPane.YES_OPTION) {
            return;
        }

        String query = "DROP TABLE " + tableName;

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
                null, "Error: " + exp.getMessage(),
                "Database Error", JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // INSERT DATA
    static void insert() {
        String tableName = t.getText().trim();

        if (!validTableName(tableName)) {
            return;
        }

        try {
            int roll = Integer.parseInt(t2.getText().trim());
            int mark = Integer.parseInt(t4.getText().trim());

            String name = t1.getText().trim();
            String subject = t3.getText().trim();

            if (name.isEmpty() || subject.isEmpty()) {
                JOptionPane.showMessageDialog(
                    null, "Please enter name and subject"
                );
                return;
            }

            String query = "INSERT INTO " + tableName
                + " (roll_no, std_name, sub, mark) VALUES ("
                + roll + ", '" + name.replace("'", "''")
                + "', '" + subject.replace("'", "''")
                + "', " + mark + ")";

            try (
                Connection con = DriverManager.getConnection(
                    url, user, password
                );
                Statement stm = con.createStatement()
            ) {
                stm.executeUpdate(query);

                JOptionPane.showMessageDialog(
                    null, "Data inserted successfully!"
                );
            }

        } catch (NumberFormatException exp) {
            JOptionPane.showMessageDialog(
                null, "Roll and Mark must be valid numbers"
            );
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(
                null, "Error: " + exp.getMessage(),
                "Database Error", JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // SELECT DATA
    static void select() {
        String tableName = t.getText().trim();

        if (!validTableName(tableName)) {
            return;
        }

        String query = "SELECT * FROM " + tableName;

        try (
            Connection con = DriverManager.getConnection(
                url, user, password
            );
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
        ) {
            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Roll No");
            model.addColumn("Name");
            model.addColumn("Subject");
            model.addColumn("Mark");

            while (rs.next()) {
                model.addRow(new Object[] {
                    rs.getInt("roll_no"),
                    rs.getString("std_name"),
                    rs.getString("sub"),
                    rs.getInt("mark")
                });
            }

            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);

            JFrame frame = new JFrame(
                "Records from " + tableName
            );

            frame.add(scrollPane);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
            );
            frame.setVisible(true);

        } catch (Exception exp) {
            JOptionPane.showMessageDialog(
                null, "Error: " + exp.getMessage(),
                "Database Error", JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // GUI CONSTRUCTOR
    public selectSteatment() {
        setTitle("JDBC Table Management");
        setSize(500, 550);
        setLayout(null);

        JLabel l = new JLabel("Table Name:");
        l.setBounds(30, 20, 100, 30);
        add(l);

        t.setBounds(130, 20, 200, 30);
        add(t);

        JButton b = new JButton("Create");
        b.setBounds(30, 65, 100, 35);
        add(b);

        JButton b1 = new JButton("Delete");
        b1.setBounds(145, 65, 100, 35);
        add(b1);

        JButton b3 = new JButton("Select");
        b3.setBounds(260, 65, 100, 35);
        add(b3);

        JLabel l1 = new JLabel("Name:");
        l1.setBounds(30, 125, 100, 30);
        add(l1);

        t1.setBounds(130, 125, 200, 30);
        add(t1);

        JLabel l2 = new JLabel("Roll:");
        l2.setBounds(30, 175, 100, 30);
        add(l2);

        t2.setBounds(130, 175, 200, 30);
        add(t2);

        JLabel l3 = new JLabel("Subject:");
        l3.setBounds(30, 225, 100, 30);
        add(l3);

        t3.setBounds(130, 225, 200, 30);
        add(t3);

        JLabel l4 = new JLabel("Mark:");
        l4.setBounds(30, 275, 100, 30);
        add(l4);

        t4.setBounds(130, 275, 200, 30);
        add(t4);

        JButton b2 = new JButton("Insert");
        b2.setBounds(130, 330, 120, 35);
        add(b2);

        // Create listener
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                create();
            }
        });

        // Delete listener
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });

        // Insert listener
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insert();
            }
        });

        // Select listener
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                select();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new selectSteatment());
    }
}
