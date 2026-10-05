import javax.swing.*;
import java.awt.event.*;

public class key extends JFrame implements KeyListener {

    JTextField tf;

    key() {

        tf = new JTextField();
        tf.setBounds(50, 50, 200, 40);

        tf.addKeyListener(this);

        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(tf);

        setVisible(true);
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed");
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released");
    }

    public void keyTyped(KeyEvent e) {
        System.out.println("Key Typed: " + e.getKeyChar());
    }

    public static void main(String[] args) {
        new key();
    }
}