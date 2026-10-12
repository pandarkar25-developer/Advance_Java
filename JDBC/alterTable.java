
package JDBC;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.GridLayout;

public class alterTable extends JFrame {

    static JTextField t = new JTextField();
    static JTextField t1 = new JTextField();
    static JTextField t2 = new JTextField();
    static JTextField t3 = new JTextField();
    static JTextField t4 = new JTextField();
    static JTextField t5 = new JTextField();
    static JTextField t6 = new JTextField();

    static final String URL = "jdbc:mysql://localhost:3306/clg";
    static final String USER = "prasanna";
    static final String PASSWORD = "Prasanna@123";

    static Connection connect() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    static boolean validTable(String name) {
        return name.matches("[A-Za-z][A-Za-z0-9_]*");
    }

    static boolean validColumn(String name) {
        return name.matches("[A-Za-z][A-Za-z0-9_]*");
    }

    static String getTableName() {
        String name = t.getText().trim();

        if (!validTable(name)) {
            JOptionPane.showMessageDialog(null,
                    "Enter a valid table name");
            return null;
        }

        return name;
    }

    // CREATE TABLE
    static void create() {
        String table = getTableName();
        if (table == null) return;

        String query = "CREATE TABLE IF NOT EXISTS " + table
                + " (roll_no INT, std_name VARCHAR(50), "
                + "sub VARCHAR(50), mark INT)";

        try (Connection con = connect();
             Statement stm = con.createStatement()) {

            stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null,
                    "Table created successfully!");

        } catch (Exception e) {
            showError(e);
        }
    }

    // DELETE TABLE
    static void delete() {
        String table = getTableName();
        if (table == null) return;

        int confirm = JOptionPane.showConfirmDialog(null,
                "Delete the entire table " + table + "?",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) return;

        String query = "DROP TABLE " + table;

        try (Connection con = connect();
             Statement stm = con.createStatement()) {

            stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null,
                    "Table deleted successfully!");

        } catch (Exception e) {
            showError(e);
        }
    }

    // INSERT DATA
    static void insert() {
        String table = getTableName();
        if (table == null) return;

        String name = t1.getText().trim();
        String subject = t3.getText().trim();

        try {
            int roll = Integer.parseInt(t2.getText().trim());
            int mark = Integer.parseInt(t4.getText().trim());

            String query = "INSERT INTO " + table
                    + " (roll_no, std_name, sub, mark) VALUES ("
                    + roll + ", '" + name.replace("'", "''")
                    + "', '" + subject.replace("'", "''")
                    + "', " + mark + ")";

            try (Connection con = connect();
                 Statement stm = con.createStatement()) {

                stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null,
                        "Data inserted successfully!");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Roll and Mark must be numbers");
        } catch (Exception e) {
            showError(e);
        }
    }

    // UPDATE DATA
    static void update() {
        String table = getTableName();
        if (table == null) return;

        String name = t1.getText().trim();
        String subject = t3.getText().trim();

        try {
            int roll = Integer.parseInt(t2.getText().trim());
            int mark = Integer.parseInt(t4.getText().trim());

            String query = "UPDATE " + table
                    + " SET std_name = '" + name.replace("'", "''")
                    + "', sub = '" + subject.replace("'", "''")
                    + "', mark = " + mark
                    + " WHERE roll_no = " + roll;

            try (Connection con = connect();
                 Statement stm = con.createStatement()) {

                int rows = stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null,
                        rows > 0 ? "Data updated successfully!"
                                 : "No matching roll number found");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Roll and Mark must be numbers");
        } catch (Exception e) {
            showError(e);
        }
    }

    // ADD COLUMN
    static void addColumn() {
        String table = getTableName();
        if (table == null) return;

        String column = t5.getText().trim();
        String type = t6.getText().trim().toUpperCase();

        if (!validColumn(column)) {
            JOptionPane.showMessageDialog(null,
                    "Enter a valid column name");
            return;
        }

        if (!type.matches("INT|FLOAT|DOUBLE|DATE|VARCHAR\\(\\d+\\)")) {
            JOptionPane.showMessageDialog(null,
                    "Use INT, FLOAT, DOUBLE, DATE or VARCHAR(50)");
            return;
        }

        String query = "ALTER TABLE " + table
                + " ADD COLUMN " + column + " " + type;

        try (Connection con = connect();
             Statement stm = con.createStatement()) {

            stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null,
                    "Column added successfully!");

        } catch (Exception e) {
            showError(e);
        }
    }

    // DELETE COLUMN
    static void deleteColumn() {
        String table = getTableName();
        if (table == null) return;

        String column = t5.getText().trim();

        if (!validColumn(column)) {
            JOptionPane.showMessageDialog(null,
                    "Enter a valid column name");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null,
                "Permanently delete column '" + column + "'?",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) return;

        String query = "ALTER TABLE " + table
                + " DROP COLUMN " + column;

        try (Connection con = connect();
             Statement stm = con.createStatement()) {

            stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null,
                    "Column deleted successfully!");

        } catch (Exception e) {
            showError(e);
        }
    }

    static void showError(Exception e) {
        JOptionPane.showMessageDialog(null,
                "Error: " + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public alterTable() {
        setTitle("JDBC Table Manager");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("Table Name:"));
        panel.add(t);

        panel.add(new JLabel("Student Name:"));
        panel.add(t1);

        panel.add(new JLabel("Roll Number:"));
        panel.add(t2);

        panel.add(new JLabel("Subject:"));
        panel.add(t3);

        panel.add(new JLabel("Mark:"));
        panel.add(t4);

        panel.add(new JLabel("Column Name:"));
        panel.add(t5);

        panel.add(new JLabel("Column Data Type:"));
        panel.add(t6);

        JButton b = new JButton("Create Table");
        JButton b1 = new JButton("Delete Table");
        JButton b2 = new JButton("Insert Data");
        JButton b3 = new JButton("Update Data");
        JButton b4 = new JButton("Add Column");
        JButton b5 = new JButton("Delete Column");

        panel.add(b);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);

        add(panel);

        b.addActionListener(e -> create());
        b1.addActionListener(e -> delete());
        b2.addActionListener(e -> insert());
        b3.addActionListener(e -> update());
        b4.addActionListener(e -> addColumn());
        b5.addActionListener(e -> deleteColumn());

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new alterTable());
    }
}
