import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

public class jList extends JFrame implements ActionListener {

    JList<String> list;

    public jList() {

        setBounds(50, 50, 500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        String[] languages = {"Java", "Python", "C++", "JavaScript"};

        list = new JList<String>(languages);

        list.setBounds(50, 40, 150, 100);

        list.addListSelectionListener(new ListSelectionListener() {

            
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {
                    JOptionPane.showMessageDialog(
                        jList.this,
                        list.getSelectedValue()
                    );
                }
            }
        });

        add(list);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new jList();
    }
}