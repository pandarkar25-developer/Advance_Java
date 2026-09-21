
import javax.swing.*;
import java.awt.event.*;

public class jbtn extends JFrame implements ActionListener {

    JButton btn;
    JLabel label;

    ImageIcon ic = new ImageIcon("oz.png");

    int b = 170; // Class-level variable

    jbtn() {

        setTitle("Jay Ganesh");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btn = new JButton("Print");

        int a = 50;

        btn.setBounds(50, a, 100, 100);

        btn.setIcon(ic);

        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.setVerticalTextPosition(JButton.BOTTOM);

        add(btn);

        btn.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn) {

            label = new JLabel("Jay Ganesh");

            label.setBounds(50, b, 150, 30);

            b += 30; // Move next label down

            add(label);

            revalidate();
            repaint();
        }
    }

    public static void main(String[] args) {

        new jbtn();
    }
}