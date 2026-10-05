import javax.swing.*;
import java.awt.event.*;

public class item extends JFrame {

    item() {

        JCheckBox cb = new JCheckBox("Java");
        cb.setBounds(50, 50, 100, 40);

        cb.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                if (cb.isSelected()) {
                    System.out.println("Java Selected");
                } else {
                    System.out.println("Java Unselected");
                }
            }
        });

        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(cb);

        setVisible(true);
    }

    public static void main(String[] args) {
        new item();
    }
}