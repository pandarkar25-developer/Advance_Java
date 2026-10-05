import javax.swing.*;
import java.awt.event.*;

public class mouse extends JFrame implements MouseListener {

    JButton btn;

    mouse() {

        btn = new JButton("Click Me");
        btn.setBounds(100, 100, 120, 40);

        btn.addMouseListener(this);

        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(btn);

        setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked");
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse Pressed");
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse Released");
    }

    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse Entered");
    }

    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse Exited");
    }

    public static void main(String[] args) {
        new mouse();
    }
}